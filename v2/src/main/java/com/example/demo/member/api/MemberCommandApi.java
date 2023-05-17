package com.example.demo.member.api;

import com.example.demo.member.api.dto.MemberCommandDto.MemberSignUpRequestDto;
import com.example.demo.member.api.dto.MemberCommandDto.MemberSignUpResponseDto;
import com.example.demo.member.domain.type.MemberStatus;
import com.example.demo.member.service.usecase.MemberSignUpUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// CQRS -> 큰 시스템에서 적용하는 편.
// DB Lock 같은 것들 때문에 조회 성능에 영향 안 주기 위해서 -> 원본(변경 작업 -> command) DB / 조회용(query) DB
// DB까지 나눠서 다루는 거는 약간 번거롭 -> 초기에 이렇게까진 안 하더라도 -> 이걸 나중에 도입하기 편하게 API/Service/... 작성.

@RestController
@RequiredArgsConstructor
public class MemberCommandApi {
    private final MemberSignUpUseCase memberSignUpUseCase;

    @PostMapping("/sign-up")
    public MemberSignUpResponseDto signUp(@RequestBody @Valid MemberSignUpRequestDto body) {
        // NOTE: 일반 회원가입 유형 Member Status: ACTIVE
        memberSignUpUseCase.signUp(body, MemberStatus.ACTIVE);

        return MemberSignUpResponseDto.builder()
                .success(true)
                .build();
    }
}
