package com.btb.usersorganizationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleType extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    private String internalCode;

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
