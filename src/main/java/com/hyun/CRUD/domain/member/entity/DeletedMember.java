package com.hyun.CRUD.domain.member.entity;

import com.hyun.CRUD.domain.board.entity.Board;
import com.hyun.CRUD.domain.comment.entity.Comment;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "DELETED_MEMBER")
public class DeletedMember {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "MEMBER_NAME")
    private String name;
    @Column(name = "MEMBER_PASSWORD")
    private String password;
    @Column(name = "MEMBER_DELETED")
    private boolean isDeleted = true;
    @OneToMany(mappedBy = "deletedMember")
    private List<Board> boards = new ArrayList<>();
    @OneToMany(mappedBy = "deletedMember")
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public DeletedMember(Long id, String name, String password) {
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
