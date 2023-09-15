package src.ui;

import src.custom.CButton;
import src.custom.CLabel;
import src.custom.CPanel;
import src.custom.OpacityImageIcon;
import src.custom.customTextField.CTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {
    private final CPanel backgroundPanel;
    private static final String loginFolder = "C:\\Users\\user\\Documents\\java\\Java-Final-Project\\Image\\loginPage\\";
    private static final String textStyle = "Times New Roman";
    private CButton button1;
    private CButton button2;


    public Login(JFrame frame) {
        ImageIcon backgroundOpacityNAdj = new ImageIcon(loginFolder + "2.png");
        OpacityImageIcon backgroundOpacityAdj = new OpacityImageIcon(backgroundOpacityNAdj, 0.9f);
        ImageIcon backgroundOpacityGood = backgroundOpacityAdj.getDecreasedOpacityImageIcon();

        this.backgroundPanel = new CPanel(backgroundOpacityGood);
        this.backgroundPanel.setLayout(null);
        frame.add(this.backgroundPanel);

        buildLoginComp();
        buildSignUpComp();
    }
    public void buildLoginComp() {
        ImageIcon loginPartOpacityNAdj = new ImageIcon(loginFolder + "7.png");
        OpacityImageIcon loginPartOpacityAdj = new OpacityImageIcon(loginPartOpacityNAdj, 0.8f);
        ImageIcon loginPartOpacityGood = loginPartOpacityAdj.getDecreasedOpacityImageIcon();

        CPanel loginPartPanel = new CPanel(loginPartOpacityGood);
        loginPartPanel.setLayout(null);
        loginPartPanel.setBounds(24, -93, loginPartPanel.getPanelWidth(), loginPartPanel.getPanelHeight());
        this.backgroundPanel.add(loginPartPanel);

        //comp 1
        ImageIcon label1OpacityHigh = new ImageIcon(loginFolder + "6.png");
        OpacityImageIcon label1OpacityLow = new OpacityImageIcon(label1OpacityHigh, 0.8f);
        ImageIcon label1Image = label1OpacityLow.getDecreasedOpacityImageIcon();

        CLabel cLab = new CLabel(label1Image, true);
        cLab.customizeText(textStyle, Font.BOLD, 35, 55, 100, 23);
        cLab.moveTextOrComponent(10, 0, 0, 20, -1);
        cLab.setBounds(-10, -170, cLab.getLabelWidth(), cLab.getLabelHeight());
        loginPartPanel.add(cLab);

        //comp 2
        ImageIcon label2OpacityHigh = new ImageIcon(loginFolder + "5.png");
        OpacityImageIcon label2OpacityLow = new OpacityImageIcon(label2OpacityHigh, 0.8f);
        ImageIcon label2Image = label2OpacityLow.getDecreasedOpacityImageIcon();

        CLabel cLab2 = new CLabel(label2Image, true);
        cLab2.customizeText(textStyle, Font.BOLD, 35, 55, 100, 23);
        cLab2.moveTextOrComponent(10, 0, 0, 20, -1);
        cLab2.setBounds(-170, -110, cLab2.getLabelWidth(), cLab2.getLabelHeight());
        loginPartPanel.add(cLab2);

        //comp 3
        ImageIcon tF1OpacityHighDes = new ImageIcon(loginFolder + "8.png");
        OpacityImageIcon tF1OpacityLowDes = new OpacityImageIcon(tF1OpacityHighDes, 0.3f);
        ImageIcon tF1BackgroundDes = tF1OpacityLowDes.getDecreasedOpacityImageIcon();

        ImageIcon tF1OpacityHighSel = new ImageIcon(loginFolder + "8.png");
        OpacityImageIcon tF1OpacityLowSel = new OpacityImageIcon(tF1OpacityHighSel, 0.99f);
        ImageIcon tF1BackgroundSel = tF1OpacityLowSel.getDecreasedOpacityImageIcon();

        CTextField cTextField1 = new CTextField(tF1BackgroundDes, tF1BackgroundSel, 530, 355, 350, 100, " username");
        cTextField1.customizeWaterMark(textStyle, 0, 20, 55, 100, 23);
        cTextField1.moveWaterMarkPosition(13, 0, 0, 0);
        cTextField1.customizeTextField(textStyle, 0, 20, 100, 100, 100);
        cTextField1.setBounds(-30, -65, tF1BackgroundDes.getIconWidth(), tF1BackgroundDes.getIconHeight()); //-30 -65
        loginPartPanel.add(cTextField1);

        // comp 4
        ImageIcon label3OpacityHigh = new ImageIcon(loginFolder + "4.png");
        OpacityImageIcon label3OpacityLow = new OpacityImageIcon(label3OpacityHigh, 0.8f);
        ImageIcon label3Image = label3OpacityLow.getDecreasedOpacityImageIcon();

        CLabel cLab3 = new CLabel(label3Image, true);
        cLab3.customizeText(textStyle, Font.BOLD, 35, 55, 100, 23);
        cLab3.moveTextOrComponent(10, 0, 0, 20, -1);
        cLab3.setBounds(-170, 0, cLab3.getLabelWidth(), cLab3.getLabelHeight());
        loginPartPanel.add(cLab3);

        // comp 5
        ImageIcon tF2OpacityHighDes = new ImageIcon(loginFolder + "8.png");
        OpacityImageIcon tF2OpacityLowDes = new OpacityImageIcon(tF2OpacityHighDes, 0.3f);
        ImageIcon tF2BackgroundDes = tF2OpacityLowDes.getDecreasedOpacityImageIcon();

        ImageIcon tF2OpacityHighSel = new ImageIcon(loginFolder + "8.png");
        OpacityImageIcon tF2OpacityLowSel = new OpacityImageIcon(tF2OpacityHighSel, 0.99f);
        ImageIcon tF2BackgroundSel = tF2OpacityLowSel.getDecreasedOpacityImageIcon();

        CTextField cTextField2 = new CTextField(tF2BackgroundDes, tF2BackgroundSel, 530, 355, 350,
                100, " password");
        cTextField2.customizeWaterMark(textStyle, 0, 20, 55, 100, 23);
        cTextField2.moveWaterMarkPosition(13, 0, 0, 0);
        cTextField2.customizeTextField(textStyle, 0, 20, 100, 100, 100);
        cTextField2.setBounds(-27, 46, tF1BackgroundDes.getIconWidth(), tF1BackgroundDes.getIconHeight()); //-30 -65
        loginPartPanel.add(cTextField2);

        // comp6
        button1 = new CButton(loginFolder + "normal.png", loginFolder + "hover.png",
                loginFolder + "Selected.png");
        button1.addActionListener(this);
        JPanel panelButton1 = button1.getPanelButton();
        panelButton1.setBounds(-27, 150, button1.getPanelWidth(), button1.getPanelWidth());
        button1.setBounds(-200, 150, button1.getPanelWidth(), button1.getPanelHeight());
        loginPartPanel.add(panelButton1);
    }
    public void buildSignUpComp() {
        ImageIcon highOpacity = new ImageIcon(loginFolder + "13.png");
        OpacityImageIcon opacityDec = new OpacityImageIcon(highOpacity, 0.99f);
        ImageIcon backgroundImage = opacityDec.getDecreasedOpacityImageIcon();

        CPanel signUpPanel = new CPanel(backgroundImage);
        signUpPanel.setLayout(null);
        signUpPanel.setBounds(24, 228, signUpPanel.getPanelWidth(), signUpPanel.getPanelHeight());
        this.backgroundPanel.add(signUpPanel);

        //comp 1
        ImageIcon label1OpacityHigh = new ImageIcon(loginFolder + "3.png");
        OpacityImageIcon label1OpacityLow = new OpacityImageIcon(label1OpacityHigh, 0.8f);
        ImageIcon label1Image = label1OpacityLow.getDecreasedOpacityImageIcon();

        CLabel cLab = new CLabel(label1Image, true);
        cLab.customizeText(textStyle, Font.BOLD, 35, 55, 100, 23);
        cLab.moveTextOrComponent(10, 0, 0, 20, -1);
        cLab.setBounds(-10, -30, cLab.getLabelWidth(), cLab.getLabelHeight());
        signUpPanel.add(cLab);

        //comp 2
        button2 = new CButton(loginFolder + "normal2.png", loginFolder + "hover2.png",
                loginFolder + "selected2.png");
        button1.addActionListener(this);
        JPanel panelButton1 = button1.getPanelButton();
        panelButton1.setBounds(-10, 30, button1.getPanelWidth(), button1.getPanelWidth());
        signUpPanel.add(panelButton1);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
/*        if(e.getSource() == button2) {
            loginPage.setVisible(false);
            CreateAccount crAccount = new CreateAccount();
            crAccount.majorPanels(panelFrame, closeApp);
        }
        else if(e.getSource() == button1) {
            EmployeeManagement empMan = new EmployeeManagement();
            boolean validate = empMan.checkLogin(fText.getText(), passText.getPassword());

            if(validate) {
                announceLabel.setText("");
                try {
                    // Pause the system for the specified duration
                    Thread.sleep(1400);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                loginPage.setVisible(false);
                AdminPage admin = new AdminPage();
                admin.constructPanel(panelFrame, closeApp);
            }
            else {
                announceLabel.setText("Invalid");
            }
        }
        else if(e.getSource() == exitButton) {
            closeApp.dispose();
        }*/
    }
}