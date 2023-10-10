package com.metanet4j.base.dto;


import com.metanet4j.base.type.BsocialTypeEnum;
import java.util.LinkedHashMap;
import java.util.List;
import lombok.Data;

@Data
public class BsocialDto {

    private String txId;

    private String identityKey;

    private Integer block;

    private String signatureAddress;

    private List<B> bList;

    private List<BPP> bppList;

    private List<MAP> mapList;

    private List<AIP> aipList;


    private Long processTime ;

    private Long eventTime;


    @Data
    public static class B{
        private String content;
        private int length;
        private String url;
        private String contentType;
        private String encoding;

        private String filename;

        private String mimeType;

        private boolean encrypted;

    }
    @Data
    public static class BPP{
        private String action;
        private String currency;
        private String address;
        private String apiEndpoint;
    }

    @Data
    public static class MAP extends LinkedHashMap<String, String> {
        private BsocialTypeEnum bsocialTypeEnum;
    }

    @Data
    public static class AIP{

        private String algorithm;
        private String signatureAddress;
        private String signature;
        private List<Integer> index;
    }

}
