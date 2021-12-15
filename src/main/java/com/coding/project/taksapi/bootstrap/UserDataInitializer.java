package com.coding.project.taksapi.bootstrap;

import com.coding.project.taksapi.domain.User;
import com.coding.project.taksapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public UserDataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count()==0){
            userRepository.save(User.builder().userName("Abhishek Aryan")
                            .password("12345")
                            .email("send2abhishek@live.com")
                            .phoneNumber(1234567890)
                            .build());
        }
    }
}
