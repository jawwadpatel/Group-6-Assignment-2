/*
 * Decompiled with CFR 0_115.
 */
package library.interfaces.daos;

import java.util.Date;
import java.util.List;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public interface ILoanDAO {
    public ILoan createLoan(IMember var1, IBook var2);

    public void commitLoan(ILoan var1);

    public ILoan getLoanByID(int var1);

    public ILoan getLoanByBook(IBook var1);

    public List<ILoan> listLoans();

    public List<ILoan> findLoansByBorrower(IMember var1);

    public List<ILoan> findLoansByBookTitle(String var1);

    public void updateOverDueStatus(Date var1);

    public List<ILoan> findOverDueLoans();
}

