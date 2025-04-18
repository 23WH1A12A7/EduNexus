package com.edunexus.service;

import com.edunexus.entity.Conversation;
import com.edunexus.entity.Message;
import com.edunexus.entity.User;

import java.util.List;

public interface ChatService {
    Conversation startConversation(User user1, User user2);
    List<Conversation> getUserConversations(User user);
    Message sendMessage(int conversationId, Message message);
    List<Message> getMessages(int conversationId);
}
