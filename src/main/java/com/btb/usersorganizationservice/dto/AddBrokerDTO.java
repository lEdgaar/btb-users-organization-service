package com.btb.usersorganizationservice.dto;

import com.btb.usersorganizationservice.common.validation.annotations.NotNullOrEmpty;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.validation.executable.ValidateOnExecution;
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

    @Size(max = 25)
    @NotNullOrEmpty
    private String firstName;

    @Size(max = 50)
    @NotNullOrEmpty
    private String surname;

    @Size(max = 50)
    @Email
    @NotNullOrEmpty
    private String email;

    @Past
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfBirth;

    private String gender;

    @Size(max = 25)
    @NotNullOrEmpty
    private String password;

    @NotNullOrEmpty
    private String countryCode;

    private String roleTypeId;

}
