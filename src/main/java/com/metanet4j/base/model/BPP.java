package com.metanet4j.base.model;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BPP extends SortAble implements Protocol{

    @NotEmpty
    private String action;
    @NotEmpty
    private String currency;
    @NotEmpty
    private String address;
    @NotEmpty
    private String apiEndpoint;

    @Override
    public String getProtocolPrefix() {
        return "BPP";
    }
}
