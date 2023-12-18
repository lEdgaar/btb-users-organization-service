package com.btb.usersorganizationservice.controller;

import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.service.BrokerService;
import com.btb.usersorganizationservice.service.ChatService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/chat")
public class ChatController {

    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/{recipientId}")
    public void addChat(@PathVariable("recipientId") Long recipientId, @RequestBody AddChatDTO addChatDTO) {
        log.trace("POST /chat/{}", recipientId);

        log.info("Event: Add chat: {}", recipientId);
        chatService.addChat(recipientId, addChatDTO);
    }

    @PostMapping("/{brokerId}")
    public List<Chat> getChat(@PathVariable("brokerId") Long brokerId) {
        log.trace("GET /chat/{}", brokerId);

        log.info("Event: Get chat: {}", brokerId);
        return chatService.getChat(brokerId);
    }

}
