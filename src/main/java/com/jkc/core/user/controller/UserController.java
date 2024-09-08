package com.jkc.core.user.controller;

import com.jkc.core.user.entity.User;
import com.jkc.core.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/user/")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("get-all-users")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = {"create-user", "update-user"})
    String createUser() {
        try {
            return "Success";
        } catch (Exception e) {
            return "Failed";
        }
    }



}
