package com.btb.usersorganizationservice.controller;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.AddNotificationDTO;
import com.btb.usersorganizationservice.dto.UpdateBrokerDTO;
import com.btb.usersorganizationservice.dto.UserInfoDTO;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.exception.RoleTypeException;
import com.btb.usersorganizationservice.service.BrokerService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/brokers")
public class BrokerController {

    private BrokerService brokerService;

    @Autowired
    public BrokerController(BrokerService brokerService) {
        this.brokerService = brokerService;
    }

    @GetMapping("/")
    public @ResponseBody List<User> getBrokers() {
        log.info("GET /brokers");

        log.info("Event: Get brokers");
        return brokerService.getBrokers();
    }

    @PostMapping("/")
    public void addBroker(@Valid @RequestBody AddBrokerDTO addBrokerDTO) throws RoleTypeException, DBException, BrokerException {
        log.info("POST /brokers {}", addBrokerDTO.getEmail());

        log.info("Event: Add broker: {}", addBrokerDTO.getEmail());
        brokerService.addBroker(addBrokerDTO);
    }

    @PutMapping("/{brokerId}")
    public void updateBroker(@PathVariable("brokerId") Long brokerId, @RequestBody UpdateBrokerDTO updateBrokerDTO) throws DBException, BrokerException {
        log.info("PUT /brokers/{}", brokerId);

        log.info("Event: Update broker: {}", brokerId);
        brokerService.updateBroker(brokerId, updateBrokerDTO);
    }

    @DeleteMapping("/{brokerId}")
    public void deleteBroker(@PathVariable("brokerId") Long brokerId) throws DBException, BrokerException {
        log.info("DELETE /brokers/{}", brokerId);

        log.info("Event: Delete broker: {}", brokerId);
        brokerService.deleteBroker(brokerId);
    }

    @GetMapping("/search")
    public @ResponseBody UserInfoDTO searchBrokerByNameOrEmail(@RequestParam("name") String name) throws BrokerException {
        log.info("GET /brokers?name={}", name);

        log.info("Event: Search broker by name: {}", name);
        return brokerService.getBrokerLikeNameOrEmail(name);
    }

    @GetMapping("/{brokerId}")
    public @ResponseBody UserInfoDTO searchBrokerById(@PathVariable("brokerId") Long brokerId) throws BrokerException {
        log.info("GET /brokers/{}", brokerId);

        log.info("Event: Search broker by id: {}", brokerId);
        return brokerService.getBrokerById(brokerId);
    }

}
