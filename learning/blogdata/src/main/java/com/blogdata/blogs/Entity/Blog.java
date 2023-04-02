package com.blogdata.blogs.Entity;

import com.blogdata.users.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {

    @SequenceGenerator(
            name = "blog_seq",
            sequenceName = "blog_seq"
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_seq")
    private Long postId;

    private String contents;

    private int likes;



}
