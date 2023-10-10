package com.metanet4j.base.dto;

import lombok.Data;


@Data
public class BitcoinSchemaDto {



    public BitcoinSchemaDto(BapDto bapDto) {
        this.bapDto = bapDto;
    }

    public BitcoinSchemaDto(BapDto bapDto, String signatureAddress, String identityKey) {
        this.bapDto = bapDto;
        this.signatureAddress = signatureAddress;
        this.identityKey = identityKey;
    }


    public BitcoinSchemaDto(BsocialDto bsocialDto) {
        this.bsocialDto = bsocialDto;
    }

    public BitcoinSchemaDto(BsocialDto bsocialDto, String signatureAddress, String identityKey) {
        this.bsocialDto = bsocialDto;
        this.signatureAddress = signatureAddress;
        this.identityKey = identityKey;
    }


    private BapDto bapDto;

    private BsocialDto bsocialDto;

    private String signatureAddress;

    private String identityKey;


    private Long processTime ;

    private Long eventTime;


}
