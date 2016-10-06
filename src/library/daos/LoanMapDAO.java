/*
 * Decompiled with CFR 0_115.
 */
package library.daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.daos.ILoanHelper;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public class LoanMapDAO
implements ILoanDAO {
    private int nextID;
    private Map<Integer, ILoan> loanMap;
    private ILoanHelper helper;
    private Calendar cal;

    public LoanMapDAO(ILoanHelper helper) {
        if (helper == null) {
            throw new IllegalArgumentException(String.format("LoanMapDAO : constructor : helper cannot be null.", new Object[0]));
        }
        this.nextID = 0;
        this.helper = helper;
        this.loanMap = new HashMap<Integer, ILoan>();
        this.cal = Calendar.getInstance();
    }

    public LoanMapDAO(ILoanHelper helper, Map<Integer, ILoan> loanMap) {
        this(helper);
        if (loanMap == null) {
            throw new IllegalArgumentException(String.format("LoanMapDAO : constructor : loanMap cannot be null.", new Object[0]));
        }
        this.loanMap = loanMap;
    }

    @Override
    public ILoan getLoanByID(int id) {
        if (this.loanMap.containsKey(id)) {
            return this.loanMap.get(id);
        }
        return null;
    }

    @Override
    public ILoan getLoanByBook(IBook book) {
        if (book == null) {
            throw new IllegalArgumentException(String.format("LoanMapDAO : getLoanByBook : book cannot be null.", new Object[0]));
        }
        for (ILoan loan : this.loanMap.values()) {
            IBook tempBook = loan.getBook();
            if (!book.equals(tempBook)) continue;
            return loan;
        }
        return null;
    }

    @Override
    public List<ILoan> listLoans() {
        ArrayList<ILoan> list = new ArrayList<ILoan>(this.loanMap.values());
        return Collections.unmodifiableList(list);
    }

    @Override
    public List<ILoan> findLoansByBorrower(IMember borrower) {
        if (borrower == null) {
            throw new IllegalArgumentException(String.format("LoanMapDAO : findLoansByBorrower : borrower cannot be null.", new Object[0]));
        }
        ArrayList<ILoan> list = new ArrayList<ILoan>();
        for (ILoan loan : this.loanMap.values()) {
            if (!borrower.equals(loan.getBorrower())) continue;
            list.add(loan);
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public List<ILoan> findLoansByBookTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException(String.format("LoanMapDAO : findLoansByBookTitle : title cannot be null or blank.", new Object[0]));
        }
        ArrayList<ILoan> list = new ArrayList<ILoan>();
        for (ILoan loan : this.loanMap.values()) {
            String tempTitle = loan.getBook().getTitle();
            if (!title.equals(tempTitle)) continue;
            list.add(loan);
        }
        return Collections.unmodifiableList(list);
    }

    @Override
    public void updateOverDueStatus(Date currentDate) {
        for (ILoan loan : this.loanMap.values()) {
            loan.checkOverDue(currentDate);
        }
    }

    @Override
    public List<ILoan> findOverDueLoans() {
        ArrayList<ILoan> list = new ArrayList<ILoan>();
        for (ILoan loan : this.loanMap.values()) {
            if (!loan.isOverDue()) continue;
            list.add(loan);
        }
        return Collections.unmodifiableList(list);
    }

    private int getNextId() {
        return ++this.nextID;
    }

    @Override
    public ILoan createLoan(IMember borrower, IBook book) {
        if (borrower == null || book == null) {
            throw new IllegalArgumentException(String.format("LoanMapDAO : createLoan : borrower and book cannot be null.", new Object[0]));
        }
        Date borrowDate = new Date();
        this.cal.setTime(borrowDate);
        this.cal.add(5, 14);
        Date dueDate = this.cal.getTime();
        ILoan loan = this.helper.makeLoan(book, borrower, borrowDate, dueDate);
        return loan;
    }

    @Override
    public void commitLoan(ILoan loan) {
        int id = this.getNextId();
        loan.commit(id);
        this.loanMap.put(id, loan);
    }
}

