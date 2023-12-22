package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.dto.UpdateBrokerDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.exception.RoleTypeException;

import java.util.List;

public interface BrokerService {

    List<User> getBrokers();

    void addBroker(AddBrokerDTO addBrokerDTO) throws RoleTypeException, BrokerException, DBException;

    void updateBroker(Long brokerId, UpdateBrokerDTO updateBrokerDTO) throws BrokerException, DBException;

    void deleteBroker(Long brokerId) throws BrokerException, DBException;

    List<User> getBrokerLikeNameOrEmail(String name) throws BrokerException;

    User getBrokerById(Long brokerId) throws BrokerException;

    void setBrokerToOrganization(Long brokerId, Organization organization) throws BrokerException, DBException;

    User findUserByEmail(String email);

}
