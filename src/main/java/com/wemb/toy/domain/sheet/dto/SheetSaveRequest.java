package com.wemb.toy.domain.sheet.dto;

import lombok.Data;

import java.util.List;
@Data
public class SheetSaveRequest {

    private List<List<String>> rowData;
    private List<ColData> colData;
}
