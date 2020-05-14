package com.wemb.toy.domain.sheet.dto;

import lombok.Data;

import java.util.List;

@Data
public class SheetMessage {

    private String name;
    private List<List<String>> rowData;
    private List<ColData> colData;
    private int row;
    private int col;
    private String cellValue;
    private int index;
    private String title;
    private int width;
    private int height;
    private String username;

}
