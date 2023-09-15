package src.custom;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CPanel extends JPanel {
    private final ImageIcon panelBackground;

    public CPanel(String background) {
        this.panelBackground = new ImageIcon(background);
        setPreferredSize(new Dimension(this.panelBackground.getIconWidth(), this.panelBackground.getIconHeight()));
        setOpaque(false);
    }
    public CPanel(ImageIcon image) {
        this.panelBackground = image;
        setPreferredSize(new Dimension(this.panelBackground.getIconWidth(), this.panelBackground.getIconHeight()));
        setOpaque(false);
    }
    public int getPanelWidth() {
        return panelBackground.getIconWidth();
    }
    public int getPanelHeight() {
        return panelBackground.getIconHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (panelBackground != null) {
            Image image = panelBackground.getImage();

            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}