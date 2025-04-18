package com.edunexus.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "session_feedback")
public class SessionFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    @OneToOne
    @JoinColumn(name = "session_request_id")
    private SessionRequest sessionRequest;

    private String feedbackText;
    private int rating; // 1 to 5

    // Constructors
    public SessionFeedback() {}

    public SessionFeedback(SessionRequest sessionRequest, String feedbackText, int rating) {
        this.sessionRequest = sessionRequest;
        this.feedbackText = feedbackText;
        this.rating = rating;
    }

    // Getters and Setters
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public SessionRequest getSessionRequest() {
        return sessionRequest;
    }

    public void setSessionRequest(SessionRequest sessionRequest) {
        this.sessionRequest = sessionRequest;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
