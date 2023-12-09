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

        return brokerService.getBrokers();
    }

    @PostMapping("/")
    public void addBroker(@RequestBody AddBrokerDTO addBrokerDTO) {

        brokerService.addBroker(addBrokerDTO);
    }

    @PutMapping("/{brokerId}")
    public void updateBroker(@PathVariable("brokerId") Long brokerId, @RequestBody UpdateBrokerDTO updateBrokerDTO) {

        brokerService.updateBroker(brokerId, updateBrokerDTO);
    }

    @DeleteMapping("/{brokerId}")
    public void deleteBroker(@PathVariable("brokerId") Long brokerId) {

        brokerService.deleteBroker(brokerId);
    }

    @GetMapping("/")
    public @ResponseBody List<User> searchBrokerByName(@RequestParam String name) {

        return brokerService.getBrokerLikeName(name);
    }

    @GetMapping("/{brokerId}")
    public @ResponseBody User searchBrokerById(@PathVariable("brokerId") Long brokerId) {

        return brokerService.getBrokerById(brokerId);
    }

}
