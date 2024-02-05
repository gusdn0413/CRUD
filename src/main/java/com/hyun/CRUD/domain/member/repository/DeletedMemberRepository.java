package com.hyun.CRUD.domain.member.repository;

import com.hyun.CRUD.domain.member.entity.DeletedMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeletedMemberRepository extends JpaRepository<DeletedMember, String> {

    Optional<DeletedMember> findById(Long deleteMemberId);
}
