package com.library.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
