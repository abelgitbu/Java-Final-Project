package src.custom;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CPanel extends JPanel {
    private final ImageIcon panelBackground;

    public CPanel(String background, int width, int height, Border border) {
        this.panelBackground = new ImageIcon(background);
        setBorder(border);
        setPreferredSize(new Dimension(width, height));
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
