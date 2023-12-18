package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.LoginDTO;
import com.btb.usersorganizationservice.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String login(LoginDTO loginDTO) {
        return null;
    }

    @Override
    public String logout(String token) {
        return null;
    }


}
