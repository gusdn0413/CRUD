package com.hyun.CRUD.domain.member.repository;

import com.hyun.CRUD.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findById(Long memberId);

    Optional<Member> findByName(String name);

    @Query("SELECT m FROM Member m WHERE m.isDeleted = false")
    Optional<Member> findByIsDeletedFalse(String name);
}
