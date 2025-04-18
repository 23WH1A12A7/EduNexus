package com.edunexus.controller;

import com.edunexus.entity.Mentor;
import com.edunexus.entity.User;
import com.edunexus.repository.MentorRepository;
import com.edunexus.repository.UserRepository;
import com.edunexus.service.MentorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mentors")
public class MentorController {

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MentorService mentorService;

    @PostMapping("/add")
    public Mentor addMentor(@RequestBody MentorRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        Mentor mentor = new Mentor();
        mentor.setUser(user);
        mentor.setExpertiseArea(request.getExpertiseArea());
        mentor.setBio(request.getBio());
        mentor.setAvailability(request.getAvailability());

        return mentorRepository.save(mentor);
    }

    @GetMapping("/search")
    public List<Mentor> searchByExpertise(@RequestParam String expertise) {
        return mentorService.searchMentors(expertise);
    }

    // Inner static class for the request format
    public static class MentorRequest {
        private int userId;
        private String expertiseArea;
        private String bio;
        private String availability;

        public int getUserId() { return userId; }
        public void setUserId(int userId) { this.userId = userId; }

        public String getExpertiseArea() { return expertiseArea; }
        public void setExpertiseArea(String expertiseArea) { this.expertiseArea = expertiseArea; }

        public String getBio() { return bio; }
        public void setBio(String bio) { this.bio = bio; }

        public String getAvailability() { return availability; }
        public void setAvailability(String availability) { this.availability = availability; }
    }
}
