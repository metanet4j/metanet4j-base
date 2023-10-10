package com.metanet4j.base.model;

import java.nio.ByteBuffer;
import lombok.Data;

@Data
public class B extends SortAble{

    private String content;
    private int length;
    private String url;
    private String contentType;
    private String encoding;
    private String filename;


    private String mimeType;

    private boolean encrypted;

    private ByteBuffer byteBuffer;


}
