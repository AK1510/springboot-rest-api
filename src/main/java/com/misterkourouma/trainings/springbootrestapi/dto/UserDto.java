package com.misterkourouma.trainings.springbootrestapi.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
