package com.hyun.CRUD.domain.member.service;

import com.hyun.CRUD.domain.member.dto.MemberUpdateDTO;
import com.hyun.CRUD.domain.member.entity.DeletedMember;
import com.hyun.CRUD.domain.member.entity.Member;
import com.hyun.CRUD.domain.member.repository.DeletedMemberRepository;
import com.hyun.CRUD.domain.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DeletedMemberRepository deletedMemberRepository;

    @Test
    void updateMemberTest() {
        //given
        Member member = Member.builder()
                .name("test")
                .password("test")
                .build();
        Member savedMember = memberRepository.save(member);
        Long memberId = savedMember.getId();
        MemberUpdateDTO updateDTO = new MemberUpdateDTO("update", "update");

        //when
        boolean updateResult = memberService.updateMember(memberId, updateDTO);

        //then
        assertThat(updateResult).isTrue();

        Optional<Member> updateMemberData = memberRepository.findById(memberId);
        if (updateMemberData.isPresent()) {
            Member updateMember = updateMemberData.get();
            System.out.println("savedMember.getId() = " + savedMember.getId());
            System.out.println("savedMember.getName() = " + savedMember.getName());
            System.out.println("savedMember.getPassword() = " + savedMember.getPassword());
            System.out.println("updateMember.getId() = " + updateMember.getId());
            System.out.println("updateMember.getName() = " + updateMember.getName());
            System.out.println("updateMember.getPassword() = " + updateMember.getPassword());
        }
    }

    @Test
    public void deleteMemberTest() throws Exception {
        //given
        Member member = Member.builder()
                .name("test")
                .password("test")
                .build();
        Member savedMember = memberRepository.save(member);
        //when
        boolean isDeleted = memberService.deleteMember(savedMember.getId());
        Optional<DeletedMember> deletedMemberId = deletedMemberRepository.findById(savedMember.getId());
        DeletedMember deletedMember = deletedMemberId.get();
        //then
        assertThat(savedMember.getId()).isEqualTo(deletedMember.getId());
        assertThat(isDeleted).isTrue();
    }
}