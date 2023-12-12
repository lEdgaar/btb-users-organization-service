package com.btb.usersorganizationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSetting extends BaseModel<Long>{

    private static final long serialVersionUID = 1L;

    private Long id;

    private boolean sendNotifications;

    private boolean sendEmails;

    private boolean sendGroupRequest;

    private boolean showBriefcase;

    private boolean showAssets;

    private boolean showActives;

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
