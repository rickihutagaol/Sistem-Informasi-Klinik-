/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author abednego(11315020)
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InternalFrameDemo1 extends JPanel {

    JDesktopPane desktop;
    JButton button;

    public InternalFrameDemo1() {
        desktop = new JDesktopPane();
        button = new JButton("Get Next Frame");

        setLayout(new BorderLayout());
        add(desktop, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (desktop.getAllFrames().length == 0) {
                    desktop.add(new MyInternalFrame());

                } else {
                    desktop.remove(0);
                    desktop.add(new MyInternalFrame());
                    revalidate();
                    repaint();
                }
            }
        });
    }

    public static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new InternalFrameDemo1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}