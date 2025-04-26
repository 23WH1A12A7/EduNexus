package com.edunexus.controller;

import com.edunexus.model.Mentorship;
import com.edunexus.service.MentorshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mentorships")
@CrossOrigin(origins = "*")
public class MentorshipController {

    @Autowired
    private MentorshipService mentorshipService;

    @PostMapping("/request")
    public Mentorship requestMentorship(@RequestBody Mentorship mentorship) {
        return mentorshipService.requestMentorship(mentorship);
    }

    @GetMapping
    public List<Mentorship> getAllMentorships() {
        return mentorshipService.getAllMentorships();
    }

    @GetMapping("/mentor/{mentorId}")
    public List<Mentorship> getByMentor(@PathVariable Long mentorId) {
        return mentorshipService.getByMentor(mentorId);
    }

    @GetMapping("/mentee/{menteeId}")
    public List<Mentorship> getByMentee(@PathVariable Long menteeId) {
        return mentorshipService.getByMentee(menteeId);
    }

    @PutMapping("/status/{id}")
    public Mentorship updateStatus(@PathVariable Long id, @RequestParam String status) {
        return mentorshipService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteMentorship(@PathVariable Long id) {
        mentorshipService.deleteMentorship(id);
        return "Mentorship deleted successfully!";
    }
}
