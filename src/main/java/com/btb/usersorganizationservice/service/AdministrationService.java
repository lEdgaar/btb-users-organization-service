package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.dto.BanUserDTO;
import com.btb.usersorganizationservice.exception.BrokerException;
import com.btb.usersorganizationservice.exception.DBException;

public interface AdministrationService {

    void banUser(BanUserDTO banUserDTO) throws BrokerException, DBException;

    void desbanUsers();

}
