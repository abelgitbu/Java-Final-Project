package src.custom;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.*;

public class CComboList extends JPanel implements ComponentListener {
    {
        jWindow = new JWindow();
    }

    private final JFrame frame;
    private final JWindow jWindow;
    private final Component compAddTo;
    private final ImageIcon backgroundImage;
    private final GridBagConstraints constraints;
    private int showIndex = 0;
    private final JScrollPane scrollPane;

    public CComboList(JFrame frame, Component addTo, JButton decide, String fileBackground) {
        this.frame = frame;
        this.compAddTo = addTo;
        this.backgroundImage = new ImageIcon(fileBackground);
        int width = backgroundImage.getIconWidth();
        int height = backgroundImage.getIconHeight();

        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.gridwidth = 1;
        con.gridheight = 1;
        con.weightx = 1;
        con.weighty = 1;
        con.insets = new Insets(0, 0, 0, 0);
        con.fill = GridBagConstraints.BOTH;
        this.constraints = con;

        this.scrollPane = new JScrollPane(this);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        decide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(showIndex % 2 == 0) {
                    jWindow.setVisible(true);
                }
                else {
                    jWindow.setVisible(false);
                }
                ++showIndex;
            }
        });

        jWindow.setLayout(new BorderLayout());
        jWindow.setVisible(false);
        jWindow.setSize(width, height);
        jWindow.setLocation(0, 420);
        jWindow.setContentPane(scrollPane);

        jWindow.setBackground(new Color(0, 0, 0, 0));
        setBackground(new Color(0, 0, 0, 0));

        scrollPane.setBorder(null);
        this.setBorder(null);

        this.compAddTo.addComponentListener(this);
        this.jWindow.addComponentListener(this);
        this.frame.addComponentListener(this);
        this.frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }
            @Override
            public void windowClosing(WindowEvent e) {

            }
            @Override
            public void windowClosed(WindowEvent e) {

            }
            @Override
            public void windowIconified(WindowEvent e) {

            }
            @Override
            public void windowDeiconified(WindowEvent e) {

            }
            @Override
            public void windowActivated(WindowEvent e) {

            }
            @Override
            public void windowDeactivated(WindowEvent e) {
                if(showIndex % 2 != 0) {
                    --showIndex;
                }
            }
        });
    }
    public void opacityValue(float x) {
        jWindow.setOpacity(x);
    }
    public void addCompToList(Component addComponent, int top, int left, int bottom, int right) {
        this.constraints.insets.set(top, left, bottom, right);
        add(addComponent, this.constraints);
        ++constraints.gridy;
    }
    public void customizeScrollBar(Color thumbRgb, Color trackRgb, JButton newButton, int width, int height, boolean disable) {
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI(thumbRgb, trackRgb, newButton));
        if(disable) {
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        }
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(width, height)); // I get this line from stackoverflow
    }

    @Override
    public void componentResized(ComponentEvent e) {
        if(e.getComponent() == this.compAddTo) {
            Point buttonLocation = this.compAddTo.getLocationOnScreen();
            int x = buttonLocation.x;
            int y = buttonLocation.y + this.compAddTo.getHeight();

            jWindow.setLocation(x, y);
            if(showIndex % 2 == 0) {
                jWindow.setVisible(false);
            }
            else {
                jWindow.setVisible(true);
            }
        }
        else if(e.getComponent() == this.frame) {
            Point buttonLocation = this.compAddTo.getLocationOnScreen();
            int x = buttonLocation.x;
            int y = buttonLocation.y + this.compAddTo.getHeight();

            jWindow.setLocation(x, y);
            if(showIndex % 2 == 0) {
                jWindow.setVisible(false);
            }
            else {
                jWindow.setVisible(true);
            }
        }
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        if(e.getComponent() == this.compAddTo) {
            Point buttonLocation = this.compAddTo.getLocationOnScreen();
            int x = buttonLocation.x;
            int y = buttonLocation.y + this.compAddTo.getHeight();

            jWindow.setLocation(x, y);
            if(showIndex % 2 == 0) {
                jWindow.setVisible(false);
            }
            else {
                jWindow.setVisible(true);
            }
        }
        else if(e.getComponent() == this.frame) {
            Point buttonLocation = this.compAddTo.getLocationOnScreen();
            int x = buttonLocation.x;
            int y = buttonLocation.y + this.compAddTo.getHeight();

            jWindow.setLocation(x, y);
            if(showIndex % 2 == 0) {
                jWindow.setVisible(false);
            }
            else {
                jWindow.setVisible(true);
            }
        }
    }
    @Override
    public void componentShown(ComponentEvent e) {

    }
    @Override
    public void componentHidden(ComponentEvent e) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            Image image = backgroundImage.getImage();

            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Custom ScrollBarUI implementation
    static class CustomScrollBarUI extends BasicScrollBarUI {
        private final JButton scrollButton;
        private final Color thumbRgb;
        private final Color trackRgb;

        public CustomScrollBarUI(Color thumbRgb, Color trackRgb, JButton newButton) {
            this.thumbRgb = thumbRgb;
            this.trackRgb = trackRgb;
            this.scrollButton = newButton;
        }
        @Override
        protected void configureScrollBarColors() {
            thumbColor = thumbRgb; // Set the color of the scrollbar thumb
            trackColor = trackRgb; // Set the color of the scrollbar track
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createEmptyButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createEmptyButton();
        }

        private JButton createEmptyButton() {
            return scrollButton;
        }
    }
}