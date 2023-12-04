package com.btb.usersorganizationservice.dto;

import com.btb.usersorganizationservice.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrokerDTO {

    private Date dateOfBirth;

    private char gender;

    private String password;

    private boolean isDeleted;

    private Country country;

}
