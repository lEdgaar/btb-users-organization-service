package com.btb.usersorganizationservice.dto;

import com.btb.usersorganizationservice.common.validation.annotations.NotNullOrEmpty;;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

    @Size(max = 25)
    @NotNullOrEmpty
    private String firstName;

    @Size(max = 50)
    @NotNullOrEmpty
    private String surname;

    @Past
    @NotNullOrEmpty
    private Date dateOfBirth;

    @Size(max = 1)
    @NotNullOrEmpty
    private String gender;

    @Size(max = 25)
    @NotNullOrEmpty
    private String password;

    private boolean isDeleted;

    @NotNullOrEmpty
    private String countryCode;

}
