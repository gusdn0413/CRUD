package com.hyun.CRUD.domain.member.entity;

import com.hyun.CRUD.domain.board.entity.Board;
import com.hyun.CRUD.domain.comment.entity.Comment;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "MEMBER")
@SQLDelete(sql = "UPDATE member SET isDeleted = true WHERE id = ?")
@SQLRestriction("isDeleted = false")
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "MEMBER_NAME")
    private String name;
    @Column(name = "MEMBER_PASSWORD")
    private String password;
    @Column(name = "ISDELETED")
    private boolean isDeleted;
    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Member(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void softDelete() {
        this.isDeleted = true;
    }
}
