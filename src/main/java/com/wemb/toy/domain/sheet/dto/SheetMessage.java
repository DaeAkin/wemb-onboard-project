package com.wemb.toy.domain.sheet.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class SheetMessage {


//    private MessageType type;
//    private int col; // 행
//    private int row; // 열
//    private String content; // 셀안의 내용
//    private int width;
//    private int height;

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
