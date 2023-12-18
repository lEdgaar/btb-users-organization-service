package com.btb.usersorganizationservice.service.imp;

import com.btb.usersorganizationservice.entity.BanReason;
import com.btb.usersorganizationservice.persistence.mapper.BanReasonMapper;
import com.btb.usersorganizationservice.service.BanReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BanReasonServiceImpl implements BanReasonService {

    @Autowired
    private BanReasonMapper banReasonMapper;

    @Override
    public BanReason getBanReasonById(Long banReasonId) {
        return banReasonMapper.findById(banReasonId);
    }

}
