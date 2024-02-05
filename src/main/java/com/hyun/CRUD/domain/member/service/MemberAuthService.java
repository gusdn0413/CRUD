package com.hyun.CRUD.domain.member.service;

import com.hyun.CRUD.domain.member.dto.MemberSaveRequestDTO;
import com.hyun.CRUD.domain.member.entity.Member;
import com.hyun.CRUD.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberAuthService {

    private final MemberRepository memberRepository;

    @Transactional
    public boolean join(MemberSaveRequestDTO requestDTO) {
        Member member = saveRequestDTOtoMember(requestDTO);
        memberRepository.save(member);
        return true;
    }

    public boolean login(String name, String password) {
        Optional<Member> findMember = memberRepository.findByIsDeletedFalse(name);
        if (findMember.isPresent()) {
            Member member = findMember.get();
            return member.getPassword().equals(password);
        }
        return false;
    }

    private Member saveRequestDTOtoMember(MemberSaveRequestDTO requestDTO) {
        return Member.builder()
                .name(requestDTO.getName())
                .password(requestDTO.getPassword())
                .build();
    }
}
