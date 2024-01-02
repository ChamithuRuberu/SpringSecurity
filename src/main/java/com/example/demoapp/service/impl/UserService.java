package com.example.demoapp.service.impl;
import com.example.demoapp.dto.UserDTO;
import com.example.demoapp.entity.User;
import com.example.demoapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getName() + " " + userDto.getEmail());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

//    Role role = roleRepository.findByName("ROLE_ADMIN");
//        if(role == null){
//            role = checkRoleExist();
//        }
//        user.setRoles(Arrays.asList(role));
//        userRepository.save(user);
//

    public String test(UserDTO user) {
        User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null) {
            return  "There is already an account registered with that email";
        }
        saveUser(user);
        return "redirect:/register?success";
    }
}



