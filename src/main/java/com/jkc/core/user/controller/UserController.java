package com.jkc.core.user.controller;

import com.jkc.core.user.entity.FriendsBody;
import com.jkc.core.user.entity.UserModel;
import com.jkc.core.user.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get-all-users")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = {"/create-user", "/update-user"})
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.updateOrCreateUser(userModel);
    }

    @GetMapping("/get-user/{id}")
    public UserModel getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/get-user-friends/{id}")
    public List<Long> getUserFriends(@PathVariable("id") Long id) {
        return userService.getAllFriends(id);
    }

    @GetMapping("/add-friend")
    public String makeFriends(@RequestBody FriendsBody body) {
        userService.addFriend(body.user, body.friend);
        return "Success";
    }
}
