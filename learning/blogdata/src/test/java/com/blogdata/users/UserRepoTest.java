package com.blogdata.users;

import com.blogdata.blogs.Entity.Blog;
import com.blogdata.users.entity.User;
import com.blogdata.users.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class UserRepoTest {


    private final UserRepo userRepo;

    @Autowired
    public UserRepoTest(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Test
    void contextLoads(){}

    @Test
    public void saveUser(){
        User new_usre = User.builder()
                .username("admin")
                .dateJoined(new Date(System.currentTimeMillis()))
                .build();

        userRepo.save(new_usre);
    }

    @Test
    public void getAllUsers(){
        List<User> users = userRepo.findAll();
        System.out.println("users = " + users);
    }

    @Test
    public void createBlogWithUser(){

        Blog blog = Blog.builder()//a new blog
                .contents("Whoa it worked2..!!")
                .build();

        User user = User.builder()//creating a new user
                .username("demouser2")
                .dateJoined(new Date(System.currentTimeMillis()))
//                .userBlogs(Set.of(blog))//registering the new blog to this user
                .build();
        user.addBlog(blog);

        userRepo.save(user);
    }
}
