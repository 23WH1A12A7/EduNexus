package com.edunexus.service;

import com.edunexus.model.Mentorship;
import com.edunexus.repository.MentorshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorshipService {

    @Autowired
    private MentorshipRepository mentorshipRepository;

    public Mentorship requestMentorship(Mentorship mentorship) {
        mentorship.setStatus("requested");
        return mentorshipRepository.save(mentorship);
    }

    public List<Mentorship> getAllMentorships() {
        return mentorshipRepository.findAll();
    }

    public List<Mentorship> getByMentor(Long mentorId) {
        return mentorshipRepository.findByMentorId(mentorId);
    }

    public List<Mentorship> getByMentee(Long menteeId) {
        return mentorshipRepository.findByMenteeId(menteeId);
    }

    public Mentorship updateStatus(Long id, String status) {
        Optional<Mentorship> m = mentorshipRepository.findById(id);
        if (m.isPresent()) {
            Mentorship mentorship = m.get();
            mentorship.setStatus(status);
            return mentorshipRepository.save(mentorship);
        }
        return null;
    }

    public void deleteMentorship(Long id) {
        mentorshipRepository.deleteById(id);
    }
}
