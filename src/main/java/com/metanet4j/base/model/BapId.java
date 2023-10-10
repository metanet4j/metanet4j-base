package com.metanet4j.base.model;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author 1haodev
 * @since 2022-05-14
 */
@Data
public class BapId  extends SortAble{


    /**
     * base58( ripemd160 ( sha256 ( rootAddress ) ) )
     */
    private String identityKey;

    /**
     * The root address for this identity that can be used to destroy it
     */
    private String rootAddress;

    /**
     * JSON stringified object with identity information
     */
    private String identity;

    /**
     * Transaction ID of the identity information
     */
    private String txId;

    /**
     * When this ID was first seen(block number) on the network
     */
    private Integer block;

    private Long timestamp;

    private LocalDateTime createTime;

    /**
     * 0：no；1：yes
     */
    private Integer isDestroy;


}
