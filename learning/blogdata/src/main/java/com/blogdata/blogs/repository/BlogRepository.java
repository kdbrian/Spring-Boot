package com.blogdata.blogs.repository;

import com.blogdata.blogs.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
