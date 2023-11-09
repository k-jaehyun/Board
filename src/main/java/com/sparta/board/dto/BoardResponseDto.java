package com.sparta.board.dto;

import com.sparta.board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String name;
    private String content;
//    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiredAt;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.name = board.getName();
        this.content = board.getContent();
//        this.password = board.getPassword();
        this.createdAt = board.getCreatedAt();
        this.modifiredAt = board.getModifiedAt();
    }
}
