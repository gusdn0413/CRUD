package com.hyun.CRUD.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDTO {
    private Long id;
    private String title;
    private String content;
}
