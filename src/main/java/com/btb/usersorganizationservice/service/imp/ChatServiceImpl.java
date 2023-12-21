package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.persistence.mapper.ChatMapper;
import com.btb.usersorganizationservice.service.BrokerService;
import com.btb.usersorganizationservice.service.ChatService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private BrokerService brokerService;

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public void addChat(Long recipientId, AddChatDTO addChatDTO) throws BrokerException, DBException {
        log.info("Adding chat: {}", recipientId);

        Chat chat = new Chat();
        chat.setUserRecivedId(brokerService.getBrokerById(recipientId));
        chat.setUserSendedId(brokerService.getBrokerById(addChatDTO.getBrokerId()));
        chat.setMessage(addChatDTO.getMessage());
        chat.setCreatedAt(new Date());

        if (chatMapper.save(chat) != 1) {
            throw new DBException("Error adding chat");
        }

        log.info("Chat: {} added", recipientId);
    }

    @Override
    public List<Chat> getChat(Long brokerId) {
        return null;
    }

}
