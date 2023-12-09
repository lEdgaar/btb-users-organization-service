package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.AddBrokerDTO;
import com.btb.usersorganizationservice.dto.AddChatDTO;
import com.btb.usersorganizationservice.dto.UpdateBrokerDTO;
import com.btb.usersorganizationservice.entity.Chat;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.persistence.mapper.UserMapper;
import com.btb.usersorganizationservice.service.BrokerService;
import com.btb.usersorganizationservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class BrokerServiceImpl implements BrokerService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CountryService countryService;

    @Override
    public List<User> getBrokers() {
        return userMapper.findAll();
    }

    @Override
    public void addBroker(AddBrokerDTO addBrokerDTO) {
        User user = new User();
        user.setFirstName(addBrokerDTO.getFirstName());
        user.setSurname(addBrokerDTO.getSurname());
        user.setEmail(addBrokerDTO.getEmail());
        user.setDateOfBirth(addBrokerDTO.getDateOfBirth());
        user.setPassword(addBrokerDTO.getPassword());
        user.setGender(addBrokerDTO.getGender());
        user.setCountry(countryService.getCountryByCountryCode(addBrokerDTO.getCountryCode()));

        userMapper.save(user);
    }

    @Override
    public void updateBroker(Long brokerId, UpdateBrokerDTO updateBrokerDTO) {
        User user = getBroker(brokerId);

        if (user != null) {
            user.setFirstName(updateBrokerDTO.getFirstName());
            user.setSurname(updateBrokerDTO.getSurname());
            user.setDateOfBirth(updateBrokerDTO.getDateOfBirth());
            user.setPassword(updateBrokerDTO.getPassword());
            user.setGender(updateBrokerDTO.getGender());
            user.setDeleted(updateBrokerDTO.isDeleted());
            user.setCountry(countryService.getCountryByCountryCode(updateBrokerDTO.getCountryCode()));

            userMapper.update(user);
        } else {
            // ERROR
        }

    }

    @Override
    public void deleteBroker(Long brokerId) {
        User user = getBroker(brokerId);

        user.setDeleted(true);
        user.setDateDeleted(new Date());

        userMapper.update(user);
    }

    @Override
    public List<User> getBrokerLikeName(String name) {
        if (!StringUtils.hasText(name)) {
            // ERROR
        }

        return userMapper.findByName(name);
    }

    @Override
    public User getBrokerById(Long brokerId) {
        return getBroker(brokerId);
    }

    @Override
    public void setBrokerToOrganization(Long brokerId, Organization organization) {
        User broker = getBroker(brokerId);

        broker.setOrganization(organization);

        userMapper.update(broker);
    }

    private User getBroker(Long brokerId) {
        if (brokerId == null) {
            // ERROR
        }

        User user = userMapper.findById(brokerId);

        if (user == null) {
            // ERROR
        }

        return user;
    }

}
