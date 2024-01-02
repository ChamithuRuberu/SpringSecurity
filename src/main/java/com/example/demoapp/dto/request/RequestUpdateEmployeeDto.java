package com.example.demoapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateEmployeeDto {
    private Long id;
    private String fullName;
    private String nic;
    private String birthOfDate;
    private String phone;
}
