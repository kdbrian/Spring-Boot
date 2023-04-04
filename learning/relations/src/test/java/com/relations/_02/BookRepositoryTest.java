package com.relations._02;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookRepositoryTest {

    private static Logger LOGGER ;

    static { LOGGER = LoggerFactory.getLogger(BookRepositoryTest.class);}

    private final BookRepository bookRepository;

    @Autowired
    public BookRepositoryTest(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    public void testSaveBook(){
        Book book = Book.builder()
                .title("Strictly no bitches")
                .genre(Genre.COMPUTER)
                .noOfPages(254)
                .build();

        bookRepository.save(book);
    }

    @Test
    public void testPrintBooks(){
        List<Book> books = bookRepository.findAll();
        LOGGER.info("Books : "+books);
    }
}
