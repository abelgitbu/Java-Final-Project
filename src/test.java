package src;

import src.custom.CButton;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class test {

/*
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\loginPage\\normal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\loginPage\\hover.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\loginPage\\Selected.png"
*/

    /*
      "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\normal.png",
      "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\hover.png",
      "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\press.png"
     */

    private static String userName;
    private static Connection connection;
    private PreparedStatement pStatement;
    public static void main(String[] args) {
/*        JFrame frame = new JFrame("Test");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(0, 0, 1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CButton button1 = new CButton(       "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\normal.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\hover.png",
                "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\press.png");
        JPanel panelButton1 = button1.getPanelButton();
        panelButton1.setBackground(Color.GREEN);
        panelButton1.setOpaque(true);
        panelButton1.setBounds(0, 0, button1.getPanelWidth(), button1.getPanelHeight()); //320, 370
        frame.add(panelButton1);

        frame.setVisible(true);*/

        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3307/GuiDataBaseA2", "root", "abelasnake@2abelasnake@2");

            Statement statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
