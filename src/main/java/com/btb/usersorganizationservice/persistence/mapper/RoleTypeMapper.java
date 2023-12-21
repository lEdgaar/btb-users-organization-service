package com.btb.usersorganizationservice.persistence.mapper;

import com.btb.usersorganizationservice.entity.RoleType;

public interface RoleTypeMapper {

    RoleType findByRoleCode(String internalCode);
}
