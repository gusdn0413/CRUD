package com.hyun.CRUD.domain.board.service;

import com.hyun.CRUD.domain.board.entity.Board;
import com.hyun.CRUD.domain.board.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeleteBoard {
    private final BoardRepository boardRepository;

    @Transactional
    public boolean deleteBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(EntityNotFoundException::new);
        board.softDelete();

        boardRepository.save(board);
        return true;
    }
}
