/*
 * Decompiled with CFR 0_115.
 */
package library.interfaces.daos;

import java.util.List;

import library.interfaces.entities.EBookState;
import library.interfaces.entities.IBook;

public interface IBookDAO {
    public IBook addBook(String var1, String var2, String var3);

    public IBook getBookByID(int var1);

    public List<IBook> listBooks();

    public List<IBook> findBooksByAuthor(String var1);

    public List<IBook> findBooksByTitle(String var1);

    public List<IBook> findBooksByAuthorTitle(String var1, String var2);
    
    // New method to change book status
    public void setBookStatus(IBook book);
}

