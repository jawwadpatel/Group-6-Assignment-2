/*
 * Decompiled with CFR 0_115.
 */
package panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import library.interfaces.IMainListener;

public class MainPanel
extends JPanel {
    private static final long serialVersionUID = 1;

    public MainPanel(final IMainListener listener) {
        this.setBorder(new TitledBorder(null, "Main Menu", 4, 2, null, null));
        this.setBounds(500, 50, 470, 680);
        this.setLayout(null);
        JLabel lblNewLabel = new JLabel("Backwoods Regional Library");
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("Tahoma", 0, 26));
        lblNewLabel.setBounds(12, 27, 446, 32);
        this.add(lblNewLabel);
        JLabel lblSelfServiceSystem = new JLabel("Self Service System");
        lblSelfServiceSystem.setHorizontalAlignment(0);
        lblSelfServiceSystem.setFont(new Font("Tahoma", 0, 26));
        lblSelfServiceSystem.setBounds(12, 61, 446, 32);
        this.add(lblSelfServiceSystem);
        JButton btnBorrowBooks = new JButton("Borrow Books");
        btnBorrowBooks.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	System.out.println("1.	Click  BorrowButton");
                listener.borrowBooks();
            }
        });
        btnBorrowBooks.setFont(new Font("Tahoma", 0, 14));
        btnBorrowBooks.setBounds(141, 138, 155, 37);
        this.add(btnBorrowBooks);
    }

}

