package com.edunexus.service;

import com.edunexus.model.User;
import java.util.List;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
    List<User> getAllUsers();
    User getUserById(Long id);
}
