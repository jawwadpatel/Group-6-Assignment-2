/*
 * Decompiled with CFR 0_115.
 */
package library.interfaces.daos;

import java.util.Date;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

public interface ILoanHelper {
    public ILoan makeLoan(IBook var1, IMember var2, Date var3, Date var4);
}

