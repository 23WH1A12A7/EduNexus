package com.edunexus.service.impl;

import com.edunexus.entity.SessionRequest;
import com.edunexus.entity.SessionRequestStatus;
import com.edunexus.repository.MentorRepository;
import com.edunexus.repository.SessionRequestRepository;
import com.edunexus.service.SessionRequestService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SessionRequestServiceImpl implements SessionRequestService {

    private final SessionRequestRepository sessionRequestRepository;
    private final MentorRepository mentorRepository;

    public SessionRequestServiceImpl(SessionRequestRepository sessionRequestRepository,
                                     MentorRepository mentorRepository) {
        this.sessionRequestRepository = sessionRequestRepository;
        this.mentorRepository = mentorRepository;
    }

    @Override
    public SessionRequest sendRequest(SessionRequest request) {
        request.setStatus(SessionRequestStatus.PENDING);
        return sessionRequestRepository.save(request);
    }

    @Override
    public List<SessionRequest> getRequestsByMentor(int mentorId) {
        return sessionRequestRepository.findByMentor(mentorRepository.findById(mentorId).orElse(null));
    }

    @Override
    public SessionRequest updateStatus(int requestId, String status) {
        SessionRequest req = sessionRequestRepository.findById(requestId).orElseThrow();
        req.setStatus(SessionRequestStatus.valueOf(status.toUpperCase()));
        return sessionRequestRepository.save(req);
    }
}
