package com.relations._02;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserRepositoryTest {

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void testSaveUser(){
        User user = User.builder()
                .full_name("yellow boy")
                .email("yellow@dev.io")
                .isActive(true)
                .dateJoined(new Date(System.currentTimeMillis()))
                .build();

        userRepository.save(user);
    }

    @Test
    public void testGetAllUsers(){
        List<User> users = userRepository.findAll();
        System.out.println("users = " + users);
    }
}
