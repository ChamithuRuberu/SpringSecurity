package com.example.demoapp.repository;

import com.example.demoapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
