/*
 * Decompiled with CFR 0_115.
 */
package library.hardware;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import library.interfaces.hardware.IDisplay;

public class Display
extends JFrame
implements IDisplay {
    private static final long serialVersionUID = 1;
    private JPanel current;

    public Display() {
        this.setTitle("Display");
        this.setBounds(500, 50, 470, 680);
        this.setDefaultCloseOperation(3);
        this.getContentPane().setLayout(new CardLayout(0, 0));
    }

    @Override
    public JPanel getDisplay() {
        return this.current;
    }

    @Override
    public void setDisplay(JPanel panel, String id) {
        this.getContentPane().add((Component)panel, id);
        CardLayout cardLayout = (CardLayout)this.getContentPane().getLayout();
        cardLayout.show(this.getContentPane(), id);
        if (this.current != null) {
            //System.out.println("Display.setDisplay: removing current");
            cardLayout.removeLayoutComponent(this.current);
        }
        this.current = panel;
    }
}


