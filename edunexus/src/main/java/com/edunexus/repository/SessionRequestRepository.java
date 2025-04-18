package com.edunexus.repository;

import com.edunexus.entity.SessionRequest;
import com.edunexus.entity.Mentor;
import com.edunexus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SessionRequestRepository extends JpaRepository<SessionRequest, Integer> {
    List<SessionRequest> findByMentor(Mentor mentor);
    List<SessionRequest> findByMentee(User mentee);
}
