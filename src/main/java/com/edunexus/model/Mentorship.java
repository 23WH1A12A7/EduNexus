package com.edunexus.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mentorship")
public class Mentorship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mentorId;
    private Long menteeId;
    private String topic;
    private String status; // requested, accepted, completed

    public Mentorship() {}

    public Mentorship(Long id, Long mentorId, Long menteeId, String topic, String status) {
        this.id = id;
        this.mentorId = mentorId;
        this.menteeId = menteeId;
        this.topic = topic;
        this.status = status;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMentorId() {
        return mentorId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
    }

    public Long getMenteeId() {
        return menteeId;
    }

    public void setMenteeId(Long menteeId) {
        this.menteeId = menteeId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
