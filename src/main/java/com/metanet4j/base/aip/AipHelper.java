package com.metanet4j.base.aip;

import cn.hutool.core.util.HexUtil;
import com.metanet4j.base.constants.ProtocolConstant;
import com.metanet4j.base.model.Bap;
import com.metanet4j.base.type.BapTypeEnum;
import io.bitcoinsv.bitcoinjsv.core.AddressLite;
import io.bitcoinsv.bitcoinjsv.core.ECKeyLite;
import io.bitcoinsv.bitcoinjsv.core.Sha256Hash;
import io.bitcoinsv.bitcoinjsv.core.Utils;
import io.bitcoinsv.bitcoinjsv.core.VarInt;
import io.bitcoinsv.bitcoinjsv.ecc.ECDSASignature;
import io.bitcoinsv.bitcoinjsv.params.MainNetParams;
import io.bitcoinsv.bitcoinjsv.params.NetworkParameters;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SignatureException;
import java.util.Arrays;
import org.spongycastle.util.encoders.Base64;

/**
 * @author 1haodev
 */
public final class AipHelper {



    public static boolean verifySign(Bap bap,boolean appendData, String signatureBase64) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.writeBytes(HexUtil.decodeHex("6a"));
        bos.writeBytes(ProtocolConstant.BAP_PROTOCOL.getBytes());
        bos.writeBytes(BapTypeEnum.fromCode(bap.getType()).getDesc().getBytes());
        bos.writeBytes(bap.getHash().getBytes());
        bos.writeBytes(bap.getSequence().getBytes());
        bos.writeBytes(HexUtil.decodeHex("7c"));
        if(appendData){
            Bap data = bap.getAppendData();
            bos.writeBytes(ProtocolConstant.BAP_PROTOCOL.getBytes());
            bos.writeBytes(BapTypeEnum.fromCode(data.getType()).getDesc().getBytes());
            bos.writeBytes(data.getHash().getBytes());
            bos.writeBytes(data.getSequence().getBytes());
            bos.writeBytes(HexUtil.decodeHex("7c"));
        }
        return AipHelper.verifySign(bap.getSignatureAddress(), signatureBase64, bos.toByteArray());
    }

    public static boolean verifySign(String signAddress, String signatureBase64 ,byte[] messageBytes) {
        return verifySign(signAddress,signatureBase64,messageBytes,MainNetParams.get());

    }

    public static boolean verifySign(String signAddress, String signatureBase64 ,String message) {
        return verifySign(signAddress,signatureBase64,message.getBytes(),MainNetParams.get());

    }

    public static boolean verifySign(String signAddress, String signatureBase64 ,String message, NetworkParameters networkParameters) {
        return verifySign(signAddress,signatureBase64,message.getBytes(),networkParameters);

    }

    public static boolean verifySign(String signAddress,String signatureBase64 , byte[] messageBytes, NetworkParameters networkParameters) {
        if(networkParameters==null){
            networkParameters=MainNetParams.get();
        }
        try {
            ECKeyLite keyLite = signedMessageBytesToKey(messageBytes, signatureBase64);

            AddressLite addressLite =new AddressLite(networkParameters,keyLite.getPubKeyHash());
            String s = addressLite.toBase58();
            return signAddress.equals(s);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        return false;
    }


    private static byte[] formatMessageBytesForSigning(byte[] messageBytes) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bos.write(Utils.BITCOIN_SIGNED_MESSAGE_HEADER_BYTES.length);
            bos.write(Utils.BITCOIN_SIGNED_MESSAGE_HEADER_BYTES);
            VarInt size = new VarInt(messageBytes.length);
            bos.write(size.encode());
            bos.write(messageBytes);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);  // Cannot happen.
        }
    }


    private static ECKeyLite signedMessageBytesToKey(byte[] messageBytes, String signatureBase64) throws SignatureException {
        byte[] signatureEncoded;
        try {
            signatureEncoded = Base64.decode(signatureBase64);
        } catch (RuntimeException e) {
            // This is what you get back from Bouncy Castle if base64 doesn't decode :(
            throw new SignatureException("Could not decode base64", e);
        }
        // Parse the signature bytes into r/s and the selector value.
        if (signatureEncoded.length < 65)
            throw new SignatureException("Signature truncated, expected 65 bytes and got " + signatureEncoded.length);
        int header = signatureEncoded[0] & 0xFF;
        // The header byte: 0x1B = first key with even y, 0x1C = first key with odd y,
        //                  0x1D = second key with even y, 0x1E = second key with odd y
        if (header < 27 || header > 34)
            throw new SignatureException("Header byte out of range: " + header);
        BigInteger r = new BigInteger(1, Arrays.copyOfRange(signatureEncoded, 1, 33));
        BigInteger s = new BigInteger(1, Arrays.copyOfRange(signatureEncoded, 33, 65));
        ECDSASignature sig = new ECDSASignature(r, s);
        // Note that the C++ code doesn't actually seem to specify any character encoding. Presumably it's whatever
        // JSON-SPIRIT hands back. Assume UTF-8 for now.
        Sha256Hash messageHash = Sha256Hash.twiceOf(formatMessageBytesForSigning(messageBytes));
        boolean compressed = false;
        if (header >= 31) {
            compressed = true;
            header -= 4;
        }
        int recId = header - 27;
        ECKeyLite key = ECKeyLite.recoverFromSignature(recId, sig, messageHash, compressed);
        if (key == null)
            throw new SignatureException("Could not recover public key from signature");
        return key;
    }
}
