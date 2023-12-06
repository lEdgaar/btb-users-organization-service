package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.dto.UpdateBrokerDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.persistence.mapper.UserMapper;
import com.btb.usersorganizationservice.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrokerServiceImpl implements BrokerService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getBrokers() {
        return userMapper.findAll();
    }

    @Override
    public void addBroker(AddBrokerDTO addBrokerDTO) {

    }

    @Override
    public void updateBroker(Long brokerId, UpdateBrokerDTO updateBrokerDTO) {

    }

    @Override
    public void deleteBroker(Long brokerId) {

    }

    @Override
    public User getBrokerById(Long brokerId) {
        return null;
    }

    @Override
    public List<Chat> getMessagesByBrokerId(Long brokerId) {
        return null;
    }

    @Override
    public void addChat(Long brokerId, Long recipientId, AddChatDTO addChatDTO) {

    }

}
