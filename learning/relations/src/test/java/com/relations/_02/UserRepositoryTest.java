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
    public void testSaveUserBook(){
        //test for saving a user with a book
        Book book = Book.builder()//we have to enable cascading to save this book too
                .title("a test defactor")
                .noOfPages(290)
                .genre(Genre.COMPUTER)
                .build();
        User user = User.builder()
                .full_name("demo user")
                .dateJoined(new Date(System.currentTimeMillis()))
                .isActive(true)
                .build();
        user.addBook(book);//registering the book to the user

        userRepository.save(user);
    }

    @Test
    public void testGetAllUsers(){
        List<User> users = userRepository.findAll();
        System.out.println("users = " + users);
    }
}
