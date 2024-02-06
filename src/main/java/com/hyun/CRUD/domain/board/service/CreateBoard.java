package com.hyun.CRUD.domain.board.service;

import com.hyun.CRUD.domain.board.dto.BoardSaveRequestDTO;
import com.hyun.CRUD.domain.board.entity.Board;
import com.hyun.CRUD.domain.board.repository.BoardRepository;
import com.hyun.CRUD.domain.member.entity.Member;
import com.hyun.CRUD.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateBoard {

    private final BoardRepository boardRepository;

    public boolean createBoard(BoardSaveRequestDTO requestDTO,Long memberId) {
        Member member = Member.builder()
                .id(memberId)
                .build();
        Board board = new Board(requestDTO.getTitle(), requestDTO.getContent(), requestDTO.getMemberId());
        boardRepository.save(board);
        return true;
    }
}
