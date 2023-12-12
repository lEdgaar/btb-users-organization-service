package com.btb.usersorganizationservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationRestriction extends BaseModel<Long>{

    private static final long serialVersionUID = 1L;

    private Long id;

    private Organization organization;

    private Double limitPositions;

    private Double globalLimitPositions;

    private Long riskLimit;

    private boolean shareInformation;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
