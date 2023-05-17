package com.example.demo.member.api;

import com.example.demo.common.exception.status2xx.NoContentException;
import com.example.demo.member.api.dto.MemberQueryDto.MemberFindAllParam;
import com.example.demo.member.api.dto.MemberQueryDto.MemberFindAllResponseDto;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.projection.DefaultMemberProjection;
import com.example.demo.member.service.usecase.MemberFindAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberQueryApi {
    private final MemberFindAllUseCase memberFindAllUseCase;

    @GetMapping
    public MemberFindAllResponseDto findAll(
            MemberFindAllParam param,
            @PageableDefault(size = 12, sort = "joinDate", direction = Sort.Direction.DESC) Pageable pageable) {
        // initial pageable -> 0 based indexing
        // client input(page) -> 1 based indexing -> sync to initial pageable policy(: if(pageInput > 0) pageInput -= 1)
        pageable = pageable.previousOrFirst(); // 전처리
        Page<DefaultMemberProjection> memberPage = memberFindAllUseCase.findAllBy(pageable);

        if (memberPage.isEmpty()) throw new NoContentException();

        return MemberFindAllResponseDto.builder()
                .members(memberPage.getContent())
                .lastPage(memberPage.getTotalPages())
                .total(memberPage.getTotalElements())
                .build();
    }
}
