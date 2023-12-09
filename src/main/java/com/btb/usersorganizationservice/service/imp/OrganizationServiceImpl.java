package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.AddOrganizationDTO;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.persistence.mapper.OrganizationMapper;
import com.btb.usersorganizationservice.service.BrokerService;
import com.btb.usersorganizationservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private BrokerService brokerService;

    @Override
    public List<Organization> getOrganizations() {
        return organizationMapper.findAll();
    }

    @Override
    public void addOrganization(AddOrganizationDTO addOrganizationDTO) {
        Organization organization = new Organization();
        organization.setOrganizationName(addOrganizationDTO.getName());
        organization.setDescription(addOrganizationDTO.getDescription());
        organization.setUrlPicture(addOrganizationDTO.getUrlPicture());
        organization.setCreatedAt(new Date());

        organizationMapper.save(organization);
    }

    @Override
    public void updateOrganization(Long organizationId, AddOrganizationDTO addOrganizationDTO) {
        Organization organization = getOrganization(organizationId);

        organization.setDescription(addOrganizationDTO.getDescription());
        organization.setUrlPicture(addOrganizationDTO.getUrlPicture());

        organizationMapper.update(organization);
    }

    @Override
    public void deleteOrganization(Long organizationId) {
        Organization organization = getOrganization(organizationId);

        organization.setDeleted(true);
        organization.setDeletedDate(new Date());

        organizationMapper.update(organization);

    }

    @Override
    public void addBrokerToOrganization(Long organizationId, Long brokerId) {
        Organization organization = getOrganization(organizationId);

        brokerService.setBrokerToOrganization(brokerId, organization);
    }

    private Organization getOrganization(Long organizationId) {
        if (organizationId == null) {
            // ERROR
        }

        Organization organization = organizationMapper.findById(organizationId);

        if (organization == null) {
            // ERROR
        }

        return organization;
    }

}
