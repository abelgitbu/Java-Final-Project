package src.custom.customTextField;

import javax.swing.*;
import java.awt.*;

public class SelectPanel extends JPanel {
    private final ImageIcon selectImage;

    public SelectPanel(ImageIcon selectImage, int panelWidth, int panelHeight) {
        this.selectImage = selectImage;

        setBounds(0, 0, panelWidth, panelHeight);
        setBorder(null);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (selectImage != null) {
            Image imageSelect = selectImage.getImage();

            g.drawImage(imageSelect, 0, 0, selectImage.getIconWidth(), selectImage.getIconHeight(), this);
        }
    }
}