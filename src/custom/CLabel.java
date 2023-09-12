package custom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class CLabel extends JLabel {
    {
        toAddComponent = new ArrayList<>();
    }

    private final ImageIcon labelBackgroundImage;
    private int width = 0;
    private int height = 0;
    private final ArrayList<JPanel> toAddComponent;
    private int compIndex = 0;

    public CLabel(String fileImage, boolean onlyText) {
        labelBackgroundImage = new ImageIcon(fileImage);
        labelSize();
        setPreferredSize(new Dimension(width, height));

        if(!onlyText) {
            setOpaque(true);
        }

        setLayout(null);
    }

    public void moveTextOrComponent(int moveToRight, int moveToLeft, int moveToTop, int moveToBottom, int forWhichComp) {
        labelSize();
        final float PERCENT_WIDTH = 0.1f;
        final float PERCENT_HEIGHT = 0.2f;

        if(moveToBottom > (int) (height - (height * PERCENT_HEIGHT))) {
            moveToBottom = (int) (height - (height * PERCENT_HEIGHT));
        }
        else if(moveToTop > (int) (height - (height * PERCENT_HEIGHT))) {
            moveToTop = (int) (height - (height * PERCENT_HEIGHT));
        }
        else if(moveToRight > (int) (width - (width * PERCENT_WIDTH))) {
            moveToRight = (int) (width - (width * PERCENT_WIDTH));
        }
        else if(moveToLeft > (int) (width - (width * PERCENT_WIDTH))) {
            moveToLeft = (int) (width - (width * PERCENT_WIDTH));
        }

        EmptyBorder e = new EmptyBorder(moveToBottom, moveToRight, moveToTop, moveToLeft);

        if(forWhichComp == -1) {
            setBorder(e);
        }
        else {
            if(forWhichComp >= compIndex) {
                System.out.println("No component with " + forWhichComp + " index!");
            }
            else {
                toAddComponent.get(forWhichComp).setBorder(e);
            }
        }
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
    public void addComponentToLabel(Component component, int moveToRight, int moveToLeft, int moveToTop, int moveToBottom) {
        JPanel panel = new JPanel();
        labelSize();
        panel.setBounds(0, 0, width, height);
        panel.add(component);
        panel.setOpaque(false);

        toAddComponent.add(panel);
        add(toAddComponent.get(compIndex));
        ++compIndex;

        moveTextOrComponent(moveToRight, moveToLeft, moveToTop, moveToBottom, (compIndex - 1));
    }

    public void labelSize() {
        width = labelBackgroundImage.getIconWidth();
        height = labelBackgroundImage.getIconHeight();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (labelBackgroundImage != null) {
            Image image = labelBackgroundImage.getImage();

            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}