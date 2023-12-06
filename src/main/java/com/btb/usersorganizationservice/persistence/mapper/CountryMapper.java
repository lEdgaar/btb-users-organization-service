package com.btb.usersorganizationservice.persistence.mapper;

import com.btb.usersorganizationservice.entity.Country;

public interface CountryMapper {

    Country findByCountryCode(String countryCode);

}
