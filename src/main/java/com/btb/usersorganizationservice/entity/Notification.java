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
public class Notification extends BaseModel<Long>{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String action;

    private boolean viaMail;

    private boolean isAlert;

    private boolean isActive;

    private Date createdAt;

    private Date endTimeAt;

    private User user;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
