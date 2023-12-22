package com.btb.usersorganizationservice.dto.request;

import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SendEventDTO {

    private Long userId;

    private String eventType = "UOS";

    private String description;

}
