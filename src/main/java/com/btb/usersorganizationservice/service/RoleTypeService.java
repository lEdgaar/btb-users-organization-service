package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.entity.RoleType;
import com.btb.usersorganizationservice.exception.RoleTypeException;

public interface RoleTypeService {

    RoleType getRoleTypeByInternalCode(String internalCode) throws RoleTypeException;

}
