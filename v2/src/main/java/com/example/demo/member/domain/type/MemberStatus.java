package com.example.demo.member.domain.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MemberStatus {
    @JsonProperty("pending") // Request status=pending => map to MemberStatus.PENDING for MemberStatus status;
    PENDING(false),
    @JsonProperty("active")
    ACTIVE(true),
    /** BLOCKED */
    @JsonProperty("suspended")
    SUSPENDED(false),
    @JsonProperty("protected")
    PROTECTED(false),
    @JsonProperty("sleep")
    SLEEP(false),
    @JsonProperty("removed")
    REMOVED(false);

    final boolean canSignIn; // <- 이처럼어느 수준까지 코드 종속적인 관리를 허용할지 의사결정이 필요하다. 지금은 내용 바꾸려면 재배포.
}
