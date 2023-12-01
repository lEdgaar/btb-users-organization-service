package com.btb.usersorganizationservice.dto;

import com.btb.usersorganizationservice.common.validation.annotations.NotNullOrEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @Email
    @NotNullOrEmpty
    private String email;

    @NotNullOrEmpty
    @Size(max = 25)
    private String password;

}
