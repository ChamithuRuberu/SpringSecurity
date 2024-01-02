package com.example.demoapp.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
}