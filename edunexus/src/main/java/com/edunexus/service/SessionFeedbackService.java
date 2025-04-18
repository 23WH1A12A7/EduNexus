package com.edunexus.service;

import com.edunexus.entity.SessionFeedback;
import java.util.List;

public interface SessionFeedbackService {
    SessionFeedback submitFeedback(SessionFeedback feedback);
    List<SessionFeedback> getFeedbacksForMentor(int mentorId);
}
