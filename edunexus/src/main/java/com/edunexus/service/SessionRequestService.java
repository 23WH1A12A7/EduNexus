package com.edunexus.service;

import com.edunexus.entity.SessionRequest;
import java.util.List;

public interface SessionRequestService {
    SessionRequest sendRequest(SessionRequest request);
    List<SessionRequest> getRequestsByMentor(int mentorId);
    SessionRequest updateStatus(int requestId, String status);
}
