package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.LoginDTO;

public interface UserService {

    String login(LoginDTO loginDTO);

    void logout();

}
