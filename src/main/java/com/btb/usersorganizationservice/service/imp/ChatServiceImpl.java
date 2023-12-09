package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.persistence.mapper.ChatMapper;
import com.btb.usersorganizationservice.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public void addChat(Long recipientId, AddChatDTO addChatDTO) {
        Chat chat = new Chat();
        chat.setUserRecivedId(recipientId);
        chat.setUserSendedId(addChatDTO.getBrokerId());
        chat.setMessage(addChatDTO.getMessage());
        chat.setCreatedAt(new Date());

        chatMapper.save(chat);
    }

    @Override
    public List<Chat> getChat(Long brokerId) {
        return null;
    }

}
