package com.example.demo.member.mapper;

import com.example.demo.member.api.dto.MemberCommandDto.MemberSignUpRequestDto;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.type.MemberStatus;
import org.mapstruct.Mapper;

// vs ModelMapper: 고전적으로 더 쓰여 왔고 -> (단점) 리플렉션 써서 런타임에 ... (매퍼 사용에 의한 cost 증가)
// MapStruct: 컴파일 타임에 구현 클래스 등 생성.
@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member toEntity(MemberSignUpRequestDto dto, MemberStatus status);
}
