package com.metanet4j.base.bean;

import lombok.Data;

import java.util.List;

@Data
public class AIP {

    private String algorithm;
    private String signatureAddress;
    private String signature;
    private List<Integer> index;
}
