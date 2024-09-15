package com.jkc.core.user.service;

import com.jkc.core.user.entity.UserModel;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    List<Long> getAllFriends(Long id);

    UserModel getUser(Long id);

    void addFriend(Long userId, Long friendId);

    UserModel updateOrCreateUser(UserModel userModel);

    void deleteUser(Long id);

    List<UserModel> getAllUsers();
}
