package src;

import src.custom.CButton;
import src.custom.CLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements MouseListener, ActionListener {
    private CButton button;

    public static void main(String[] args) {
        new Main().testCButton();
    }

    public void testCButton() {
        JFrame frame = new JFrame("CButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 400);

        JLabel label1 = new JLabel("left");
        label1.setBackground(Color.GREEN);
        label1.setOpaque(true);
        label1.setPreferredSize(new Dimension(40, 40));
        frame.add(label1);

        //Never add the button by your self just pass the container where the button should be added
        button = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\normal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\press.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\hover.png");
        JPanel panelButton = button.getPanelButton();
        frame.add(panelButton);
        button.addMouseListener(this);
        button.addActionListener(this);

        JLabel label2 = new JLabel("left");
        label2.setPreferredSize(new Dimension(40, 40));
        frame.add(label2);

        CLabel label = new CLabel("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\normal.png", false);
        label.setText("Hello");
        label.moveTextOrComponent(80, 0, 10, 30, -1);
        label.customizeText("Ink Free", Font.ITALIC, 30, 55, 45, 100);
        int myIndex = label.addComponentToLabel(new JButton("hello"), 300, 0, 0, 20);
        label.addComponentToLabel(new JLabel("HI Abel"), 0, 0, 0, 20);
        label.moveTextOrComponent(0, 300, 0, 0, 1);

        JButton b1 = new JButton("Hello");
        b1.setPreferredSize(new Dimension(40, 40));
        //label.add(b1);
        frame.add(label);

        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        button.getNormalButton();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        button.getClickedButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.getNormalButton();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.getHoveredButton();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        button.getNormalButton();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed");
    }
}