package com.ebookstore.customer.backingbean;

import com.ebookstore.model.Book;
import com.ebookstore.service.BookService;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Suha
 */
@Named(value = "customerDisplayBooksBySubCategoryBacking")
@ViewScoped
public class CustomerDisplayBooksBySubCategoryBacking {

    @EJB
    BookService bookService;

    private int subCategoryId;
    List<Book> bookList;

    public int getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(int subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
    
    
    public void readBooksBySubcategoryid(){
        bookList=bookService.getBooksBySubcategoryId(subCategoryId);
    }

   

}
