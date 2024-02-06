package com.hyun.CRUD.domain.member.repository;

import com.hyun.CRUD.domain.member.entity.Member;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findById(Long memberId);

    Optional<Member> findByName(String name);

}
