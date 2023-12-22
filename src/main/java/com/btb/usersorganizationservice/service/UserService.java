package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.LoginDTO;
import com.btb.usersorganizationservice.exception.BrokerException;

public interface UserService {

    String login(LoginDTO loginDTO) throws BrokerException;

    String logout(String token);

}
