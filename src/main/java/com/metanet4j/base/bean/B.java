package com.metanet4j.base.bean;

import lombok.Data;

@Data
public class B {
    private String content;
    private int length;
    private String url;
    private String contentType;
    private String encoding;

    private String filename;

    private String mimeType;

    private boolean encrypted;

}