package com.example.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String userId;
    private String username;
    private Account account; // Account details fetched from account-management
}
