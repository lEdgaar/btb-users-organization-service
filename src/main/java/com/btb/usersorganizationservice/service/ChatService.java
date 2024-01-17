package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;

import java.util.List;

public interface ChatService {

    void addChat(String email, AddChatDTO addChatDTO) throws BrokerException, DBException;

    List<Chat> getChat(Long brokerId) throws BrokerException;

}
