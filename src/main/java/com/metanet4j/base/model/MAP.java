package com.metanet4j.base.model;

import com.metanet4j.base.type.BsocialTypeEnum;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.Data;

@Data
public class MAP extends LinkedHashMap<String, String> {
    public int index;

    private BsocialTypeEnum bsocialTypeEnum;

    private List<String> mapDataList;
}
