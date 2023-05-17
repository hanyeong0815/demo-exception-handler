package com.example.demo.member.service;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.projection.DefaultMemberProjection;
import com.example.demo.member.repository.MemberJpaRepository;
import com.example.demo.member.service.usecase.MemberFindAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class MemberQueryService implements MemberFindAllUseCase {
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public List<Member> findAll() {
        return memberJpaRepository.findAll();
    }

    @Override
    public Page<Member> findAll(Pageable pageable) {
        return memberJpaRepository.findAll(pageable);
    }

    @Override
    public Page<DefaultMemberProjection> findAllBy(Pageable pageable) {
        return memberJpaRepository.findAllBy(pageable);
    }
}
