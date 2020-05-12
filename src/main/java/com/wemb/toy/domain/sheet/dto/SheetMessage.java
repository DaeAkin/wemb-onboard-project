package com.wemb.toy.domain.sheet.dto;

import lombok.Data;

@Data
public class SheetMessage {

//    private MessageType type;
    private int col; // 행
    private int row; // 열
    private String content; // 셀안의 내용
    private int width;
    private int height;

}
