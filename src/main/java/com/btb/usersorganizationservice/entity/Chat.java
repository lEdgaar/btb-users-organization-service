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
public class Chat extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private Long id;

    private User userSendedId;

    private User userRecivedId;

    private String message;

    private Date createdAt;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
