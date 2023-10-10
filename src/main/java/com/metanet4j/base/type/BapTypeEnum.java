package com.metanet4j.base.type;

import java.util.Arrays;

/**
 * 1:ID, 2:ATTEST, 3:ALIAS, 4:DATA ,5:REVOKE
 * [ID|ATTEST|ALIAS|DATA|REVOKE]
 */
public enum BapTypeEnum {

    ID(1,"ID"),
    ATTEST(2,"ATTEST"),
    ALIAS(3,"ALIAS"),
    DATA(4,"DATA"),
    REVOKE(5,"REVOKE"),
    UNKNOWN(-40000, "UNKNOWN");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    BapTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static BapTypeEnum fromCode(int code){
        return Arrays.stream(BapTypeEnum.values()).filter(o->code==o.getCode()).findFirst().orElse(UNKNOWN);
    }

    public static BapTypeEnum fromDesc(String desc){
        return Arrays.stream(BapTypeEnum.values()).filter(o->o.getDesc().equals(desc)).findFirst().orElse(UNKNOWN);
    }
}
