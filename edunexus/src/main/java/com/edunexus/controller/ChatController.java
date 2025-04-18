package com.edunexus.controller;

import com.edunexus.entity.*;
import com.edunexus.repository.UserRepository;
import com.edunexus.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;
    private final UserRepository userRepository;

    public ChatController(ChatService chatService, UserRepository userRepository) {
        this.chatService = chatService;
        this.userRepository = userRepository;
    }

    @PostMapping("/start")
    public Conversation startChat(@RequestParam int user1Id, @RequestParam int user2Id) {
        User user1 = userRepository.findById(user1Id).orElseThrow();
        User user2 = userRepository.findById(user2Id).orElseThrow();
        return chatService.startConversation(user1, user2);
    }

    @GetMapping("/conversations/{userId}")
    public List<Conversation> getUserConversations(@PathVariable int userId) {
        return chatService.getUserConversations(userRepository.findById(userId).orElseThrow());
    }

    @PostMapping("/send/{conversationId}")
    public Message sendMessage(@PathVariable int conversationId, @RequestBody Message message) {
        return chatService.sendMessage(conversationId, message);
    }

    @GetMapping("/messages/{conversationId}")
    public List<Message> getMessages(@PathVariable int conversationId) {
        return chatService.getMessages(conversationId);
    }
}
