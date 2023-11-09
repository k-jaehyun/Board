package com.sparta.board.entity;

import com.sparta.board.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "board")
@NoArgsConstructor
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="name")
    private String name;
    @Column(name="content",length = 5000)
    private String content;
    @Column(name="password",nullable = false)
    private String password;

    public Board(BoardRequestDto requestDto) {
        this.title= requestDto.getTitle();
        this.name= requestDto.getName();
        this.content= requestDto.getContent();
        this.password = requestDto.getPassword();
    }

    public void update(BoardRequestDto requestDto) {
        this.title= requestDto.getTitle();
        this.name= requestDto.getName();
        this.content= requestDto.getContent();
    }
}
