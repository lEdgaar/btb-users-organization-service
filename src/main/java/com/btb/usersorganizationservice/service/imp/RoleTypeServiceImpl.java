package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.entity.RoleType;
import com.btb.usersorganizationservice.exception.RoleTypeErrorCode;
import com.btb.usersorganizationservice.exception.RoleTypeException;
import com.btb.usersorganizationservice.persistence.mapper.RoleTypeMapper;
import com.btb.usersorganizationservice.service.RoleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RoleTypeServiceImpl implements RoleTypeService {

    @Autowired
    private RoleTypeMapper roleTypeMapper;


    @Override
    public RoleType getRoleTypeByInternalCode(String internalCode) throws RoleTypeException {
        return getRoleType(internalCode);
    }

    private RoleType getRoleType(String internalCode) throws RoleTypeException {
        if (!StringUtils.hasText(internalCode)) {
            throw new RoleTypeException(RoleTypeErrorCode.ROLE_TYPE_INTERNAL_CODE_NOT_NULL, RoleTypeErrorCode.ROLE_TYPE_INTERNAL_CODE_NOT_NULL.getKey());
        }

        RoleType roleType = roleTypeMapper.findByRoleCode(internalCode);

        if (roleType == null) {
            throw new RoleTypeException(RoleTypeErrorCode.ROLE_TYPE_NOT_FOUND, RoleTypeErrorCode.ROLE_TYPE_NOT_FOUND.getKey());
        }

        return roleType;
    }

}
