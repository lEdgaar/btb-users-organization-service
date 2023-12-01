package com.btb.usersorganizationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    private long id;

    private String name;

    private String description;

    private String urlPicture;

    private Date createdAt;

    private boolean isDeleted;

}
