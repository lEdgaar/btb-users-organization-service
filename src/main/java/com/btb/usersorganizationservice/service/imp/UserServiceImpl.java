package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.client.OperationsServiceClient;
import com.btb.usersorganizationservice.client.SecurityServiceClient;
import com.btb.usersorganizationservice.dto.LoginDTO;
import com.btb.usersorganizationservice.dto.request.GetTokenDTO;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.exception.BrokerErrorCode;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.service.BrokerService;
import com.btb.usersorganizationservice.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SecurityServiceClient securityServiceClient;

    @Autowired
    private OperationsServiceClient operationsServiceClient;

    @Autowired
    private BrokerService brokerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginDTO loginDTO) throws BrokerException {
        log.info("Login: {}", loginDTO.getEmail());

        User user = brokerService.findUserByEmail(loginDTO.getEmail());

        if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new BrokerException(BrokerErrorCode.EMAIL_OR_PASSWORD_INCORRECT, BrokerErrorCode.EMAIL_OR_PASSWORD_INCORRECT.getKey());
        }

        /*SendEventDTO sendEventDTO = new SendEventDTO();
        sendEventDTO.setUserId(1L);
        sendEventDTO.setDescription("Successfully logged in");

        operationsServiceClient.sendEvent(sendEventDTO);*/

        GetTokenDTO getTokenDTO = new GetTokenDTO();
        getTokenDTO.setEmail(loginDTO.getEmail());
        getTokenDTO.setRole(user.getRoleType().getRoleName());

        return securityServiceClient.getToken(getTokenDTO);
    }

    @Override
    public String logout(String token) {
        return null;
    }


}
