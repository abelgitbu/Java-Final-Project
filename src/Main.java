package src;

import src.custom.CButton;
import src.custom.CComboList;
import src.custom.CLabel;
import src.custom.CPanel;
import src.custom.customTextField.CTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {

    public static void main(String[] args) {
        new Main().testCustomComponent();
    }

    public void testCustomComponent() {
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
        CButton button = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\normal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\press.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\hover.png");
        button.addActionListener(this);
//        button.addMouseListener(this);
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

        CTextField textField = new CTextField("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\normal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\press.png", 30, 17,
                300, 35, "Water Mark");
        textField.moveWaterMarkPosition(0, 2, 0, 0);
        textField.customizeWaterMark("", Font.PLAIN, 30, 129, 83, 154);
        textField.customizeTextField("", Font.PLAIN, 30, 0, 0, 0);
        CButton buttonTextField = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nNormal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\pHover.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nPressH.png");
        buttonTextField.addActionListener(this);
        JPanel panelTextButt = buttonTextField.getPanelButton();
        textField.addComponent(panelTextButt, 340, 10, 40, 40);

        frame.add(textField);

        JLabel labelWindow = new JLabel("ComboBox");
        labelWindow.setOpaque(true);
        labelWindow.setPreferredSize(new Dimension(100, 33));
        frame.add(labelWindow);

        JButton buttonWindow = new JButton("combo");
        buttonWindow.setPreferredSize(new Dimension(60, 40));
        frame.add(buttonWindow);

        frame.setVisible(true);
        //frame must be visible and all components in the CComboList constructor must be added before creating an object of CComboList
        CComboList comboBox = new CComboList(frame, labelWindow, buttonWindow, "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\background.png");
        JButton buttonScrollBar = new JButton();
        buttonScrollBar.setPreferredSize(new Dimension(0, 0));

        comboBox.customizeScrollBar(new Color(34, 34, 34), new Color(100, 4, 45), buttonScrollBar, 15, 20, false);

        JButton[] bu = new JButton[20];

        for(int i = 0; i < 20; i++) {
            bu[i] = new JButton("hello");
        }

        comboBox.addCompToList(bu[0], 20, 10, 10, 10);
        for(int i = 1; i < 20; i++) {
            comboBox.addCompToList(bu[i], 7, 10, 7, 10);
        }

        CPanel panelC = new CPanel("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\background.png",
                200, 100, BorderFactory.createLineBorder(Color.PINK, 1));
        frame.add(panelC);

        frame.add(new JButton("a;sdlfjjjjjjjjjj"));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed");
    }
}