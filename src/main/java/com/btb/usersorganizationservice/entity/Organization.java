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
public class Organization extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private long id;

    private String organizationName;

    private String description;

    private String urlPicture;

    private Date createdAt;

    private boolean isDeleted;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
