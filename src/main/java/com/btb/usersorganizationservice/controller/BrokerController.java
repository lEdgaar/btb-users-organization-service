package com.btb.usersorganizationservice.controller;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.dto.UpdateBrokerDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.service.BrokerService;
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
        log.trace("GET /brokers");

        log.info("Event: Get brokers");
        return brokerService.getBrokers();
    }

    @PostMapping("/")
    public void addBroker(@RequestBody AddBrokerDTO addBrokerDTO) {
        log.trace("POST /brokers {}", addBrokerDTO.getEmail());

        log.info("Event: Add broker: {}", addBrokerDTO.getEmail());
        brokerService.addBroker(addBrokerDTO);
    }

    @PutMapping("/{brokerId}")
    public void updateBroker(@PathVariable("brokerId") Long brokerId, @RequestBody UpdateBrokerDTO updateBrokerDTO) {
        log.trace("PUT /brokers/{}", brokerId);

        log.info("Event: Update broker: {}", brokerId);
        brokerService.updateBroker(brokerId, updateBrokerDTO);
    }

    @DeleteMapping("/{brokerId}")
    public void deleteBroker(@PathVariable("brokerId") Long brokerId) {
        log.trace("DELETE /brokers/{}", brokerId);

        log.info("Event: Delete broker: {}", brokerId);
        brokerService.deleteBroker(brokerId);
    }

    @GetMapping("/")
    public @ResponseBody List<User> searchBrokerByName(@RequestParam String name) {
        log.trace("GET /brokers?name={}", name);

        log.info("Event: Search broker by name: {}", name);
        return brokerService.getBrokerLikeName(name);
    }

    @GetMapping("/{brokerId}")
    public @ResponseBody User searchBrokerById(@PathVariable("brokerId") Long brokerId) {
        log.trace("GET /brokers/{}", brokerId);

        log.info("Event: Search broker by id: {}", brokerId);
        return brokerService.getBrokerById(brokerId);
    }

}
