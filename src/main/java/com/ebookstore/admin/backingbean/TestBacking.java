package com.ebookstore.admin.backingbean;

import com.ebookstore.model.Book;
import com.ebookstore.service.BookService;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Narada
 */
@Named(value = "testBacking")
@ViewScoped
public class TestBacking {

    @EJB
    BookService bookService;

    public void testGetAllBooks(){
        List<Book> bookList=bookService.getAllBook();
        
    }
}
