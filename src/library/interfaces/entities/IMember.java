/*
 * Decompiled with CFR 0_115.
 */
package library.interfaces.entities;

import java.util.List;
import library.interfaces.entities.EMemberState;
import library.interfaces.entities.ILoan;

public interface IMember {
    public static final int LOAN_LIMIT = 5;
    public static final float FINE_LIMIT = 10.0f;

    public boolean hasOverDueLoans();

    public boolean hasReachedLoanLimit();

    public boolean hasFinesPayable();

    public boolean hasReachedFineLimit();

    public float getFineAmount();

    public void addFine(float var1);

    public void payFine(float var1);

    public void addLoan(ILoan var1);

    public List<ILoan> getLoans();

    public void removeLoan(ILoan var1);

    public EMemberState getState();

    public String getFirstName();

    public String getLastName();

    public String getContactPhone();

    public String getEmailAddress();

    public int getID();
}

