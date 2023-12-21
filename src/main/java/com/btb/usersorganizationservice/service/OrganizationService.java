package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.AddOrganizationDTO;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.exception.OrganizationException;

import java.util.List;

public interface OrganizationService {

    List<Organization> getOrganizations();

    void addOrganization(AddOrganizationDTO addOrganizationDTO) throws DBException;

    void updateOrganization(Long organizationId, AddOrganizationDTO addOrganizationDTO) throws OrganizationException, DBException;

    void deleteOrganization(Long organizationId) throws DBException, OrganizationException;

    void addBrokerToOrganization(Long organizationId, Long brokerId) throws DBException, BrokerException, OrganizationException;

}
