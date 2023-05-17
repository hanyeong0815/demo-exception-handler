package com.example.demo.member.service.usecase;

import com.example.demo.member.api.dto.MemberCommandDto.MemberSignUpRequestDto;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.type.MemberStatus;

public interface MemberSignUpUseCase {
    Member signUp(Member member);
    Member signUp(MemberSignUpRequestDto dto, MemberStatus status);
}
