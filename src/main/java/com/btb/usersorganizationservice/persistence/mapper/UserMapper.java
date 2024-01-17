package com.btb.usersorganizationservice.persistence.mapper;

import com.btb.usersorganizationservice.entity.User;

import java.util.List;

public interface UserMapper extends CommonMapper<User, Long>{

    User findByEmail(String email);
}
