package com.metanet4j.base.model;

import lombok.Data;

/**
 * @author 1haodev
 */
@Data
public class Bap extends SortAble{
    /**
     * 交易id
     */
    private String txId;

    /**
     * Block number this transaction was mined into - null if still in mempool
     */
    private Integer block;

    /**
     * 1:ID, 2:ATTEST, 3:DATA, 4:ALIAS,5:REVOKE
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


    private Long timestamp;

    private Bap appendData;




}
