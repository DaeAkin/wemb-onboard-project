package com.wemb.toy.domain.sheet.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class RowData implements Serializable {

    private List<String> rowData;
}
