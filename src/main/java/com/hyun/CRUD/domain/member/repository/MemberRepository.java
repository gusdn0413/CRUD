package com.hyun.CRUD.domain.member.repository;

import com.hyun.CRUD.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findById(Long memberId);
}
