package com.edunexus.repository;

import com.edunexus.entity.Conversation;
import com.edunexus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {
    List<Conversation> findByUser1OrUser2(User user1, User user2);
    Optional<Conversation> findByUser1AndUser2(User user1, User user2);
}
