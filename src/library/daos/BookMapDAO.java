/*
 * Decompiled with CFR 0_115.
 */
package library.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.IBookHelper;
import library.interfaces.entities.IBook;

public class BookMapDAO
implements IBookDAO {
    private int nextId;
    private Map<Integer, IBook> bookMap;
    private IBookHelper helper;

    public BookMapDAO(IBookHelper helper) {
        if (helper == null) {
            throw new IllegalArgumentException(String.format("BookDAO : constructor : helper cannot be null.", new Object[0]));
        }
        this.nextId = 1;
        this.helper = helper;
        this.bookMap = new HashMap<Integer, IBook>();
    }

    public BookMapDAO(IBookHelper helper, Map<Integer, IBook> bookMap) {
        this(helper);
        if (helper == null) {
            throw new IllegalArgumentException(String.format("BookDAO : constructor : bookMap cannot be null.", new Object[0]));
        }
        this.bookMap = bookMap;
    }

    @Override
    public IBook addBook(String author, String title, String callNo) {
        int id = this.getNextId();
        IBook book = this.helper.makeBook(author, title, callNo, id);
        this.bookMap.put(id, book);
        return book;
    }

    @Override
    public IBook getBookByID(int id) {
        if (this.bookMap.containsKey(id)) {
            return this.bookMap.get(id);
        }
        return null;
    }

    @Override
    public List<IBook> listBooks() {
        ArrayList<IBook> list = new ArrayList<IBook>(this.bookMap.values());
        return Collections.unmodifiableList(list);
    }

    @Override
    public List<IBook> findBooksByAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException(String.format("BookDAO : findBooksByAuthor : author cannot be null or blank", new Object[0]));
        }
        ArrayList<IBook> list = new ArrayList<IBook>();
        for (IBook b : this.bookMap.values()) {
            if (!author.equals(b.getAuthor())) continue;
            list.add(b);
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public List<IBook> findBooksByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException(String.format("BookDAO : findBooksByAuthor : author cannot be null or blank", new Object[0]));
        }
        ArrayList<IBook> list = new ArrayList<IBook>();
        for (IBook b : this.bookMap.values()) {
            if (!title.equals(b.getTitle())) continue;
            list.add(b);
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public List<IBook> findBooksByAuthorTitle(String author, String title) {
        if (title == null || title.isEmpty() || author == null || author.isEmpty()) {
            throw new IllegalArgumentException(String.format("BookDAO : findBooksByAuthor : author and title cannot be null or blank", new Object[0]));
        }
        ArrayList<IBook> list = new ArrayList<IBook>();
        for (IBook b : this.bookMap.values()) {
            if (!author.equals(b.getAuthor()) || !title.equals(b.getTitle())) continue;
            list.add(b);
        }
        return Collections.unmodifiableList(list);
    }
    
    // New function to set the change the book status
    @Override
    public void setBookStatus(IBook book)
    {
    	for (IBook b : this.bookMap.values()) {
    		
    		if(b.getID() == book.getID()){
    			b = book;
    		}
            
        }
    }
    
    private int getNextId() {
        return this.nextId++;
    }
}

