package com.ywcheong.test.simpleapi.data.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {
    private String name;
    private String email;
    private String organization;
}
