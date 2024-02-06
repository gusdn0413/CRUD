package com.hyun.CRUD.domain.board.repository;

import com.hyun.CRUD.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, String> {

    Optional<Board> findById(Long boardId);
}
