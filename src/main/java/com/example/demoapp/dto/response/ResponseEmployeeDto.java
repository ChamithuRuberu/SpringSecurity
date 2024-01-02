package com.example.demoapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEmployeeDto {
    private long id;
    private String fullName;
    private String nic;
    private String birthOfDate;
    private String phone;
}
