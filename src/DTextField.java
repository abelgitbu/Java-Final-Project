package src;

import src.custom.DeselectPanel;
import src.custom.SelectPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Objects;

public class DTextField extends JPanel implements FocusListener, DocumentListener {
    {
         textField = new JTextField();
         panelDeselectImage = new JPanel();
         panelSelectImage = new JPanel();
         waterMarkLabel = new JLabel();
    }

    private final ImageIcon selectImage;
    private final ImageIcon deselectImage;
    private final JPanel panelSelectImage;
    private final JPanel panelDeselectImage;
    private final SelectPanel selectPanel;
    private final  DeselectPanel deselectPanel;
    int panelWidth = 0;
    int panelHeight = 0;
    private final JTextField textField;
    private final String waterMarkString;
    private final JLabel waterMarkLabel;


    public DTextField(String deselectFile, String selectFile, int x, int y, int textFieldWidth, int textFieldHeight, String waterMarkString) {
        this.waterMarkString = waterMarkString;
        waterMarkLabel.setText(this.waterMarkString);

        textField.add(waterMarkLabel);

        selectImage = new ImageIcon(selectFile);
        deselectImage = new ImageIcon(deselectFile);

        panelWidth = selectImage.getIconWidth();
        panelHeight = selectImage.getIconHeight();

        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setLayout(null);
        setOpaque(false);
        setVisible(true);
        setBorder(null);

        add(textField);

        selectPanel = new SelectPanel(selectImage, panelWidth, panelHeight);
        selectPanel.setOpaque(false);
        deselectPanel = new DeselectPanel(deselectImage, panelWidth, panelHeight);
        deselectPanel.setOpaque(false);
        add(selectPanel);
        add(deselectPanel);

        textField.setBounds(x, y, textFieldWidth, textFieldHeight);
        textField.setOpaque(false);
        textField.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setWaterMark(this.waterMarkString);

        textField.addFocusListener(this);
        textField.getDocument().addDocumentListener(this);
        textField.setBorder(null);
    }

    public void setWaterMark(String waterMark) {
        waterMarkLabel.setText("" + waterMark);
        waterMarkLabel.setPreferredSize(new Dimension(textField.getWidth(), textField.getHeight()));
        waterMarkLabel.setOpaque(false);
        waterMarkLabel.setBorder(null);

        textField.add(waterMarkLabel);
    }
    public void customizeWaterMark(String style, int intensity, int size, int r, int g, int b) {
        switch (intensity) {
            case 1:
                waterMarkLabel.setFont(new Font(style, Font.BOLD, size));
                break;
            case 2:
                waterMarkLabel.setFont(new Font(style, Font.ITALIC, size));
                break;
            case 0:
            default:
                waterMarkLabel.setFont(new Font(style, Font.PLAIN, size));
                break;
        }
        waterMarkLabel.setForeground(new Color(r, g, b));
    }
    public void moveWaterMarkPosition(int moveToRight, int moveToLeft, int moveToTop, int moveToBottom) {
        EmptyBorder e = new EmptyBorder(moveToBottom, moveToRight, moveToTop, moveToLeft);
        textField.setBorder(e);
    }
    public void customizeTextField(String style, int intensity, int size, int r, int g, int b) {
        switch (intensity) {
            case 1:
                textField.setFont(new Font(style, Font.BOLD, size));
                break;
            case 2:
                textField.setFont(new Font(style, Font.ITALIC, size));
                break;
            case 0:
            default:
                textField.setFont(new Font(style, Font.PLAIN, size));
                break;
        }
        textField.setForeground(new Color(r, g, b));
    }
    public void addComponent(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height);
        add(component);
    }
    public JTextField getTextField() {
        return textField;
    }
    @Override
    public void focusGained(FocusEvent e) {
        deselectPanel.setVisible(false);
        selectPanel.setVisible(true);
    }
    @Override
    public void focusLost(FocusEvent e) {
        selectPanel.setVisible(false);
        deselectPanel.setVisible(true);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if(Objects.equals("", textField.getText())) {
            waterMarkLabel.setText("" + waterMarkString);
        }
        else {
            waterMarkLabel.setText("");
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(Objects.equals("", textField.getText())) {
            waterMarkLabel.setText("" + waterMarkString);
        }
        else {
            waterMarkLabel.setText("");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if(Objects.equals("", textField.getText())) {
            waterMarkLabel.setText("" + waterMarkString);
        }
        else {
            waterMarkLabel.setText("");
        }
    }
}