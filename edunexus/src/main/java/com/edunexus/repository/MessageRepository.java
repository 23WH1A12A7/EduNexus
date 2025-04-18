package com.edunexus.repository;

import com.edunexus.entity.Message;
import com.edunexus.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByConversationOrderByTimestampAsc(Conversation conversation);
}
