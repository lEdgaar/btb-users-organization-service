package com.btb.usersorganizationservice.controller;

import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
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

    @PostMapping("/{email}")
    public void addChat(@PathVariable("email") String email, @RequestBody AddChatDTO addChatDTO) throws DBException, BrokerException {
        log.info("POST /chat/{}", email);

        log.info("Event: Add chat: {}", email);
        chatService.addChat(email, addChatDTO);
    }

    @GetMapping("/get/{brokerId}")
    public List<Chat> getChat(@PathVariable("brokerId") Long brokerId) throws BrokerException {
        log.info("GET /chat/{}", brokerId);

        log.info("Event: Get chat: {}", brokerId);
        return chatService.getChat(brokerId);
    }

}
