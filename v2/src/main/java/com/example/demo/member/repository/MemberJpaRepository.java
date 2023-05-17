package com.example.demo.member.repository;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.projection.DefaultMemberProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Page<DefaultMemberProjection> findAllBy(Pageable pageable);
}
