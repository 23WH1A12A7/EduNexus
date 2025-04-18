package com.edunexus.service.impl;

import com.edunexus.entity.*;
import com.edunexus.repository.*;
import com.edunexus.service.ChatService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private final ConversationRepository conversationRepo;
    private final MessageRepository messageRepo;
    private final UserRepository userRepo;

    public ChatServiceImpl(ConversationRepository conversationRepo,
                           MessageRepository messageRepo,
                           UserRepository userRepo) {
        this.conversationRepo = conversationRepo;
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Conversation startConversation(User user1, User user2) {
        return conversationRepo.findByUser1AndUser2(user1, user2)
            .orElseGet(() -> conversationRepo.save(new Conversation(user1, user2)));
    }

    @Override
    public List<Conversation> getUserConversations(User user) {
        return conversationRepo.findByUser1OrUser2(user, user);
    }

    @Override
    public Message sendMessage(int conversationId, Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @Override
    public List<Message> getMessages(int conversationId) {
        Conversation conversation = conversationRepo.findById(conversationId).orElseThrow();
        return messageRepo.findByConversationOrderByTimestampAsc(conversation);
    }

	public UserRepository getUserRepo() {
		return userRepo;
	}
}
