package com.mkdesignstudios.backend.controller;

import com.mkdesignstudios.backend.model.UserProfile;
import com.mkdesignstudios.backend.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class ProfileController {
    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/{username}")
    public UserProfile getProfile(@PathVariable String username) {
        Optional<UserProfile> userOpt = userProfileRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            UserProfile user = userOpt.get();
            user.setPassword(null); // Do not return password
            return user;
        }
        throw new RuntimeException("User not found");
    }
}
