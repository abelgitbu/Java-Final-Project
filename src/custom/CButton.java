package custom;

import javax.swing.*;
import java.awt.*;

public class CButton extends JButton {
    {
        panelButton = new JPanel();
    }

    private ImageIcon buttonBackgroundImage;
    private final ImageIcon imageNormalButton;
    private final ImageIcon imageHoveredButton;
    private final ImageIcon imageClickedButton;
    private final JPanel panelButton;

    public CButton(String fileNormalButton) {
        this.imageNormalButton = new ImageIcon(fileNormalButton);
        this.imageHoveredButton = new ImageIcon(fileNormalButton);
        this.imageClickedButton = new ImageIcon(fileNormalButton);
        buttonBackgroundImage = this.imageNormalButton;

        panelButton.setLayout(new BorderLayout());
        panelButton.setPreferredSize(new Dimension(imageNormalButton.getIconWidth(), imageNormalButton.getIconHeight()));

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        panelButton.setOpaque(false);
        panelButton.add(this);
    }
    public CButton(Container container, GridBagConstraints con, String fileNormalButton) {
        this(fileNormalButton);
        container.add(panelButton, con);
    }
    public CButton(String fileNormalButton, String fileHoveredButton, String fileClickedButton) {
        this.imageNormalButton = new ImageIcon(fileNormalButton);
        this.imageHoveredButton = new ImageIcon(fileHoveredButton);
        this.imageClickedButton = new ImageIcon(fileClickedButton);
        buttonBackgroundImage = this.imageNormalButton;

        int width = bigWidth();
        int height = bigHeight();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelButton.setPreferredSize(new Dimension(width, height));

        setPreferredSize(new Dimension(this.imageNormalButton.getIconWidth(),
                this.imageNormalButton.getIconHeight()));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);

        panelButton.setOpaque(false);
        panelButton.add(this);
    }
    public CButton(Container container, GridBagConstraints con, String fileNormalButton, String fileHoveredButton, String fileClickedButton) {
        this(fileNormalButton, fileHoveredButton, fileClickedButton);
        container.add(panelButton, con);
    }

    public int bigHeight() {
        if(imageNormalButton.getIconHeight() > imageHoveredButton.getIconHeight() && imageNormalButton.getIconHeight() >
                imageClickedButton.getIconHeight()) {
            return imageNormalButton.getIconHeight();
        }
        else if(imageHoveredButton.getIconHeight() > imageNormalButton.getIconHeight() && imageHoveredButton.getIconHeight() >
                imageClickedButton.getIconHeight()) {
            return imageHoveredButton.getIconHeight();
        }
        else if(imageClickedButton.getIconHeight() > imageNormalButton.getIconHeight() && imageClickedButton.getIconHeight() >
                imageHoveredButton.getIconHeight()) {
            return imageClickedButton.getIconHeight();
        }
        else {
            return imageNormalButton.getIconHeight();
        }
    }
    public int bigWidth() {
        if(imageNormalButton.getIconWidth() > imageHoveredButton.getIconWidth() && imageNormalButton.getIconWidth() >
                imageClickedButton.getIconWidth()) {
            return imageNormalButton.getIconWidth();
        }
        else if(imageHoveredButton.getIconWidth() > imageNormalButton.getIconWidth() && imageHoveredButton.getIconWidth() >
                imageClickedButton.getIconWidth()) {
            return imageHoveredButton.getIconWidth();
        }
        else if(imageClickedButton.getIconWidth() > imageNormalButton.getIconWidth() && imageClickedButton.getIconWidth() >
                imageHoveredButton.getIconWidth()) {
            return imageClickedButton.getIconWidth();
        }
        else {
            return imageNormalButton.getIconWidth();
        }
    }

    public void getNormalButton() {
        this.buttonBackgroundImage = imageNormalButton;

        setVisible(false);
        panelButton.remove(this);
        setPreferredSize(new Dimension(this.imageNormalButton.getIconWidth(),
                this.imageNormalButton.getIconHeight()));
        panelButton.add(this);
        setVisible(true);
    }
    public void getHoveredButton() {
        this.buttonBackgroundImage = imageHoveredButton;

        setVisible(false);
        panelButton.remove(this);
        setPreferredSize(new Dimension(this.imageHoveredButton.getIconWidth(),
                this.imageHoveredButton.getIconHeight()));
        panelButton.add(this);
        setVisible(true);
    }
    public void getClickedButton() {
        this.buttonBackgroundImage = imageClickedButton;

        setVisible(false);
        panelButton.remove(this);
        setPreferredSize(new Dimension(this.imageClickedButton.getIconWidth(),
                this.imageClickedButton.getIconHeight()));
        panelButton.add(this);
        setVisible(true);
    }

    public JPanel getPanelButton() {
        return this.panelButton;
    }

    @Override
    protected void paintComponent(Graphics g) { //The paintComponent method is overridden to customize the button's
        // appearance. This method is automatically called by Swing to paint a component.
        super.paintComponent(g); // For the Current component: Ensure that any default painting behavior is preserved.

        if (buttonBackgroundImage != null) { // `fileBackground != null -> just to be sure that we are drawing non-empty
            // image to the component(button in this case).
            Image image = buttonBackgroundImage.getImage(); // `Image` is an Abstract class, that's why you can't create
            // an object of `Image`.

            /*
              *: This is done because the paintComponent method in Swing typically works with Image objects when it comes
              to rendering images on Swing components.

              *: `ImageIcon` must be changed to type of `Image` in order to render a component.

              *: `Image`: inside the package `swing`

              *: `ImageIcon`: inside the package `awt`
            */


            g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // Responsible for drawing the
            // background image onto the button.

            /*
               *: `g`: The g variable is an instance of the Graphics class. It represents the graphics context that
                  allows you to draw and manipulate graphics on the button's surface. In Java Swing, when you want to
                  draw something on a component like a button, you use the Graphics object.

               *: `(0, 0)`: These are the x and y coordinates where the drawing will start. In this case, (0, 0)
                  represents the top-left corner of the button. This is where the image will begin to be drawn.

               *: `getWidth`: returns the width of the current component in pixels.

               *: `getHeight`: returns the height of the current component in pixels.

               *: this refers to the current instance of the CButton class. It specifies the coordinate system relative
                  to the component itself. When we use this as the last argument in g.drawImage(...), it means that the
                  drawing coordinates (0, 0) are within the context of this specific component. In other words, it
                  indicates that the rendering process will apply to the current (this) instance of the CButton and will
                  draw the image starting from the top-left (0, 0) corner of the component.
            */
        }
    }
}