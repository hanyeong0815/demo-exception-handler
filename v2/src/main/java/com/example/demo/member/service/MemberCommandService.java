package com.example.demo.member.service;

import com.example.demo.member.api.dto.MemberCommandDto.MemberSignUpRequestDto;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.type.MemberStatus;
import com.example.demo.member.mapper.MemberMapper;
import com.example.demo.member.repository.MemberJpaRepository;
import com.example.demo.member.service.usecase.MemberModificationUseCase;
import com.example.demo.member.service.usecase.MemberSignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class MemberCommandService implements MemberSignUpUseCase, MemberModificationUseCase {
    private final MemberJpaRepository memberJpaRepository;
    private final MemberMapper memberMapper;

    // 메서드를 두 개로 만든 이유: 서비스 레이어가 DTO를 받으면 -> 편의성은 Up 확장성은 Down
    @Override
    public Member signUp(Member member) {
        return memberJpaRepository.save(member);
    }

    @Override
    public Member signUp(MemberSignUpRequestDto dto, MemberStatus status) {
        return signUp(memberMapper.toEntity(dto, status));
    }
}
