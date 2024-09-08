package com.jkc.core.user.service;

import com.jkc.core.user.entity.User;
import com.jkc.core.user.repository.UserRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.jkc.core.utils.CollectionUtils.toList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Long> getAllFriends(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get().friendUserIds;
        } else {
            throw new IllegalArgumentException("User Not found while fetching friends");
        }
    }

    @Override
    public User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new IllegalArgumentException("User Not found while fetching friends");
        }
    }

    @Override
    public void addFriend(Long userId, Long friendId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.friendUserIds.add(friendId);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User Not found while fetching friends");
        }
    }

    @Override
    public void updateOrCreateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return toList(userRepository.findAll());
    }
}
