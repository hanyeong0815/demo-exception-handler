package com.example.demo.member.api.dto;

import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.projection.DefaultMemberProjection;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

public record MemberQueryDto() {
    public record MemberFindAllParam(
            String keyword,
            GpSearchColumn type
    ) {
        public enum GpSearchColumn { // General Purpose Search Column
            @JsonProperty("username")
            USERNAME,
            @JsonProperty("name")
            name
        }
    }

    @Builder
    public record MemberFindAllResponseDto(
            List<DefaultMemberProjection> members,
            Integer lastPage,
            Long total
    ) {}
}
