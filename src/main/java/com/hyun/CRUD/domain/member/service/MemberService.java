package com.hyun.CRUD.domain.member.service;

import com.hyun.CRUD.domain.member.dto.MemberResponseDTO;
import com.hyun.CRUD.domain.member.dto.MemberUpdateDTO;
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
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public boolean updateMember(Long memberId, MemberUpdateDTO updateDTO) {
        Optional<Member> findMember = memberRepository.findById(memberId);
        if (findMember.isPresent()) {
            Member member = findMember.get();
            String newName = updateDTO.getName();
            String newPassword = updateDTO.getPassword();
            member.updateName(newName);
            member.updatePassword(newPassword);
            return true;
        } else {
            log.error("id가 없습니다");
            return false;
        }
    }

    public MemberResponseDTO findMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
        MemberResponseDTO responseDTO = new MemberResponseDTO();
        responseDTO.setId(member.getId());
        responseDTO.setName(member.getName());
        return responseDTO;
    }

    @Transactional
    public boolean deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(RuntimeException::new);
        member.softDelete();
        memberRepository.save(member);

        return true;
    }
}
