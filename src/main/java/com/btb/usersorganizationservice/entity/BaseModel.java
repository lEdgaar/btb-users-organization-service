package com.btb.usersorganizationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseModel<T extends Serializable> implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private final transient Logger logger = LoggerFactory.getLogger(getClass());

    public abstract T getId();

    public abstract void setId(T id);

    public boolean equals(BaseModel entity){

        if (entity == null)	return false;

        return getId().equals(entity.getId());
    }

}
