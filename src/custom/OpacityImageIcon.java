package src.custom;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class OpacityImageIcon extends ImageIcon {
    private float opacity;

    public OpacityImageIcon(ImageIcon image, float opacity) {
        super(image.getImage());
        this.opacity = opacity;
    }

    @Override
    public void paintIcon(java.awt.Component c, java.awt.Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        super.paintIcon(c, g2d, x, y);
        g2d.dispose();
    }

    public void setOpacity(float opacity) {
        if (opacity >= 0.0f && opacity <= 1.0f) {
            this.opacity = opacity;
        } else {
            throw new IllegalArgumentException("Opacity must be between 0.0 and 1.0");
        }
    }

    public ImageIcon getDecreasedOpacityImageIcon() {
        BufferedImage bufferedImage = new BufferedImage(getIconWidth(), getIconHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        paintIcon(null, g2d, 0, 0);
        g2d.dispose();

        return new ImageIcon(bufferedImage);
    }
}