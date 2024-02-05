package com.hyun.CRUD.domain.board.entity;

import com.hyun.CRUD.domain.comment.entity.Comment;
import com.hyun.CRUD.domain.user.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long id;
    @Column(name = "BOARD_TITLE")
    private String title;
    @Column(name = "BOARD_CONTENT")
    private String content;
    @Column(name = "BOARD_PASSWORD")
    private String password;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();
}
