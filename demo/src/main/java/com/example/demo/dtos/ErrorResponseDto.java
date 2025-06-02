package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

    public String status;
    public String message;

    @Override
    public String toString() {
        return "Something went Wrong ::: [status=" + status + ", message=" + message + "]";
    }
}
