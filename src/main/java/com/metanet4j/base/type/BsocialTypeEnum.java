package com.metanet4j.base.type;

import java.util.Arrays;

/**
 * bsocial protocol type
 */
public enum BsocialTypeEnum {

    POST(1,"post"),
    REPOST(2,"repost"),
    LIKE(3,"like"),
    FOLLOW(4,"follow"),
    ATTACHMENT(5,"attachment"),
    TIP(6,"tip"),
    PAYMENT(7,"payment"),
    REPLY(8,"post"),
    TAGS(9,"tags"),
    UNFOLLOW(10,"unfollow"),
    FRIEND(11,"friend"),
    UNLIKE(12,"unlike"),
    UNFRIEND(13,"unfriend"),
    UNKNOWN(-40000, "UNKNOWN");

    private int code;
    private String desc;

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    BsocialTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static BsocialTypeEnum fromCode(int code){
        return Arrays.stream(BsocialTypeEnum.values()).filter(o->code==o.getCode()).findFirst().orElse(UNKNOWN);
    }

    public static BsocialTypeEnum fromDesc(String desc){
        return Arrays.stream(BsocialTypeEnum.values()).filter(o->o.getDesc().equals(desc)).findFirst().orElse(UNKNOWN);
    }
}
