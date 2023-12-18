package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.BanUserDTO;
import com.btb.usersorganizationservice.entity.BannedUser;
import com.btb.usersorganizationservice.persistence.mapper.BannedUserMapper;
import com.btb.usersorganizationservice.service.AdministrationService;
import com.btb.usersorganizationservice.service.BanReasonService;
import com.btb.usersorganizationservice.service.BrokerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Log4j2
@Service
public class AdministrationServiceImpl implements AdministrationService {

    @Autowired
    private BrokerService brokerService;

    @Autowired
    private BanReasonService banReasonService;

    @Autowired
    private BannedUserMapper bannedUserMapper;

    @Override
    public void banUser(BanUserDTO banUserDTO) {
        log.trace("Ban user: {}", banUserDTO.getUserId());

        BannedUser bannedUser = new BannedUser();
        bannedUser.setUser(brokerService.getBrokerById(banUserDTO.getUserId()));
        bannedUser.setBanReason(banReasonService.getBanReasonById(banUserDTO.getBanReasonId()));
        bannedUser.setStartDate(new Date());
        bannedUser.setEndDate(banUserDTO.getEndDate());

        bannedUserMapper.save(bannedUser);
        log.trace("User: {} banned", banUserDTO.getUserId());
    }

}
