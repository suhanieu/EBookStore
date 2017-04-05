package com.ebookstore.customer.backingbean;

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
@Named(value = "customerHomePageDisplayBacking")
@ViewScoped
public class CustomerHomePageDisplayBacking {

    @EJB
    BookService bookService;

    List<Book> recentlyAddedbooks;

    public List<Book> getRecentlyAddedbooks() {
        return recentlyAddedbooks;
    }

    public void setRecentlyAddedbooks(List<Book> recentlyAddedbooks) {
        this.recentlyAddedbooks = recentlyAddedbooks;
    }

    public void readRecentlyAddedBook() {
        recentlyAddedbooks = bookService.getRecentlyAddedBooks();
    }

}
