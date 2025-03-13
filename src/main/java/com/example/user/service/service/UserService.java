package com.example.user.service.service;

import com.example.user.service.dto.Account;
import com.example.user.service.dto.User;
import com.example.user.service.external.AccountServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private Map<String, User> userMap = new LinkedHashMap<>();

    @Autowired
    private AccountServiceClient accountServiceClient;

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public User getUserById(String userId){
        User user = userMap.get(userId);
        Account account = accountServiceClient.getAccount(userId);
        user.setAccount(account);
        return userMap.get(userId);
    }

    public Collection<User> getAllUsers(){
        Map<String, User> usersDetails = new LinkedHashMap<>();
        for(String userId : userMap.keySet()) {
            Account account = accountServiceClient.getAccount(userId);
            User user = userMap.get(userId);
            user.setAccount(account);
            usersDetails.put(userId,user);
        }
        return usersDetails.values();
    }
}
