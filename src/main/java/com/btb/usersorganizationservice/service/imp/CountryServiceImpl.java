package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.entity.Country;
import com.btb.usersorganizationservice.persistence.mapper.CountryMapper;
import com.btb.usersorganizationservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public Country getCountryByCountryCode(String countryCode) {
        Country country = countryMapper.findByCountryCode(countryCode);

        if (country == null) {
            // ERROR
        }

        return country;
    }
}
