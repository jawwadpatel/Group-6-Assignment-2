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
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import library.interfaces.IBorrowUIListener;
import panels.borrow.ABorrowPanel;

public class SwipeCardPanel
extends ABorrowPanel {
    private static final long serialVersionUID = 1;
    private JLabel lblErrMesg;

    public SwipeCardPanel(final IBorrowUIListener listener) {
        this.setLayout(null);
        this.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Borrow Book - Initialized", 4, 2, null, new Color(0, 0, 0)));
        this.setBounds(12, 23, 460, 640);
        JLabel lblSwipeCard = new JLabel("Swipe Card Please");
        lblSwipeCard.setHorizontalAlignment(0);
        lblSwipeCard.setFont(new Font("Tahoma", 0, 42));
        lblSwipeCard.setBounds(12, 181, 436, 78);
        this.add(lblSwipeCard);
        
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener(){
        	
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	System.out.println("10.1.	cancelled");
                listener.cancelled();
            }
        });
        btnCancel.setFont(new Font("Tahoma", 0, 14));
        btnCancel.setBounds(170, 320, 127, 35);
        this.add(btnCancel);
        this.lblErrMesg = new JLabel();
        this.lblErrMesg.setForeground(Color.RED);
        this.lblErrMesg.setFont(new Font("Tahoma", 1, 14));
        this.lblErrMesg.setBounds(12, 592, 434, 29);
        this.add(this.lblErrMesg);
    }

    @Override
    public void displayErrorMessage(String errorMesg) {
        this.lblErrMesg.setText(errorMesg);
    }

}

