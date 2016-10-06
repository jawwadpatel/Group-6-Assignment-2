/*
 * Decompiled with CFR 0_115.
 */
package library.interfaces.entities;

import java.util.Date;
import library.interfaces.entities.IBook;
import library.interfaces.entities.IMember;

public interface ILoan {
    public static final int LOAN_PERIOD = 14;

    public void commit(int var1);

    public void complete();

    public boolean isOverDue();

    public boolean checkOverDue(Date var1);

    public IMember getBorrower();

    public IBook getBook();

    public int getID();
}

