package com.hyun.CRUD.domain.board.service;

import com.hyun.CRUD.domain.board.dto.BoardResponseDTO;
import com.hyun.CRUD.domain.board.entity.Board;
import com.hyun.CRUD.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FindBoard {
    private final BoardRepository boardRepository;

    public BoardResponseDTO findBoard(Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(RuntimeException::new);
        BoardResponseDTO responseDTO = new BoardResponseDTO();
        responseDTO.setId(board.getId());
        responseDTO.setTitle(board.getTitle());
        responseDTO.setContent(board.getContent());
        return responseDTO;
    }
}
