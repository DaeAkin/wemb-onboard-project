package com.wemb.toy.domain.sheet.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class SheetSaveRequest implements Serializable {

    private List<List<String>> rowData;
    private List<ColData> colData;
}
