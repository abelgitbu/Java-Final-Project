package src;

import src.custom.*;
import src.custom.customTextField.CTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JFrame frame = new JFrame("Test Custom Component");
    private CPanel cpanel = new CPanel("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\background.png");

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
        ImageIcon nonTransImage1 = new ImageIcon("C:\\Users\\user\\Desktop\\labelImage.png");
        OpacityImageIcon opacityImageIcon1 = new OpacityImageIcon(nonTransImage1, 0.8f);
        ImageIcon selectImage = opacityImageIcon1.getDecreasedOpacityImageIcon();

        ImageIcon nonTransImage2 = new ImageIcon("C:\\Users\\user\\Desktop\\labelImage.png");
        OpacityImageIcon opacityImageIcon2 = new OpacityImageIcon(nonTransImage2, 0.8f);
        ImageIcon deselectImage = opacityImageIcon2.getDecreasedOpacityImageIcon();

        CTextField cTextField = new CTextField(nonTransImage1, selectImage, 5, 40, 200, 100, "Water Mark");
        cTextField.customizeWaterMark("Monotype Corsiva", Font.BOLD, 35, 55, 100, 23);
        cTextField.moveWaterMarkPosition(10, 0, 0, 0);
        cTextField.customizeTextField("Monotype Corsiva", Font.BOLD, 35, 100, 100, 100);

        CButton cButton = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nNormal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\pHover.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nPressH.png");
        JPanel addThisButton = cButton.getPanelButton();
        cTextField.addComponent(addThisButton, 180, 70, 100, 50);
        cTextField.getTextField().setText("");

        frame.add(cTextField);
    }
    public void testCComboList() {
        cpanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));

        ImageIcon nonTransImage = new ImageIcon("C:\\Users\\user\\Desktop\\labelImage.png");
        OpacityImageIcon opacityImageIcon = new OpacityImageIcon(nonTransImage, 0.4f);
        ImageIcon labelImage = opacityImageIcon.getDecreasedOpacityImageIcon();

        CLabel cLab = new CLabel(labelImage, true);
        cLab.customizeText("Monotype Corsiva", Font.BOLD, 35, 55, 100, 23);
        cLab.moveTextOrComponent(10, 0, 0, 20, -1);

        CButton cButton = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nNormal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\pHover.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\nPressH.png");
        JPanel addThisButton = cButton.getPanelButton();
        int addButtonIndex = cLab.addComponentToLabel(addThisButton, 0, 100, 0, 60);
        cLab.moveTextOrComponent(250, 0, 0, 65, addButtonIndex);
        cLab.setText("Select Your Home");

        frame.setVisible(true);
        //1. frame must be visible before the CComboList constructor call
        //2. the component where the CComboList object added must be added after
        // the CComboList constructor call.
        CComboList combo = new CComboList(frame, cLab, cButton, "C:\\Users\\user\\Desktop\\labelImage.png");
        cpanel.add(cLab);
        combo.opacityValue(1f);

        CButton[] cButtons = new CButton[20];
        for(int i = 0; i < 20; i++) {
            cButtons[i] = new CButton("C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\normal.png");
        }
        JPanel[] panelButton = new JPanel[20];
        for(int i = 0; i < 20; i++) {
            panelButton[i] = new JPanel();
            panelButton[i] = cButtons[i].getPanelButton();
        }
        combo.addCompToList(panelButton[0], 20, 4, 10, 4);
        for(int i = 1; i < 20; i++) {
            combo.addCompToList(panelButton[i], 10, 4, 10, 4);
        }

        JButton b = new JButton();
        b.setPreferredSize(new Dimension(0, 0));

        combo.customizeScrollBar(new Color(34, 34, 34), new Color(100, 4, 45), b, 15, 20, true);
    }
}