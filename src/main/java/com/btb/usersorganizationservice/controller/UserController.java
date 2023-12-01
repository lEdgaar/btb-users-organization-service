package com.btb.usersorganizationservice.controller;

import com.btb.usersorganizationservice.dto.LoginDTO;
import com.btb.usersorganizationservice.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public @ResponseBody String login(@RequestBody LoginDTO loginDTO) {
        log.trace("POST /user/login email: {}", loginDTO.getEmail());

        log.info("IMPORTANT: EventType: Code: {} Description: It has been successfully logged in");

        return userService.login(loginDTO);
    }

}
