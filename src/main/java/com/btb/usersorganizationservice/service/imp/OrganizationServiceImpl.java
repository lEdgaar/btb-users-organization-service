package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.AddOrganizationDTO;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Override
    public List<Organization> getOrganizations() {
        return null;
    }

    @Override
    public void addOrganization(AddOrganizationDTO addOrganizationDTO) {

    }

    @Override
    public void updateOrganization(Long organizationId, AddOrganizationDTO addOrganizationDTO) {

    }

    @Override
    public void deleteOrganization(Long organizationId) {

    }

    @Override
    public void addBrokerToOrganization(Long organizationId, Long brokerId) {

    }

}
