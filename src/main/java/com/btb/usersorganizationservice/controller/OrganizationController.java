package com.btb.usersorganizationservice.controller;

import com.btb.usersorganizationservice.dto.AddOrganizationDTO;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.exception.OrganizationException;
import com.btb.usersorganizationservice.exception.RoleTypeException;
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
        log.info("GET /organizations");

        log.info("Event: Get organizations");
        return organizationService.getOrganizations();
    }

    @PostMapping("/")
    public void addOrganization(@RequestBody AddOrganizationDTO addOrganizationDTO) throws DBException, BrokerException, RoleTypeException {
        log.trace("POST /organizations {}", addOrganizationDTO.getName());

        log.info("Event: Add organization: {}", addOrganizationDTO.getName());
        organizationService.addOrganization(addOrganizationDTO);
    }

    @PutMapping("/{organizationId}")
    public void updateOrganization(@PathVariable("organizationId") Long organizationId, @RequestBody AddOrganizationDTO addOrganizationDTO) throws DBException, OrganizationException {
        log.trace("PUT /organizations/{}", organizationId);

        log.info("Event: Update organization: {}", organizationId);
        organizationService.updateOrganization(organizationId, addOrganizationDTO);
    }

    @DeleteMapping("/{organizationId}")
    public void deleteOrganization(@PathVariable("organizationId") Long organizationId) throws DBException, OrganizationException {
        log.trace("DELETE /organizations/{}", organizationId);

        log.info("Event: Delete organization: {}", organizationId);
        organizationService.deleteOrganization(organizationId);
    }

    @PostMapping("/{organizationId}/add-broker/{brokerId}")
    public void addBrokerToOrganization(@PathVariable("organizationId") Long organizationId, @PathVariable("brokerId") Long brokerId) throws DBException, BrokerException, OrganizationException {
        log.trace("POST /organizations/{}/add-broker/{}", organizationId, brokerId);

        log.info("Event: Add broker: {} to organization: {}", brokerId, organizationId);
        organizationService.addBrokerToOrganization(organizationId, brokerId);
    }

}
