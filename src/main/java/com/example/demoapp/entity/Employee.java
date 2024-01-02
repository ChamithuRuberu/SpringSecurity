package com.example.demoapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "nic")
    private String nic;
    @Column(name = "birthOfDate")
    private String birthOfDate;
    @Column(name = "phone_number")
    private String phone;

}
