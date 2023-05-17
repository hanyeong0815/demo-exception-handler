package com.example.demo.member.domain;

import com.example.demo.common.support.persistence.BaseEntity;
import com.example.demo.member.domain.type.MemberStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;

import java.time.OffsetDateTime;
import java.time.ZoneId;

@Entity
public final class Member extends BaseEntity {
    // NOTE: DDL 관리 주체는 (거의) 온전히 Flyway에 위탁하니까, 테이블 생성과 관련된 @Column 등을 작성하지 않아도 된다.
    public String username; // getter/setter 안 써도 엔티티 매핑 호환 확인(Getter/Setter 패턴이 점점 안티패턴으로 인식되는 추세 반영)
    public String name;
    public Integer age;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    public MemberStatus status = MemberStatus.PENDING;

    @Builder.Default
    public OffsetDateTime joinDate = OffsetDateTime.now(ZoneId.of("Asia/Seoul"));
}
