package com.misterkourouma.trainings.springbootrestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private long id;
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;
    @NotEmpty(message = "User email should not be null or empty")
    @Email
    private String email;
}
