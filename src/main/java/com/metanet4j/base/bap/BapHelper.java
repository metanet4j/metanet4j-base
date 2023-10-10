package com.metanet4j.base.bap;

import com.metanet4j.base.dto.BapDto;
import com.metanet4j.base.model.Bap;
import com.metanet4j.base.type.BapTypeEnum;
import io.bitcoinsv.bitcoinjsv.core.Base58;
import io.bitcoinsv.bitcoinjsv.core.Sha256Hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * @author 1haodev
 */
public final class BapHelper {

    public static boolean isRootAddress(String rootAddress, String identityKey) {
        byte[] hash = Sha256Hash.hash(rootAddress.getBytes());
        Security.addProvider(new BouncyCastleProvider());
        try {
            MessageDigest md = MessageDigest.getInstance("RipeMD160");
            return identityKey.equals(Base58.encode(md.digest(hash)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getIdentityKey(String rootAddress) {
        byte[] hash = Sha256Hash.hash(rootAddress.getBytes());
        Security.addProvider(new BouncyCastleProvider());
        try {
            MessageDigest md = MessageDigest.getInstance("RipeMD160");
            return Base58.encode(md.digest(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isRootBap(BapDto bap) {
        if(bap.getType()== BapTypeEnum.ID.getCode() && isRootAddress(bap.getSignatureAddress(),bap.getHash())&&!"0".equals(bap.getSequence())){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isRootBap(Bap bap) {
        if(bap.getType()== BapTypeEnum.ID.getCode() && isRootAddress(bap.getSignatureAddress(),bap.getHash())&&!"0".equals(bap.getSequence())){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDestroyBap(Bap bap) {
        if(bap.getType()== BapTypeEnum.ID.getCode() && isRootAddress(bap.getSignatureAddress(),bap.getHash())&&"0".equals(bap.getSequence())){
            return true;
        }else{
            return false;
        }
    }


}
