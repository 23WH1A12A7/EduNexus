package com.edunexus.repository;

import com.edunexus.entity.SessionFeedback;
import com.edunexus.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessionFeedbackRepository extends JpaRepository<SessionFeedback, Integer> {
    List<SessionFeedback> findBySessionRequest_Mentor(Mentor mentor);
}
