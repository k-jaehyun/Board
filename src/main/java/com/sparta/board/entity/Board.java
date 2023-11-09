package com.sparta.board.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name="name")
    private String name;
    @Column(name="content",length = 5000)
    private String content;
    @Column(name="password",nullable = false)
    private String password;

}
