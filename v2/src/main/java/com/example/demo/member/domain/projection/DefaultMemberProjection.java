package com.example.demo.member.domain.projection;

import com.example.demo.member.domain.type.MemberStatus;

public record DefaultMemberProjection(
        String username,
        String name,
        Integer age,
        MemberStatus status
) {
}
