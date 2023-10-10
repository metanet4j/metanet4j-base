package com.metanet4j.base.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BapSigner {

    /**
     * Bitcoin signer address，from
     * （[Sequence|Address|Data]）
     */
    private String address;

    /**
     * The transaction ID when this address was put into use
     */
    private String txId;

    /**
     * sign parent address for this adddress transaction
     * from aip signatureAddress
     * is root,this mean rootAddress
     */
    private String signatureAddress;

    /**
     * bap_id identityKey
     */
    private String identityKey;

    /**
     * The block this signing address was mined, if applicable, otherwise still in mempool
     */
    private Integer block;

    /**
     * is current address for this identity
     */
    private Integer isCurrent;

    private Long timestamp;

    private LocalDateTime createTime;


}
