package com.example.songjava.board.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class Board {

    @ApiModelProperty(value = "게시물 번호", example = "2")
    private int boardSeq;
    @ApiModelProperty(value = "제목", example="무제")
    private String title;
    @ApiModelProperty(value = "본문", example="테스트")
    private String contents;
    @ApiModelProperty(hidden = true)
    private Date regDate;
}
