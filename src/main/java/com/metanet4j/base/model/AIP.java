package com.metanet4j.base.model;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AIP extends SortAble {


    @NotEmpty
    private String algorithm;

    @NotEmpty
    private String signatureAddress;
    private String signature;
    private List<Integer> localList;
    private boolean verified;
}
