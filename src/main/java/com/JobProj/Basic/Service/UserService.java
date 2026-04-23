package com.JobProj.Basic.Service;


import com.JobProj.Basic.model.User;
import com.JobProj.Basic.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // 📝 REGISTER USER
    public User registerUser(User user) {
        return repo.save(user);
    }

    // 🔍 FIND USER BY USERNAME
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    // 🔐 LOGIN VALIDATION
    public User validateUser(String username, String password) {

        Optional<User> userOpt = repo.findByUsername(username);

        // Check if user exists
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            // Check password
            if (user.getPassword().equals(password)) {
                return user; // ✅ valid user
            }
        }

        return null; // ❌ invalid
    }
}
