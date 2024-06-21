package com.metanet4j.base.bean;

import lombok.Data;

import java.util.List;

@Data
public class BsocialBean {

    protected String txId;

    protected String identityKey;

    protected Integer block;

    protected List<B> bList;

    protected List<BPP> bppList;

    protected List<MAP> mapList;

    protected List<AIP> aipList;

    protected Long processTime;

    protected Long eventTime;
}
