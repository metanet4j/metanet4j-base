package com.metanet4j.base.msg;

import cn.hutool.core.date.DateUtil;

import java.io.Serializable;

/**
 * @author 1haodev
 */
public interface MetanetMessage extends Serializable {
     Long timeStamp = DateUtil.current();
}
