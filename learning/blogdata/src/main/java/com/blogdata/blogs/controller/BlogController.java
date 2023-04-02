package com.blogdata.blogs.controller;

import com.blogdata.blogs.Entity.Blog;
import com.blogdata.blogs.repository.BlogRepository;
import com.blogdata.users.entity.User;
import com.blogdata.users.entity.UserNotFoundException;
import com.blogdata.users.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogRepository blogRepository;
    private final UserRepo userRepo;

    private static Logger LOGGER;


    static{
        LOGGER = LoggerFactory.getLogger(BlogController.class);
    };


    @Autowired
    public BlogController(BlogRepository blogRepository, UserRepo userRepo) {
        this.blogRepository = blogRepository;
        this.userRepo = userRepo;
    }

    @GetMapping("/")
    public List<Blog> getBlogs(){
        return blogRepository.findAll();
    }

    @PostMapping("/new/{user_id}")
    public Blog createBlog(@PathVariable(name = "user_id") Long id ,@RequestBody Blog blog){

        LOGGER.info(""+id);
        LOGGER.info(""+blog);

        if(userRepo.findById(id).isEmpty())
            throw new UserNotFoundException("User with id "+id+"Not found");

        Blog newBlog = Blog.builder()
                .contents(blog.getContents())
                .build();
        User user = userRepo.findById(id).get();

        user.addBlog(newBlog);

        blogRepository.save(newBlog);

        return newBlog;
    }
}
