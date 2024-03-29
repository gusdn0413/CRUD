package com.hyun.CRUD.domain.board.service;

import com.hyun.CRUD.domain.board.dto.BoardSaveRequestDTO;
import com.hyun.CRUD.domain.board.entity.Board;
import com.hyun.CRUD.domain.board.repository.BoardRepository;
import com.hyun.CRUD.domain.member.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateBoard {

    private final BoardRepository boardRepository;

    @Transactional
    public boolean createBoard(BoardSaveRequestDTO requestDTO,Long memberId) {
        try {
            Board board = new Board(requestDTO.getTitle(), requestDTO.getContent(), requestDTO.getMemberId());
            boardRepository.save(board);
            return true;
        } catch (EntityNotFoundException e) {
            return false;
        }
    }

}
