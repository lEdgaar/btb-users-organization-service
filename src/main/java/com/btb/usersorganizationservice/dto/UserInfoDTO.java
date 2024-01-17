package com.btb.usersorganizationservice.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {

    private Long userId;

    private String firstName;

    private String surname;

    private Date dateOfBirth;

    private String gender;

}
