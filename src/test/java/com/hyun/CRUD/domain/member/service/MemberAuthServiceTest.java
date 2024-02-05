package com.hyun.CRUD.domain.member.service;

import com.hyun.CRUD.domain.member.dto.MemberSaveRequestDTO;
import com.hyun.CRUD.domain.member.entity.Member;
import com.hyun.CRUD.domain.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@SpringBootTest
@Transactional
class MemberAuthServiceTest {
    @Autowired
    private MemberAuthService memberAuthService;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void joinTest() {
        MemberSaveRequestDTO saveRequestDTO = new MemberSaveRequestDTO("test", "test");
        boolean joinResult = memberAuthService.join(saveRequestDTO);
        assertThat(joinResult).isTrue();
    }
}