package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.dto.UpdateBrokerDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.entity.User;

import java.util.List;

public interface BrokerService {

    List<User> getBrokers();

    void addBroker(AddBrokerDTO addBrokerDTO);

    void updateBroker(Long brokerId, UpdateBrokerDTO updateBrokerDTO);

    void deleteBroker(Long brokerId);

    List<User> getBrokerLikeName(String name);

    User getBrokerById(Long brokerId);

    void setBrokerToOrganization(Long brokerId, Organization organization);
}
