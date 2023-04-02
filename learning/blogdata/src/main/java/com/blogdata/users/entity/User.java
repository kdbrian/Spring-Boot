package com.blogdata.users.entity;

import com.blogdata.blogs.Entity.Blog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_username",
                columnNames = "username"
        )
)
public final class User {

    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq"
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long user_id;
    private String username;
    private Date dateJoined=new Date(System.currentTimeMillis());

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn(
            name = "user",
            referencedColumnName = "user_id"
    )
    private List<Blog> userBlogs = new ArrayList<>();

    public void addBlog(Blog blog){
        if(userBlogs ==null) userBlogs = new ArrayList<>();

        userBlogs.add(blog);
    }
}
