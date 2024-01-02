package com.example.demoapp.dto.request;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestEmployeeDto {
    @NotEmpty(message = "username shouldn't be null")
    private String fullName;
    @NotBlank
    private String nic;
    private String birthOfDate;
    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
    private String phone;
}
