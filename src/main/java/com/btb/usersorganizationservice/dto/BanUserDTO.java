package com.btb.usersorganizationservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BanUserDTO {

    private Long userId;

    private Long banReasonId;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date endDate;

}
