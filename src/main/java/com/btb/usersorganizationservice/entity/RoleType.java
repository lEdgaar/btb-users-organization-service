package com.btb.usersorganizationservice.entity;

import lombok.*;


@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleType extends BaseModel<Long> {

    private static final long serialVersionUID = 1L;

    private long id;

    private String roleName;

    private String internalCode;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }



}
