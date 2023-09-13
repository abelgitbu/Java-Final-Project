package src.custom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Objects;

public class CTextField extends JTextField implements ActionListener, DocumentListener {
    {
        panelTextField = new JPanel();
        toAddComponentForNormalTextField = new ArrayList<>();
        toAddComponentForSelectedTextField = new ArrayList<>();
        emptyNormal = new ArrayList<>();
        emptySelected = new ArrayList<>();
        labelWaterMark = new JLabel();
    }

    private ImageIcon textFieldBackgroundImage;
    private final ImageIcon imageNormalTextField;
    private final ImageIcon imageSelectedTextField;
    private final ImageIcon imageEnteredTextField;
    private final JPanel panelTextField;
    private int currentTextFieldWidth = 0;
    private int currentTextFieldHeight = 0;
    private final ArrayList<JPanel> toAddComponentForNormalTextField;
    private final ArrayList<JPanel> toAddComponentForSelectedTextField;
    private ArrayList<EmptyBorderValues> emptyNormal;
    private ArrayList<EmptyBorderValues> emptySelected;
    private final JLabel labelWaterMark;
    private final String textWaterMark;

    public CTextField(String fileNormalTextField, String fileSelectedTextField, String fileEnteredTextField, String waterMark) {
        this.textWaterMark = waterMark;

        this.imageNormalTextField = new ImageIcon(fileNormalTextField);
        this.imageSelectedTextField = new ImageIcon(fileSelectedTextField);
        this.imageEnteredTextField = new ImageIcon(fileEnteredTextField);
        textFieldBackgroundImage = this.imageNormalTextField;

        setBackground(Color.GREEN);

        setWaterMark(waterMark);

        int width = bigWidth();
        int height = bigHeight();
        panelTextField.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelTextField.setPreferredSize(new Dimension(width, height));

        setPreferredSize(new Dimension(this.imageNormalTextField.getIconWidth(),
                this.imageNormalTextField.getIconHeight()));
        setOpaque(false);
        setLayout(null);
        setEnabled(true);
        setEditable(true);
        setBorder(null);

        addActionListener(this);
        //addFocusListener(this);
        getDocument().addDocumentListener(this);

        panelTextField.setOpaque(false);
        panelTextField.add(this);
    }

    public void setWaterMark(String waterMark) {
        labelWaterMark.setText(waterMark);
        labelWaterMark.setBounds(0, 0, imageNormalTextField.getIconWidth(), imageNormalTextField.getIconHeight());
        labelWaterMark.setOpaque(false);

        add(labelWaterMark);
    }

    public int bigHeight() {
        if(imageNormalTextField.getIconHeight() > imageSelectedTextField.getIconHeight() && imageNormalTextField.getIconHeight() >
                imageEnteredTextField.getIconHeight()) {
            return imageNormalTextField.getIconHeight();
        }
        else if(imageSelectedTextField.getIconHeight() > imageNormalTextField.getIconHeight() && imageSelectedTextField.getIconHeight() >
                imageEnteredTextField.getIconHeight()) {
            return imageSelectedTextField.getIconHeight();
        }
        else if(imageEnteredTextField.getIconHeight() > imageNormalTextField.getIconHeight() && imageEnteredTextField.getIconHeight() >
                imageSelectedTextField.getIconHeight()) {
            return imageEnteredTextField.getIconHeight();
        }
        else {
            return imageNormalTextField.getIconHeight();
        }
    }
    public int bigWidth() {
        if(imageNormalTextField.getIconWidth() > imageSelectedTextField.getIconWidth() && imageNormalTextField.getIconWidth() >
                imageEnteredTextField.getIconWidth()) {
            return imageNormalTextField.getIconWidth();
        }
        else if(imageSelectedTextField.getIconWidth() > imageNormalTextField.getIconWidth() && imageSelectedTextField.getIconWidth() >
                imageEnteredTextField.getIconWidth()) {
            return imageSelectedTextField.getIconWidth();
        }
        else if(imageEnteredTextField.getIconWidth() > imageNormalTextField.getIconWidth() && imageEnteredTextField.getIconWidth() >
                imageSelectedTextField.getIconWidth()) {
            return imageEnteredTextField.getIconWidth();
        }
        else {
            return imageNormalTextField.getIconWidth();
        }
    }
    public void textFieldSize() {
        currentTextFieldWidth = textFieldBackgroundImage.getIconWidth();
        currentTextFieldHeight = textFieldBackgroundImage.getIconHeight();
    }

