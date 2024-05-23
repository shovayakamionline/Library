package com.shova.Runner;

import com.shova.Controller.BookDaoImpl;
import com.shova.Daointreface.BookDao;
import com.shova.model.Books;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 6.1: Insert Books Record
public class AccessBook {
    public static void main(String[] args) {
        // creating object
        BookDao bookDao = new BookDaoImpl();
        System.out.println("--------- inserting book records ----------");

        List<Books> BookList = new ArrayList<>();

        Books b1 = new Books();
        b1.setIsbn(120);
        b1.setBookName("Java Book");
        BookList.add(b1);

        Books b2 = new Books();
        b2.setIsbn(300);
        b2.setBookName("Python Book");
        BookList.add(b2);

        Books b3 = new Books();
        b3.setIsbn(365);
        b3.setBookName("JavaScript Book");
        BookList.add(b3);

        Books b4 = new Books();
        b4.setIsbn(256);
        b4.setBookName("SQL Book");
        BookList.add(b4);

        bookDao.saveBook(BookList);

//    Step 6.2: Retrieve Books
        System.out.println(" ====== Display list of all books ====");
        try {
            for (Books cc : bookDao.getAllBooks()) {
                int ISBN = cc.getIsbn();
                String BookName = cc.getBookName();
                System.out.println("======================");
                System.out.println("ISBN Number :" + ISBN + "and Book name: " + BookName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

      //6.3: Update Book record
        System.out.println("----Book information is updating -----");
        Books Bookupdating = new Books();
        Bookupdating.setIsbn(3);
        Bookupdating.setBookName("Algorithms Book");
        boolean result = bookDao.updateBook(Bookupdating, 3);
        System.out.println(result);

        //6.4: Delete Book record by id
        boolean a = bookDao.deleteBook(4); // 4 is a id of book
        if (a == true) {
            System.out.println("Record is deleted");
        } else {
            System.out.println("Record is not deleted");
        }
    }
}
