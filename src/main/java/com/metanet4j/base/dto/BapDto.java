package com.metanet4j.base.dto;

import cn.hutool.core.date.DateUtil;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author 1haodev
 */
@Data
public class BapDto {
    /**
     * base58( ripemd160 ( sha256 ( rootAddress ) ) )
     */
    private String identityKey;

    /**
     * 交易id
     */
    private String txId;

    /**
     * Block number this transaction was mined into - null if still in mempool
     */
    private Integer block;

    /**
     * 1:ID, 2:ATTEST, 3:ALIAS, 4:DATA,5:REVOKE
     * [ID|ATTEST|ALIAS|DATA|REVOKE]
     */
    private Integer type;

    /**
     * ID key or attestation hash
     *[ID Key|URN Attestation Hash]
     */
    private String hash;

    /**
     * Sequences number of the attestation, or the address of the ID,or data
     * [Sequence|Address|Data]
     */
    private String sequence;

    /**
     * Bitcoin address this bap transaction was signed with
     */
    private String signatureAddress;

    /**
     * Optional data that was appended to this BAP transaction
     */
    private String data;

    /**
     * is root node or no
     */
    private Integer isRoot;

    /**
     * id destroy or not
     */
    private Integer isDestroy;


    private Long processTime ;

    private Long eventTime;







}
