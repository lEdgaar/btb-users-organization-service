package com.btb.usersorganizationservice.dto;

import com.btb.usersorganizationservice.common.validation.annotations.NotNullOrEmpty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
