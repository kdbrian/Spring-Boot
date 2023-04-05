package com.relations._02;

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
public class Book {

    @Id
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    private Long bookId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int noOfPages;

    @ManyToMany(mappedBy = "bookList")//must exist for many to many mapping
    private List<User> users;

}
