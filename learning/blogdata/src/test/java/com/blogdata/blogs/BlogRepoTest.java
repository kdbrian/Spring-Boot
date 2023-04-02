package com.blogdata.blogs;

import com.blogdata.blogs.Entity.Blog;
import com.blogdata.blogs.repository.BlogRepository;
import com.blogdata.users.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Set;

@SpringBootTest
public class BlogRepoTest {

    private  final BlogRepository blogRepository;

    @Autowired
    public BlogRepoTest(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Test
    void contextLoads(){}

    @Test
    public void saveBlog(){

        Blog newBlog = Blog.builder()
                .contents("Hello this is my second blog")
                .build();
        blogRepository.save(newBlog);
    }


}
