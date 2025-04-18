package com.edunexus.controller;

import com.edunexus.entity.SessionRequest;
import com.edunexus.entity.SessionFeedback;
import com.edunexus.service.SessionRequestService;
import com.edunexus.service.SessionFeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionRequestController {

    private final SessionRequestService sessionRequestService;
    private final SessionFeedbackService sessionFeedbackService;

    public SessionRequestController(SessionRequestService sessionRequestService,
                                    SessionFeedbackService sessionFeedbackService) {
        this.sessionRequestService = sessionRequestService;
        this.sessionFeedbackService = sessionFeedbackService;
    }

    @PostMapping("/request")
    public SessionRequest requestSession(@RequestBody SessionRequest request) {
        return sessionRequestService.sendRequest(request);
    }

    @PutMapping("/request/{id}/status")
    public SessionRequest updateStatus(@PathVariable int id, @RequestParam String status) {
        return sessionRequestService.updateStatus(id, status);
    }

    @GetMapping("/mentor/{mentorId}")
    public List<SessionRequest> getRequests(@PathVariable int mentorId) {
        return sessionRequestService.getRequestsByMentor(mentorId);
    }

    @PostMapping("/feedback")
    public SessionFeedback submitFeedback(@RequestBody SessionFeedback feedback) {
        return sessionFeedbackService.submitFeedback(feedback);
    }

    @GetMapping("/feedback/mentor/{mentorId}")
    public List<SessionFeedback> getFeedback(@PathVariable int mentorId) {
        return sessionFeedbackService.getFeedbacksForMentor(mentorId);
    }
}
