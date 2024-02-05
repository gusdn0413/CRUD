package com.hyun.CRUD.domain.comment.repository;

import com.hyun.CRUD.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {

}
