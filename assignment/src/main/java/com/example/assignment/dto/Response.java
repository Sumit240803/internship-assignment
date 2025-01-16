package com.example.assignment.dto;

import com.example.assignment.models.User;
import lombok.Data;

@Data
public class Response {
    private String message;
    private String error;
    private User user;
}
