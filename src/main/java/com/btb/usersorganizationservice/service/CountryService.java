package com.btb.usersorganizationservice.service;

import com.btb.usersorganizationservice.entity.Country;

public interface CountryService {

    Country getCountryByCountryCode(String countryCode);

}
