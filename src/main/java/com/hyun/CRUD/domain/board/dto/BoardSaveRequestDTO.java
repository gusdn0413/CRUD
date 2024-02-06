package com.hyun.CRUD.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardSaveRequestDTO {

    private Long memberId;
    private String title;
    private String content;
}
