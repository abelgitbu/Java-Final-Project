package src;


import src.ui.Login;
import javax.swing.*;

public class Main extends JFrame {
    private String fileBackground = "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\loginPage\\2.png";

    public static void main(String[] args) {
        new Main().doAllUi();
    }
    public void doAllUi() {
        ImageIcon backGroundImage = new ImageIcon(fileBackground);
        setBounds(230, 140, backGroundImage.getIconWidth(), backGroundImage.getIconHeight());
        setResizable(false);
        setTitle("Employee Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Login login = new Login(this);

        setVisible(true);
    }
}