package com.metanet4j.base.bean;

import com.metanet4j.base.type.BsocialTypeEnum;
import lombok.Data;

import java.util.LinkedHashMap;

@Data
public class MAP extends LinkedHashMap<String, String> {
    private BsocialTypeEnum bsocialTypeEnum;
    private String bsocialType;
}