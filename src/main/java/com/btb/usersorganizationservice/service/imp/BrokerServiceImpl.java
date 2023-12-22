package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.dto.UpdateBrokerDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.exception.BrokerErrorCode;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.exception.RoleTypeException;
import com.btb.usersorganizationservice.md.RoleTypeMD;
import com.btb.usersorganizationservice.persistence.mapper.UserMapper;
import com.btb.usersorganizationservice.service.BrokerService;
import com.btb.usersorganizationservice.service.CountryService;
import com.btb.usersorganizationservice.service.RoleTypeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Log4j2
@Service
public class BrokerServiceImpl implements BrokerService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleTypeService roleTypeService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getBrokers() {
        return userMapper.findAll();
    }

    @Override
    public void addBroker(AddBrokerDTO addBrokerDTO) throws RoleTypeException, BrokerException, DBException {
        log.info("Adding broker: {}", addBrokerDTO.getEmail());
        if (checkIfUserExists(addBrokerDTO.getEmail())) {
            throw new BrokerException(BrokerErrorCode.USER_ALREADY_EXISTS, BrokerErrorCode.USER_ALREADY_EXISTS.getKey());
        }

        User user = User
                .builder()
                .email(addBrokerDTO.getEmail())
                .password(passwordEncoder.encode(addBrokerDTO.getPassword()))
                .firstName(addBrokerDTO.getFirstName())
                .surname(addBrokerDTO.getSurname())
                .dateOfBirth(addBrokerDTO.getDateOfBirth())
                .gender(addBrokerDTO.getGender())
                .createdAt(new Date())
                .lastPasswordDate(new Date())
                .country(countryService.getCountryByCountryCode(addBrokerDTO.getCountryCode()))
                .roleType(roleTypeService.getRoleTypeByInternalCode(RoleTypeMD.BROKER.getInternalCode()))
                .build();

        if (userMapper.save(user) != 1) {
            throw new DBException("Error adding broker");
        }
        log.info("Broker added: {}", addBrokerDTO.getEmail());
    }

    @Override
    public void updateBroker(Long brokerId, UpdateBrokerDTO updateBrokerDTO) throws BrokerException, DBException {
        log.info("Updating broker: {}", brokerId);
        User user = getBroker(brokerId);

        user.setFirstName(updateBrokerDTO.getFirstName());
        user.setSurname(updateBrokerDTO.getSurname());
        user.setDateOfBirth(updateBrokerDTO.getDateOfBirth());

        if (updateBrokerDTO.getPassword() != null) {
            user.setPassword(new BCryptPasswordEncoder().encode(updateBrokerDTO.getPassword()));
            user.setLastPasswordDate(new Date());
        }

        user.setGender(updateBrokerDTO.getGender());
        user.setDeleted(updateBrokerDTO.isDeleted());
        user.setCountry(countryService.getCountryByCountryCode(updateBrokerDTO.getCountryCode()));

        if (userMapper.update(user) != 1) {
            throw new DBException("Error updating broker");
        }

        log.info("Broker updated: {}", brokerId);
    }

    @Override
    public void deleteBroker(Long brokerId) throws BrokerException, DBException {
        log.info("Deleting broker: {}", brokerId);
        User user = getBroker(brokerId);

        user.setDeleted(true);
        user.setDateDeleted(new Date());

        if (userMapper.update(user) != 1) {
            throw new DBException("Error updating broker");
        }
        log.info("Broker deleted: {}", brokerId);
    }

    @Override
    public List<User> getBrokerLikeNameOrEmail(String name) throws BrokerException {
        log.info("Searching broker by name: {}", name);

        if (!StringUtils.hasText(name)) {
            log.info("Name or email is null");
            throw new BrokerException(BrokerErrorCode.NAME_OR_EMAIL_NOT_NULL, BrokerErrorCode.NAME_OR_EMAIL_NOT_NULL.getKey());
        }

        List<User> brokerList =  userMapper.findByName(name);
        brokerList.add(userMapper.findByEmail(name));

        return brokerList;
    }

    @Override
    public User getBrokerById(Long brokerId) throws BrokerException {
        log.info("Searching broker by id: {}", brokerId);

        return getBroker(brokerId);
    }

    @Override
    public void setBrokerToOrganization(Long brokerId, Organization organization) throws BrokerException, DBException {
        log.info("Setting broker: {} to organization: {}", brokerId, organization.getId());
        User broker = getBroker(brokerId);

        broker.setOrganization(organization);

        if (userMapper.update(broker) != 1) {
            throw new DBException("Error updating broker");
        }

        log.info("Broker: {} set to organization: {}", brokerId, organization.getId());
    }

    @Override
    public User findUserByEmail(String email) {
        log.info("Searching broker by email: {}", email);

        return userMapper.findByEmail(email);
    }


    private User getBroker(Long brokerId) throws BrokerException {
        if (brokerId == null) {
            throw new BrokerException(BrokerErrorCode.USER_ID_NOT_NULL, BrokerErrorCode.USER_ID_NOT_NULL.getKey());
        }

        User user = userMapper.findById(brokerId);

        if (user == null) {
            throw new BrokerException(BrokerErrorCode.USER_NOT_FOUND, BrokerErrorCode.USER_NOT_FOUND.getKey());
        }

        return user;
    }

    private boolean checkIfUserExists(String email) throws BrokerException {
        log.info("Checking if user exists: {}", email);
        if (!StringUtils.hasText(email)) {
            throw new BrokerException(BrokerErrorCode.EMAIL_NOT_NULL, BrokerErrorCode.EMAIL_NOT_NULL.getKey());
        }

        User user = userMapper.findByEmail(email);

        if (user == null) {
            log.info("User with email: {} does not exist", email);
            return false;
        }

        log.info("User with email: {} exists", email);
        return true;
    }


}
