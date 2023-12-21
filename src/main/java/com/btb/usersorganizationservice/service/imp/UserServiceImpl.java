package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.client.SecurityServiceClient;
import com.btb.usersorganizationservice.dto.LoginDTO;
import com.btb.usersorganizationservice.dto.request.GetTokenDTO;
import com.btb.usersorganizationservice.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SecurityServiceClient securityServiceClient;

    @Override
    public String login(LoginDTO loginDTO) {
        log.info("Login: {}", loginDTO.getEmail());

        GetTokenDTO getTokenDTO = new GetTokenDTO();
        getTokenDTO.setUsername(loginDTO.getEmail());
        getTokenDTO.setRole("PRUEBA");

        return securityServiceClient.getToken(getTokenDTO);
    }

    @Override
    public String logout(String token) {
        return null;
    }


}
