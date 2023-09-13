package src.custom;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Objects;

public class ATextField extends JTextField implements DocumentListener, FocusListener {
    {
        textFieldPanel = new JPanel();
        leftImageFocusLost = new ArrayList<>();
        rightImageFocusLost = new ArrayList<>();
        waterMarkLabel = new JLabel();
    }

    private final JPanel textFieldPanel;
    private final ImageIcon normalImage;
    private final ImageIcon selectImage;
    private ImageIcon backgroundImage;
    private Component[] compLeft;
    private Component[] compRight;
    private final ArrayList<ImageIconCompIndex> leftImageFocusLost;
    private final ArrayList<ImageIconCompIndex> rightImageFocusLost;
    private final String waterMarkString;
    private final JLabel waterMarkLabel;

    public ATextField(Component[] compLeft, Component[] compRight, String fileNormalTextField, String fileSelectedTextField, Border border, String waterMark) {
        textFieldPanel.setLayout(null);

        normalImage = new ImageIcon(fileNormalTextField);
        selectImage = new ImageIcon(fileSelectedTextField);
        backgroundImage = normalImage;

        this.waterMarkString = waterMark;
        setWaterMark(this.waterMarkString);

        setBorder(border);
        setOpaque(false);
        setLayout(null);

        textFieldPanel.setPreferredSize(new Dimension(normalImage.getIconWidth(), normalImage.getIconHeight()));

        this.compRight = compRight;
        this.compLeft = compLeft;
    }
    public ATextField(String fileNormalTextField, String fileSelectedTextField, Border border, String waterMark) {
        textFieldPanel.setLayout(null);

        normalImage = new ImageIcon(fileNormalTextField);
        selectImage = new ImageIcon(fileSelectedTextField);
        backgroundImage = normalImage;

        this.waterMarkString = waterMark;
        setWaterMark(this.waterMarkString);

        setBorder(border);
        setOpaque(false);
        setLayout(null);
        setText("Hello");
        textFieldPanel.setOpaque(true);

        textFieldPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
    }

    public void setLocationTextFieldToPanel(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        textFieldPanel.add(this);
    }

    public void setWaterMark(String waterMark) {
        waterMarkLabel.setText(waterMark);
        waterMarkLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        waterMarkLabel.setOpaque(false);

        add(waterMarkLabel);
    }

    public JPanel getPanelTextField() {
        return this.textFieldPanel;
    }

    public void leftCompLocation(int compIndex, int x, int y, int width, int height) {
        compLeft[compIndex].setBounds(x, y, width, height);
        add(compLeft[compIndex]);
    }
    public void rightCompLocation(int compIndex, int x, int y, int width, int height) {
        compRight[compIndex].setBounds(x, y, width, height);
        add(compRight[compIndex]);
    }
    public void leftCompImageWhenTextFieldFocusLost(int index, String focusLostImage) {
        ImageIcon imageLostFocus = new ImageIcon(focusLostImage);

        ATextField.ImageIconCompIndex imageIndex = this.new ImageIconCompIndex(index, imageLostFocus);
        this.leftImageFocusLost.add(imageIndex);

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }
            @Override
            public void focusLost(FocusEvent e) {
                int ind = 0;
                for(int i = 0; i < leftImageFocusLost.size(); i++) {
                    if(leftImageFocusLost.get(i).getCompIndex() == index) {
                        ind = i;
                        break;
                    }
                }
                new FocusLostImage(compLeft[index], leftImageFocusLost.get(ind).getImageIcon());
            }
        });
    }
    public void rightCompImageWhenTextFieldFocusLost(int index, String focusLostImage) {
        ImageIcon imageLostFocus = new ImageIcon(focusLostImage);

        ATextField.ImageIconCompIndex imageIndex = this.new ImageIconCompIndex(index, imageLostFocus);
        this.rightImageFocusLost.add(imageIndex);

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }
            @Override
            public void focusLost(FocusEvent e) {
                int ind = 0;
                for(int i = 0; i < rightImageFocusLost.size(); i++) {
                    if(rightImageFocusLost.get(i).getCompIndex() == index) {
                        ind = i;
                        break;
                    }
                }
                new FocusLostImage(compRight[index], rightImageFocusLost.get(ind).getImageIcon());
            }
        });
    }

    public void getFocusGainedImage() {
        this.backgroundImage = selectImage;
    }
    public void getFocusLostImage() {
        this.backgroundImage = normalImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            Image image = backgroundImage.getImage();

            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if(Objects.equals("", getText())) {
            waterMarkLabel.setText(waterMarkString);
        }
        else {
            waterMarkLabel.setText("");
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if(Objects.equals("", getText())) {
            waterMarkLabel.setText(waterMarkString);
        }
        else {
            waterMarkLabel.setText("");
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if(Objects.equals("", getText())) {
            waterMarkLabel.setText(waterMarkString);
        }
        else {
            waterMarkLabel.setText("");
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        getFocusGainedImage();
    }

    @Override
    public void focusLost(FocusEvent e) {
        getFocusLostImage();
    }

    class FocusLostImage extends JButton {
        private Component component;
        private ImageIcon imageComponent;

        public FocusLostImage (Component component, ImageIcon imageComponent) {
            this.component = component;
            this.imageComponent = imageComponent;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (imageComponent != null) {
                Image image = imageComponent.getImage();

                g.drawImage(image, 0, 0, component.getWidth(), component.getHeight(), component);
            }
        }
    }

    class ImageIconCompIndex {
        int compIndex;
        ImageIcon imageFocusLost;

        public ImageIconCompIndex(int compIndex, ImageIcon imageFocusLost) {
            this.compIndex = compIndex;
            this.imageFocusLost = imageFocusLost;
        }

        public ImageIcon getImageIcon() {
            return imageFocusLost;
        }
        public int getCompIndex() {
            return compIndex;
        }
    }
}