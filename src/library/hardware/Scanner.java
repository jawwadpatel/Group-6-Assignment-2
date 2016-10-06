/*
 * Decompiled with CFR 0_115.
 */
package library.hardware;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import library.interfaces.hardware.IScanner;
import library.interfaces.hardware.IScannerListener;

public class Scanner
extends JFrame
implements IScanner {
    private static final long serialVersionUID = 1;
    private JTextField textField;
    private JButton btnScan;
    private IScannerListener listener;

    public Scanner() {
        this.setTitle("Scanner");
        this.setBounds(50, 250, 400, 200);
        this.setDefaultCloseOperation(3);
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Scanner", 4, 2, null, null));
        panel.setBounds(10, 10, 400, 200);
        this.getContentPane().add(panel);
        panel.setLayout(null);
        final JLabel lblErrorMesg = new JLabel("");
        lblErrorMesg.setForeground(Color.RED);
        lblErrorMesg.setBounds(12, 21, 358, 16);
        panel.add(lblErrorMesg);
        JLabel lblNewLabel = new JLabel("Enter Book Barcode: ");
        lblNewLabel.setFont(new Font("Tahoma", 0, 14));
        lblNewLabel.setBounds(30, 50, 150, 25);
        panel.add(lblNewLabel);
        this.textField = new JTextField();
        this.textField.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent arg0) {
                lblErrorMesg.setText("");
            }
        });
        this.textField.setBounds(190, 50, 150, 25);
        panel.add(this.textField);
        this.textField.setColumns(10);
        this.textField.setEditable(false);
        this.btnScan = new JButton("Scan Book Barcode");
        this.btnScan.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	System.out.println("10. scan book");
                if (Scanner.this.listener == null) {
                    throw new RuntimeException("Scanner: listener is null");
                }
                String text = Scanner.this.textField.getText();
                            
                
                try {
                    int barcode = new Integer(text);
                    if (barcode <= 0) {
                        throw new NumberFormatException();
                    }
                    
                    // HERE
                    System.out.println("10.1. bookScanned(barcode)");
                    Scanner.this.listener.bookScanned(barcode);
                }
                catch (NumberFormatException e) {
                    lblErrorMesg.setText("Book barcode must be a positive intger");
                }
                Scanner.this.textField.setText("");
            }
        });
        this.btnScan.setFont(new Font("Tahoma", 0, 14));
        this.btnScan.setBounds(85, 88, 215, 39);

        panel.add(this.btnScan);
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.btnScan.setEnabled(enabled);
        this.textField.setEditable(enabled);
    }

    @Override
    public void addListener(IScannerListener listener) {
        this.listener = listener;
    }

}

