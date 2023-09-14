package src;

import src.custom.CButton;
import src.custom.CLabel;
import src.custom.CPanel;
import src.custom.OpacityImageIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame = new JFrame("Test Custom Component");

    public static void main(String[] args) {
        new Main().testCustomComponent();
    }

    public void testCustomComponent() {
        frame.setSize(700, 700);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        testCPanel();
        testCButton();
        testCLabel();
        testCTextField();
        testCComboList();

        frame.setVisible(true);
    }

    public void testCPanel() {
        CPanel cpanel = new CPanel("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\background.png",
                500, 500);
        frame.add(cpanel);
    }
    public void testCButton() {
        CButton cButton = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nNormal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\pHover.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nPressH.png");
        JPanel addThisButton = cButton.getPanelButton();
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hello world");
            }
        });
        frame.add(addThisButton);
    }
    public void testCLabel() {
        ImageIcon nonTransImage = new ImageIcon("C:\\Users\\user\\Desktop\\labelImage.png");
        OpacityImageIcon opacityImageIcon = new OpacityImageIcon(nonTransImage, 0.8f);
        ImageIcon labelImage = opacityImageIcon.getDecreasedOpacityImageIcon();

        CLabel cLab = new CLabel(labelImage, true);
        cLab.customizeText("Monotype Corsiva", Font.BOLD, 35, 55, 100, 23);
        cLab.moveTextOrComponent(10, 0, 0, 20, -1);

        CButton cButton = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nNormal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\pHover.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nPressH.png");
        JPanel addThisButton = cButton.getPanelButton();
        int addButtonIndex = cLab.addComponentToLabel(addThisButton, 0, 100, 0, 60);
        cLab.moveTextOrComponent(0, 100, 0, 60, addButtonIndex);
        cLab.setText("Hello");

        frame.add(cLab);
    }
    public void testCTextField() {

    }
    public void testCComboList() {

    }
}
