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
public class BannedUser extends BaseModel<Long>{

    private static final long serialVersionUID = 1L;

    private Long id;

    private User user;

    private BanReason banReason;

    private Date startDate;

    private Date endDate;

    private boolean isFinished;


    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
