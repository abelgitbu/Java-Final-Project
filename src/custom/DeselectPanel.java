package src.custom;

import javax.swing.*;
import java.awt.*;

public class DeselectPanel extends JPanel {
    private final ImageIcon deSelectImage;

    public DeselectPanel(ImageIcon selectImage, int panelWidth, int panelHeight) {
        this.deSelectImage = selectImage;

        setBounds(0, 0, panelWidth, panelHeight);
        setBorder(null);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (deSelectImage != null) {
            Image imageDeSelect = deSelectImage.getImage();

            g.drawImage(imageDeSelect, 0, 0, deSelectImage.getIconWidth(), deSelectImage.getIconHeight(), this);
        }
    }
}