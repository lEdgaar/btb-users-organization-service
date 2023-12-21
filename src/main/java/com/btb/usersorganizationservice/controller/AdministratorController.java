package com.btb.usersorganizationservice.controller;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.BanUserDTO;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.service.AdministrationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("/admin")
public class AdministratorController {

    private AdministrationService administrationService;

    @Autowired
    public AdministratorController(AdministrationService administrationService) {
        this.administrationService = administrationService;
    }

    @PostMapping("/ban")
    public void banUser(@RequestBody BanUserDTO banUserDTO) throws DBException, BrokerException {
        log.trace("POST /admin/ban userId: {}, banReasonId: {}", banUserDTO.getUserId(), banUserDTO.getBanReasonId());

        log.info("Event: Ban user: {}, banReasonId: {}", banUserDTO.getUserId(), banUserDTO.getBanReasonId());
        administrationService.banUser(banUserDTO);
    }

}
