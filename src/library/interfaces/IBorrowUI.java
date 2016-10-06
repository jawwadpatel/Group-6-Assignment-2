/*
 * Decompiled with CFR 0_115.
 */
package library.interfaces;

import library.interfaces.EBorrowState;

public interface IBorrowUI {
    public void setState(EBorrowState var1);

    public void displayMemberDetails(int var1, String var2, String var3);

    public void displayExistingLoan(String var1);

    public void displayOverDueMessage();

    public void displayAtLoanLimitMessage();

    public void displayOutstandingFineMessage(float var1);

    public void displayOverFineLimitMessage(float var1);

    public void displayScannedBookDetails(String var1);

    public void displayPendingLoan(String var1);

    public void displayConfirmingLoan(String var1);

    public void displayErrorMessage(String var1);
}

