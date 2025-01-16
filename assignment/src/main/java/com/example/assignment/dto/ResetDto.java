package com.example.assignment.dto;

import lombok.Data;

@Data
public class ResetDto {
    private String username;
    private String newPassword;
    private String confirmPassword;
}
