package com.metanet4j.base.model;

import java.util.List;
import lombok.Data;

@Data
public class Bsocial {

    private String txId;

    private Integer block;

    private List<B> bList;

    private List<BPP> bppList;

    private List<MAP> mapList;

    private List<AIP> aipList;


}
