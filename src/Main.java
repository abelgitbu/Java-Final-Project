package src;

import src.custom.ATextField;
import src.custom.CButton;
import src.custom.CLabel;
import src.custom.CTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements MouseListener, ActionListener {
    private CButton button;
    private DTextField textField;

    public static void main(String[] args) {
        new Main().testCButton();
    }

    public void testCButton() {
        JFrame frame = new JFrame("CButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(430, 420);

        JLabel label1 = new JLabel("left");
        label1.setBackground(Color.GREEN);
        label1.setOpaque(true);
        label1.setPreferredSize(new Dimension(40, 40));
        frame.add(label1);

        //Never add the button by your self just pass the container where the button should be added
        button = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\normal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\press.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\hover.png");
        button.addActionListener(this);
        button.addMouseListener(this);
        JPanel panelButton = button.getPanelButton();
        frame.add(panelButton);

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

        textField = new DTextField("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\normal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\press.png", 30, 17,
                300, 35, "Water Mark");
        textField.moveWaterMarkPosition(0, 2, 0, 0);
        textField.customizeWaterMark("", Font.PLAIN, 30, 129, 83, 154);
        textField.customizeTextField("", Font.PLAIN, 30, 0, 0, 0);
        CButton buttonTextField = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nNormal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\pHover.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nPressH.png");
        buttonTextField.addActionListener(this);
        buttonTextField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JPanel panelTextButt = button.getPanelButton();
        textField.addComponent(panelButton, 10, 10, 40, 40);

        frame.add(textField);
        new Color(129, 83, 154);

        frame.add(new JButton("a;sdlfjjjjjjjjjj"));
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