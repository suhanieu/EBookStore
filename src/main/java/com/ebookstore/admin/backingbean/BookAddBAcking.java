package com.ebookstore.admin.backingbean;

import com.ebookstore.service.BookService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Narada
 */
@ManagedBean
@SessionScoped
public class BookAddBAcking implements Serializable {

    @EJB
    BookService bookService;

//    @Named
//    @Produces
//    @RequestScoped
//    Book book = new Book();
    private Part file1;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

    public String upload() {
//         book.setQuantity(5);
//        book.setDescription("Good Book");
//        Subcategory subcategory=new Subcategory();
//        subcategory.setId(10);
//        book.setSubCategoryId(subcategory);
//        book.setAddedDate(new Date());
//        bookService.addNewBook(book);
        // file1.write("F:\\java\\" + getFilename(file1));
        //System.out.println(getFilename(file1));
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\Web Pages\\images\\";
        try {
            InputStream in = file1.getInputStream();
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path + "CCNA.jpg"));
            out.write(data);
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

}
