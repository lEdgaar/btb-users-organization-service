package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.AddOrganizationDTO;
import com.btb.usersorganizationservice.entity.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> getOrganizations();

    void addOrganization(AddOrganizationDTO addOrganizationDTO);

    void updateOrganization(Long organizationId, AddOrganizationDTO addOrganizationDTO);

    void deleteOrganization(Long organizationId);

    void addBrokerToOrganization(Long organizationId, Long brokerId);

}
