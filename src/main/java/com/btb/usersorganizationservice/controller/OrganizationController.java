package com.btb.usersorganizationservice.controller;

import com.btb.usersorganizationservice.dto.AddOrganizationDTO;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.service.OrganizationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/")
    public @ResponseBody List<Organization> getOrganizations() {

        return organizationService.getOrganizations();
    }

    @PostMapping("/")
    public void addOrganization(@RequestBody AddOrganizationDTO addOrganizationDTO) {

        organizationService.addOrganization(addOrganizationDTO);
    }

    @PutMapping("/{organizationId}")
    public void updateOrganization(@PathVariable("organizationId") Long organizationId, @RequestBody AddOrganizationDTO addOrganizationDTO) {

        organizationService.updateOrganization(organizationId, addOrganizationDTO);
    }

    @DeleteMapping("/{organizationId}")
    public void deleteOrganization(@PathVariable("organizationId") Long organizationId) {

        organizationService.deleteOrganization(organizationId);
    }

    @PostMapping("/{organizationId}/add-broker/{brokerId}")
    public void addBrokerToOrganization(@PathVariable("organizationId") Long organizationId, @PathVariable("brokerId") Long brokerId) {

        organizationService.addBrokerToOrganization(organizationId, brokerId);
    }

}
