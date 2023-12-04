package com.btb.usersorganizationservice.dto;

import com.btb.usersorganizationservice.entity.Country;
import com.btb.usersorganizationservice.entity.Organization;
import com.btb.usersorganizationservice.entity.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddBrokerDTO {

    private String email;

    private Date dateOfBirth;

    private char gender;

    private String password;

    private Country country;

}
