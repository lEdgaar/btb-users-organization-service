package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.entity.Chat;

import java.util.List;

public interface ChatService {

    void addChat(Long recipientId, AddChatDTO addChatDTO);

    List<Chat> getChat(Long brokerId);

}
