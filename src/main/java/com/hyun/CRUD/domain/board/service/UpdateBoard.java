package com.hyun.CRUD.domain.board.service;

import com.hyun.CRUD.domain.board.dto.BoardUpdateDTO;
import com.hyun.CRUD.domain.board.entity.Board;
import com.hyun.CRUD.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UpdateBoard {

    private final BoardRepository boardRepository;

    @Transactional
    public boolean updateBoard(BoardUpdateDTO updateDTO, Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(RuntimeException::new);
        String newTitle = updateDTO.getTitle();
        String newContent = updateDTO.getContent();
        board.updateTitle(newTitle);
        board.updateContent(newContent);
        boardRepository.save(board);
        return true;
    }
}
