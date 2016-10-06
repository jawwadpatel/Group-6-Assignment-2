/*
 * Decompiled with CFR 0_115.
 */
package panels.borrow;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import panels.borrow.ABorrowPanel;

public class CancelledPanel
extends ABorrowPanel {
    private static final long serialVersionUID = 1;

    public CancelledPanel() {
        this.setLayout(null);
        this.setBorder(new TitledBorder(null, "Cancelled", 4, 2, null, null));
        this.setBounds(12, 23, 460, 640);
        JLabel lblCancelled = new JLabel("Cancelled");
        lblCancelled.setHorizontalAlignment(0);
        lblCancelled.setFont(new Font("Tahoma", 0, 42));
        lblCancelled.setBounds(12, 187, 436, 78);
        this.add(lblCancelled);
    }
}

