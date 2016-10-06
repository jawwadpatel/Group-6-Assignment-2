/*
 * Decompiled with CFR 0_115.
 */
package library;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import library.interfaces.EBorrowState;
import library.interfaces.IBorrowUI;
import library.interfaces.IBorrowUIListener;
import panels.borrow.ABorrowPanel;
import panels.borrow.ConfirmLoanPanel;
import panels.borrow.RestrictedPanel;
import panels.borrow.ScanningPanel;
import panels.borrow.SwipeCardPanel;

public class BorrowUC_UI
extends JPanel
implements IBorrowUI {
    private static final long serialVersionUID = 1;
    private IBorrowUIListener listener;
    private EBorrowState state;
    private Map<EBorrowState, IBorrowUI> panels;
    private static /* synthetic */ int[] $SWITCH_TABLE$library$interfaces$EBorrowState;

    public BorrowUC_UI(IBorrowUIListener listener) {
    	System.out.println("2.	BorrowUI");
        this.listener = listener;
        this.panels = new HashMap<EBorrowState, IBorrowUI>();
        this.setLayout(new CardLayout());
        
        System.out.println("3.	SwipeCardPanel");
        this.addPanel(new SwipeCardPanel(listener), EBorrowState.INITIALIZED);
        System.out.println("4.	ScanningPanel");
        
        this.addPanel(new ScanningPanel(listener), EBorrowState.SCANNING_BOOKS);
        System.out.println("5.	RestrictedPanel");
        this.addPanel(new RestrictedPanel(listener), EBorrowState.BORROWING_RESTRICTED);
        System.out.println("6.  ConfirmLoanPanel");
        this.addPanel(new ConfirmLoanPanel(listener), EBorrowState.CONFIRMING_LOANS);
    }

    private void addPanel(ABorrowPanel panel, EBorrowState state) {
        this.panels.put(state, panel);
        this.add((Component)panel, state.toString());
    }

    //Button
    
    @Override
    public void setState(EBorrowState state) {
        CardLayout cl = (CardLayout)this.getLayout();
        switch (BorrowUC_UI.$SWITCH_TABLE$library$interfaces$EBorrowState()[state.ordinal()]) {
            case 2: {
                cl.show(this, state.toString());
                break;
            }
            case 3: {
                cl.show(this, state.toString());
                break;
            }
            case 6: {
            	System.out.println("9.1.9 setState(BORROWING_RESTRICTED)");
                cl.show(this, state.toString());
                break;
            }
            case 4: {
                cl.show(this, state.toString());
                break;
            }
            case 5: {
                break;
            }
            case 7: {
                break;
            }
            default: {
                throw new RuntimeException("Unknown state");
            }
        }
        this.state = state;
    }

    @Override
    public void displayMemberDetails(int memberID, String memberName, String memberPhone) {
        IBorrowUI ui = this.panels.get((Object)this.state);
        ui.displayMemberDetails(memberID, memberName, memberPhone);
    }

    @Override
    public void displayOverDueMessage() {
        IBorrowUI ui = this.panels.get((Object)this.state);
        System.out.println("9.1.13.1.	displayOverDueMessage()");
        ui.displayOverDueMessage();
    }

    @Override
    public void displayAtLoanLimitMessage() {
        IBorrowUI ui = this.panels.get((Object)this.state);
        System.out.println("9.1.14.1.	displayAtLoanLimitMessage()");
        ui.displayAtLoanLimitMessage();
    }

    @Override
    public void displayOutstandingFineMessage(float amountOwing) {
        IBorrowUI ui = this.panels.get((Object)this.state);
        
        //System.out.println("9.1.12.1	displayOutstandingFineMessage(amountOwing)");
        ui.displayOutstandingFineMessage(amountOwing);
    }

    @Override
    public void displayOverFineLimitMessage(float amountOwing) {
        IBorrowUI ui = this.panels.get((Object)this.state);
        
        System.out.println("9.1.15.1.	displayOverFineLimitMessage(AmountOwing)");
        ui.displayOverFineLimitMessage(amountOwing);
    }

    @Override
    public void displayExistingLoan(String loanDetails) {
        IBorrowUI ui = this.panels.get((Object)this.state);
        
        System.out.println("9.1.18.1.	displayExistingLoan(loanDetails()");
        ui.displayExistingLoan(loanDetails);
    }

    @Override
    public void displayScannedBookDetails(String bookDetails) {
        IBorrowUI ui = this.panels.get((Object)this.state);
        ui.displayScannedBookDetails(bookDetails);
    }

    @Override
    public void displayPendingLoan(String loanDetails) {
        IBorrowUI ui = this.panels.get((Object)this.state);
        ui.displayPendingLoan(loanDetails);
    }

    @Override
    public void displayConfirmingLoan(String loanDetails) {
        IBorrowUI ui = this.panels.get((Object)this.state);
        ui.displayConfirmingLoan(loanDetails);
    }

    @Override
    public void displayErrorMessage(String errorMesg) {
        IBorrowUI ui = this.panels.get((Object)this.state);
        ui.displayErrorMessage(errorMesg);
    }

    static /* synthetic */ int[] $SWITCH_TABLE$library$interfaces$EBorrowState() {
        int[] arrn;
        int[] arrn2 = $SWITCH_TABLE$library$interfaces$EBorrowState;
        if (arrn2 != null) {
            return arrn2;
        }
        arrn = new int[EBorrowState.values().length];
        try {
            arrn[EBorrowState.BORROWING_RESTRICTED.ordinal()] = 6;
        }
        catch (NoSuchFieldError v1) {}
        try {
            arrn[EBorrowState.CANCELLED.ordinal()] = 7;
        }
        catch (NoSuchFieldError v2) {}
        try {
            arrn[EBorrowState.COMPLETED.ordinal()] = 5;
        }
        catch (NoSuchFieldError v3) {}
        try {
            arrn[EBorrowState.CONFIRMING_LOANS.ordinal()] = 4;
        }
        catch (NoSuchFieldError v4) {}
        try {
            arrn[EBorrowState.CREATED.ordinal()] = 1;
        }
        catch (NoSuchFieldError v5) {}
        try {
            arrn[EBorrowState.INITIALIZED.ordinal()] = 2;
        }
        catch (NoSuchFieldError v6) {}
        try {
            arrn[EBorrowState.SCANNING_BOOKS.ordinal()] = 3;
        }
        catch (NoSuchFieldError v7) {}
        $SWITCH_TABLE$library$interfaces$EBorrowState = arrn;
        return $SWITCH_TABLE$library$interfaces$EBorrowState;
    }
}

// 2.4.	1.1.	displayExistingLoan(loanDetails()