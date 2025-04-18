package com.edunexus.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction_feedback")
public class ItemTransactionFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackId;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    private String feedback;
    private int rating; // Example: rating out of 5

    // Constructors
    public ItemTransactionFeedback() {}

    public ItemTransactionFeedback(Transaction transaction, String feedback, int rating) {
        this.transaction = transaction;
        this.feedback = feedback;
        this.rating = rating;
    }

    // Getters and Setters
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
