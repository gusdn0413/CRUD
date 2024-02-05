package com.hyun.CRUD.domain.comment.entity;

import com.hyun.CRUD.domain.board.entity.Board;
import com.hyun.CRUD.domain.member.entity.DeletedMember;
import com.hyun.CRUD.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "COMMENT_NAME")
    private Long id;
    @Column(name = "COMMENT_CONTENT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "DELETED_MEMBER_ID")
    private DeletedMember deletedMember;
    @ManyToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;
}
