package com.jkc.core.user.service;

import com.jkc.core.user.entity.User;

import java.util.List;

public interface UserService {
    List<Long> getAllFriends(Long id);

    User getUser(Long id);

    void addFriend(Long userId, Long friendId);

    void updateOrCreateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();
}
