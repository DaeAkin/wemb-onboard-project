package com.wemb.toy.domain.sheet.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ColData implements Serializable {
    private String type;
    private String title;
    private Integer width;
}
