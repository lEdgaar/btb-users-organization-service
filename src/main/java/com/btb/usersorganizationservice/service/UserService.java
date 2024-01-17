package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.LoginDTO;
import com.btb.usersorganizationservice.dto.TokenDTO;
import com.btb.usersorganizationservice.exception.BrokerException;

public interface UserService {

    TokenDTO login(LoginDTO loginDTO) throws BrokerException;

}
