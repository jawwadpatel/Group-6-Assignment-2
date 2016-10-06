/*
 * Decompiled with CFR 0_115.
 */
package panels.borrow;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import library.interfaces.IBorrowUIListener;
import panels.borrow.ABorrowPanel;

public class ConfirmLoanPanel
extends ABorrowPanel {
    private static final long serialVersionUID = 1;
    private JTextArea loanListTA;

    public ConfirmLoanPanel(final IBorrowUIListener listener) {
        this.setLayout(null);
        this.setBorder(new TitledBorder(null, "Confirm Loans", 4, 2, null, null));
        this.setBounds(12, 23, 460, 640);
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Current Loan List", 4, 2, null, null));
        panel.setBounds(12, 24, 415, 496);
        this.add(panel);
        panel.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 20, 395, 463);
        panel.add(scrollPane);
        this.loanListTA = new JTextArea();
        this.loanListTA.setEditable(false);
        scrollPane.setViewportView(this.loanListTA);
        JButton btnReject = new JButton("Reject");
        btnReject.setFont(new Font("Tahoma", 0, 14));
        btnReject.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                listener.loansRejected();
                
            }
        });
        btnReject.setBounds(173, 533, 115, 35);
        this.add(btnReject);
        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setFont(new Font("Tahoma", 0, 14));
        btnConfirm.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("12. click confirmed.");
                listener.loansConfirmed();
                
            }
        });
        btnConfirm.setBounds(30, 533, 115, 35);
        this.add(btnConfirm);
        JButton button = new JButton("Cancel");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                listener.cancelled();
            }
        });
        button.setFont(new Font("Tahoma", 0, 14));
        button.setBounds(312, 533, 115, 35);
        this.add(button);
    }

    @Override
    public void displayConfirmingLoan(String loanDetails) {
        this.loanListTA.setText(loanDetails);
        this.loanListTA.setCaretPosition(0);
    }

}

