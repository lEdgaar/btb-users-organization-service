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
public class User extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    private String firstName; // NUEVO

    private String surname; // NUEVO

    private Date createdAt;

    private Date dateOfBirth;

    private char gender;

    private String password;

    private Date lastPasswordDate;

    private RoleType roleType;

    private Organization organization;

    private boolean isDeleted;

    private Date dateDeleted;

    private boolean isBlocked;

    private Date dateBlocked;

    private Country country;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
