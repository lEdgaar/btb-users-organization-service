package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.dto.BanUserDTO;
import com.btb.usersorganizationservice.entity.BannedUser;
import com.btb.usersorganizationservice.entity.User;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;
import com.btb.usersorganizationservice.persistence.mapper.BannedUserMapper;
import com.btb.usersorganizationservice.persistence.mapper.UserMapper;
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

    @Autowired
    private UserMapper userMapper;

    @Override
    public void banUser(BanUserDTO banUserDTO) throws BrokerException, DBException {
        log.trace("Ban user: {}", banUserDTO.getUserId());

        User user = brokerService.getBrokerById(banUserDTO.getUserId());

        user.setBlocked(true);
        user.setDateBlocked(new Date());

        if (userMapper.update(user) != 1) {
            throw new DBException("Error updating broker");
        }

        BannedUser bannedUser = new BannedUser();
        bannedUser.setUser(user);
        bannedUser.setBanReason(banReasonService.getBanReasonById(banUserDTO.getBanReasonId()));
        bannedUser.setStartDate(new Date());
        bannedUser.setEndDate(banUserDTO.getEndDate());

        if (bannedUserMapper.save(bannedUser) != 1) {
            throw new DBException("Error saving banned user");
        }

        log.trace("User: {} banned", banUserDTO.getUserId());
    }

    @Override
    public void desbanUsers() {
        log.trace("Desban users");

        bannedUserMapper.findAll().forEach(bannedUser -> {
            if (bannedUser.getEndDate().before(new Date())) {
                log.trace("Desban user: {}", bannedUser.getUser().getId());

                bannedUser.getUser().setBlocked(false);
                bannedUser.getUser().setDateBlocked(null);

                try {
                    if (userMapper.update(bannedUser.getUser()) != 1) {
                        throw new DBException("Error updating broker");
                    }
                } catch (DBException e) {
                    log.error("Error desbaning user: {}", bannedUser.getUser().getId());
                }

                bannedUserMapper.delete(bannedUser.getId());
            }
        });

        log.trace("Desban users finished");
    }

}
