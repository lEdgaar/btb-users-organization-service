package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.AddOrganizationDTO;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.exception.OrganizationErrorCode;
import com.btb.usersorganizationservice.exception.OrganizationException;
import com.btb.usersorganizationservice.persistence.mapper.OrganizationMapper;
import com.btb.usersorganizationservice.service.BrokerService;
import com.btb.usersorganizationservice.service.OrganizationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private BrokerService brokerService;

    @Override
    public List<Organization> getOrganizations() {
        log.info("Getting organizations");

        return organizationMapper.findAll();
    }

    @Override
    public void addOrganization(AddOrganizationDTO addOrganizationDTO) throws DBException {
        log.info("Adding organization: {}", addOrganizationDTO.getName());

        Organization organization = new Organization();
        organization.setOrganizationName(addOrganizationDTO.getName());
        organization.setDescription(addOrganizationDTO.getDescription());
        organization.setUrlPicture(addOrganizationDTO.getUrlPicture());
        organization.setCreatedAt(new Date());

        if (organizationMapper.save(organization) != 1) {
            throw new DBException("Error adding organization");
        }

        log.info("Organization: {} added", addOrganizationDTO.getName());
    }

    @Override
    public void updateOrganization(Long organizationId, AddOrganizationDTO addOrganizationDTO) throws OrganizationException, DBException {
        log.info("Updating organization: {}", organizationId);

        Organization organization = getOrganization(organizationId);

        organization.setDescription(addOrganizationDTO.getDescription());
        organization.setUrlPicture(addOrganizationDTO.getUrlPicture());

        if (organizationMapper.update(organization) != 1) {
            throw new DBException("Error deleting organization");
        }

        log.info("Organization: {} updated", organizationId);
    }

    @Override
    public void deleteOrganization(Long organizationId) throws DBException, OrganizationException {
        log.info("Deleting organization: {}", organizationId);

        Organization organization = getOrganization(organizationId);

        organization.setDeleted(true);
        organization.setDeletedDate(new Date());

        if (organizationMapper.update(organization) != 1) {
            throw new DBException("Error deleting organization");
        }

        log.info("Organization: {} deleted", organizationId);
    }

    @Override
    public void addBrokerToOrganization(Long organizationId, Long brokerId) throws DBException, BrokerException, OrganizationException {
        log.info("Adding broker: {} to organization: {}", brokerId, organizationId);

        Organization organization = getOrganization(organizationId);

        brokerService.setBrokerToOrganization(brokerId, organization);
    }

    private Organization getOrganization(Long organizationId) throws OrganizationException {
        log.info("Searching organization by id: {}", organizationId);
        if (organizationId == null) {
            throw new OrganizationException(OrganizationErrorCode.ORGANIZATION_ID_NOT_NULL, OrganizationErrorCode.ORGANIZATION_ID_NOT_NULL.getKey());
        }

        Organization organization = organizationMapper.findById(organizationId);

        if (organization == null) {
            throw new OrganizationException(OrganizationErrorCode.ORGANIZATION_NOT_FOUND, OrganizationErrorCode.ORGANIZATION_NOT_FOUND.getKey());
        }

        log.info("Organization found: {}", organizationId);

        return organization;
    }

}
