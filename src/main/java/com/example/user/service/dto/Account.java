package com.example.user.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class Account {

    private Long accountId;

    @NotNull(message = "User ID cannot be null")
    private String userId;

    @NotNull(message = "Account type cannot be null")
    private String accountType;

    @Positive(message = "Balance must be positive")
    private Double balance;

    // Getters and Setters
}