    public void getNormalTextField() {
        this.textFieldBackgroundImage = imageNormalTextField;

        setVisible(false);
        setOpaque(true);
        panelTextField.remove(this);
        setPreferredSize(new Dimension(this.imageNormalTextField.getIconWidth(),
                this.imageNormalTextField.getIconHeight()));
        panelTextField.add(this);
        setVisible(true);
    }
    public void getSelectedTextField() {
        this.textFieldBackgroundImage = imageSelectedTextField;

        setVisible(false);
        panelTextField.remove(this);
        setPreferredSize(new Dimension(this.imageSelectedTextField.getIconWidth(),
                this.imageSelectedTextField.getIconHeight()));
        panelTextField.add(this);
        setVisible(true);
    }
    public void getEnteredTextField() {
        this.textFieldBackgroundImage = imageEnteredTextField;

        setVisible(false);
        panelTextField.remove(this);
        setPreferredSize(new Dimension(this.imageEnteredTextField.getIconWidth(),
                this.imageEnteredTextField.getIconHeight()));
        panelTextField.add(this);
        setVisible(true);
    }

    public void customizeText(String style, int intensity, int size, int r, int g, int b) {
        switch (intensity) {
            case 1:
                setFont(new Font(style, Font.BOLD, size));
                break;
            case 2:
                setFont(new Font(style, Font.ITALIC, size));
                break;
            case 0:
            default:
                setFont(new Font(style, Font.PLAIN, size));
                break;
        }
        setForeground(new Color(r, g, b));
    }

    public void addComponentWhenTextFieldSelected(Component component, int moveToRight, int moveToLeft, int moveToTop, int moveToBottom) {
        JPanel panel = new JPanel();
        panel.add(component);
        panel.setOpaque(false);
        toAddComponentForSelectedTextField.add(panel);

        CTextField.EmptyBorderValues values = this.new EmptyBorderValues(moveToRight, moveToLeft, moveToTop, moveToBottom);
        emptySelected.add(values);

//        addFocusListener(this);
    }
    public void addComponentWhenTextFieldNormal(Component component, int moveToRight, int moveToLeft, int moveToTop, int moveToBottom) {
        JPanel panel = new JPanel();
        panel.add(component);
        panel.setOpaque(false);
        toAddComponentForNormalTextField.add(panel);

        CTextField.EmptyBorderValues values = this.new EmptyBorderValues(moveToRight, moveToLeft, moveToTop, moveToBottom);
        emptyNormal.add(values);

//        addFocusListener(this);
    }

    public JPanel getPanelTextField() {
        return this.panelTextField;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (textFieldBackgroundImage != null) {
            Image image = textFieldBackgroundImage.getImage();

            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

/*    @Override
    public void focusGained(FocusEvent e) {
        for(int i = 0; i < toAddComponentForSelectedTextField.size(); i++) {
            toAddComponentForSelectedTextField.get(i).setBounds(0, 0, imageSelectedTextField.getIconWidth(), imageSelectedTextField.getIconHeight());
            toAddComponentForSelectedTextField.get(i).setBorder(new EmptyBorder(emptySelected.get(i).getMoveToBottom(), emptySelected.get(i).getMoveToRight(),
                    emptySelected.get(i).getMoveToTop(), emptySelected.get(i).getMoveToLeft()));
            add(toAddComponentForSelectedTextField.get(i));
        }

        getSelectedTextField();
    }
    @Override
    public void focusLost(FocusEvent e) {
        for(int i = 0; i < toAddComponentForNormalTextField.size(); i++) {
            toAddComponentForNormalTextField.get(i).setBounds(0, 0, imageNormalTextField.getIconWidth(), imageNormalTextField.getIconHeight());
            toAddComponentForNormalTextField.get(i).setBorder(new EmptyBorder(emptyNormal.get(i).getMoveToBottom(), emptyNormal.get(i).getMoveToRight(),
                    emptyNormal.get(i).getMoveToTop(), emptyNormal.get(i).getMoveToLeft()));
            add(toAddComponentForNormalTextField.get(i));
        }

        getNormalTextField();
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        getEnteredTextField();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if(Objects.equals("", getText())) {
            labelWaterMark.setText(textWaterMark);
        }
        else {
            labelWaterMark.setText("");
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(Objects.equals("", getText())) {
            labelWaterMark.setText(textWaterMark);
        }
        else {
            labelWaterMark.setText("");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if(Objects.equals("", getText())) {
            labelWaterMark.setText(textWaterMark);
        }
        else {
            labelWaterMark.setText("");
        }
    }

    class EmptyBorderValues {
        public int moveToRight;
        public int moveToLeft;
        public int moveToTop;
        public int moveToBottom;

        public EmptyBorderValues(int moveToRight, int moveToLeft, int moveToTop, int moveToBottom) {
            this.moveToBottom = moveToBottom;
            this.moveToTop = moveToTop;
            this.moveToRight = moveToRight;
            this.moveToLeft = moveToLeft;
        }

        public int getMoveToRight() {
            return moveToRight;
        }
        public int getMoveToLeft() {
            return moveToLeft;
        }
        public int getMoveToTop() {
            return moveToTop;
        }
        public int getMoveToBottom() {
            return moveToBottom;
        }
    }
}
