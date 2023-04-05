package com.relations._02;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long uid;

    private String full_name;

    private String email;

    private Date dateJoined;

    private Boolean isActive;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_books",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "uid"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    )//this relationship is bidirectional
    private List<Book> bookList;

    public void addBook(Book ... books){
        if(bookList == null)
            bookList=new ArrayList<>();
        bookList.addAll(List.of(books));
    }

}
