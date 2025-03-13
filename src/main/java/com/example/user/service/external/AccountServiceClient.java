package com.example.user.service.external;

import com.example.user.service.dto.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "account-service", url = "http://localhost:8080/accounts/user") // URL of the Account Service
@FeignClient(name = "ACCOUNT-SERVICE") // Service name of the Account Service
public interface AccountServiceClient {

    @GetMapping("/accounts/user/{userId}")
    Account getAccount(@PathVariable("userId") String userId);
}
