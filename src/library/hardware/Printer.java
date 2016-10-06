/*
 * Decompiled with CFR 0_115.
 */
package library.hardware;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import library.interfaces.hardware.IPrinter;

public class Printer
extends JFrame
implements IPrinter {
    private static final long serialVersionUID = 1;
    private JTextArea textArea;

    public Printer() {
        this.setBounds(50, 450, 400, 350);
        this.setResizable(false);
        this.setTitle("Printer");
        this.setDefaultCloseOperation(3);
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Printer", 4, 2, null, null));
        panel.setBounds(10, 20, 400, 280);
        this.getContentPane().add(panel);
        panel.setLayout(null);
        this.textArea = new JTextArea();
        this.textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(this.textArea);
        scrollPane.setBounds(10, 20, 375, 280);
        panel.add(scrollPane);
    }

    @Override
    public void print(String printData) {
        this.textArea.setText(printData);
        this.textArea.setCaretPosition(this.textArea.getLineCount());
    }
}

