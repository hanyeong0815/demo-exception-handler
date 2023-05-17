package com.example.demo.member.api.dto;

import com.example.demo.member.api.constants.MemberValidationConstants.NameValidation;
import com.example.demo.member.api.constants.MemberValidationConstants.UsernameValidation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

public record MemberCommandDto() {
    // ...
    public record MemberSignUpRequestDto(
            @Pattern(
                    regexp = UsernameValidation.PATTERN,
                    message = UsernameValidation.MESSAGE
            )
            String username,
            @Pattern(
                    regexp = NameValidation.PATTERN,
                    message = NameValidation.MESSAGE
            )
            String name,
            @Min(0) Integer age
    ) {}

    @Builder
    public record MemberSignUpResponseDto(
            Boolean success
    ) {}
}
