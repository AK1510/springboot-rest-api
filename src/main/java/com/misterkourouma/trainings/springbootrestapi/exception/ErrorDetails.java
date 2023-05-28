package com.misterkourouma.trainings.springbootrestapi.exception;


import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;
}
