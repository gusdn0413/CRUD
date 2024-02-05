package com.hyun.CRUD.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDTO {

    private Long id;
    private String name;
    private String password;
}
