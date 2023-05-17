package com.example.demo.member.service.usecase;

import com.example.demo.common.support.usecase.BaseFindAllUseCase;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.projection.DefaultMemberProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberFindAllUseCase extends BaseFindAllUseCase<Member> {
    @Override
    List<Member> findAll();

    @Override
    Page<Member> findAll(Pageable pageable);
    Page<DefaultMemberProjection> findAllBy(Pageable pageable);
}
