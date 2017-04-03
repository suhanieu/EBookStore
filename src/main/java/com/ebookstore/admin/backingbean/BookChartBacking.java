/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebookstore.admin.backingbean;

import com.ebookstore.model.Book;
import com.ebookstore.service.BookService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

/**
 *
 * @author Narada
 */
@Named(value = "bookChartBacking")
@ViewScoped
public class BookChartBacking implements Serializable{

    @EJB
    BookService bookService;

    List<Book> bookList = new ArrayList<Book>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    private LineChartModel model;

    public LineChartModel getModel() {
        return model;
    }

    public void readAllBooks() {
        bookList = bookService.getAllBook();
        model = new LineChartModel();
        ChartSeries books = new ChartSeries();
        for (Book b : bookList) {
            books.set(b.getTitle(), b.getQuantity());
        }
        model.addSeries(books);
      
        model.setTitle("Available Stock");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        model.getAxes().put(AxisType.X, new CategoryAxis("Title"));
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Quantity");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

}
