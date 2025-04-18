package com.edunexus.service.impl;

import com.edunexus.entity.Mentor;
import com.edunexus.entity.SessionFeedback;
import com.edunexus.repository.MentorRepository;
import com.edunexus.repository.SessionFeedbackRepository;
import com.edunexus.service.SessionFeedbackService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SessionFeedbackServiceImpl implements SessionFeedbackService {

    private final SessionFeedbackRepository sessionFeedbackRepository;
    private final MentorRepository mentorRepository;

    public SessionFeedbackServiceImpl(SessionFeedbackRepository sessionFeedbackRepository,
                                      MentorRepository mentorRepository) {
        this.sessionFeedbackRepository = sessionFeedbackRepository;
        this.mentorRepository = mentorRepository;
    }

    @Override
    public SessionFeedback submitFeedback(SessionFeedback feedback) {
        return sessionFeedbackRepository.save(feedback);
    }

    @Override
    public List<SessionFeedback> getFeedbacksForMentor(int mentorId) {
        Mentor mentor = mentorRepository.findById(mentorId).orElse(null);
        return sessionFeedbackRepository.findBySessionRequest_Mentor(mentor);
    }
}
