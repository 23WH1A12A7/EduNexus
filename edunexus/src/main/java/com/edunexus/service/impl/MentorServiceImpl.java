package com.edunexus.service.impl;

import com.edunexus.entity.Mentor;
import com.edunexus.repository.MentorRepository;
import com.edunexus.service.MentorService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;

    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public List<Mentor> searchMentors(String expertiseArea) {
        return mentorRepository.findByExpertiseAreaContainingIgnoreCase(expertiseArea);
    }

    @Override
    public Mentor getMentorByUserId(int userId) {
        return mentorRepository.findByUserId(userId);
    }
}
