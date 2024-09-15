package com.jkc.core.user.service;

import com.jkc.core.user.entity.UserModel;
import com.jkc.core.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Long> getAllFriends(Long id) {
        Optional<UserModel> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get().friendUserIds;
        } else {
            throw new IllegalArgumentException("UserModel Not found while fetching friends");
        }
    }

    @Override
    public UserModel getUser(Long id) {
        Optional<UserModel> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new IllegalArgumentException("UserModel Not found while fetching friends");
        }
    }

    @Override
    public void addFriend(Long userId, Long friendId) {
        Optional<UserModel> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            UserModel userModel = userOptional.get();
            userModel.friendUserIds.add(friendId);
            userRepository.save(userModel);
        } else {
            throw new IllegalArgumentException("UserModel Not found while fetching friends");
        }
    }

    @Override
    public UserModel updateOrCreateUser(UserModel userModel) {
        userModel.friendUserIds = new ArrayList<>();
        return userRepository.save(userModel);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }
}
