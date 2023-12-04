package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.dto.UpdateBrokerDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.entity.User;

import java.util.List;

public interface BrokerService {

    List<User> getBrokers();

    void addBroker(AddBrokerDTO addBrokerDTO);

    void updateBroker(Long brokerId, UpdateBrokerDTO updateBrokerDTO);

    void deleteBroker(Long brokerId);

    User getBrokerById(Long brokerId);

    List<Chat> getMessagesByBrokerId(Long brokerId);

    void addChat(Long brokerId, Long recipientId, AddChatDTO addChatDTO);

}
