package com.btb.usersorganizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrganizationDTO {

    private String name;

    private String description;

    private String urlPicture;

    private boolean isDeleted;

}
