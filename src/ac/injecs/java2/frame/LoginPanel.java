package ac.injecs.java2.frame;

import ac.injecs.java2.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel {
    private Main mainFrame;

    public LoginPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);

        LoginBox loginBox = new LoginBox();
        loginBox.setBounds(350, 100, 300, 300);

        add(loginBox);

        setVisible(true);
    }

    public class LoginBox extends JPanel {
        private int textWidth = 50;

        public LoginBox(){
            setLayout(null);
            setBackground(Color.CYAN);

            JLabel noticeText = new JLabel("로그인");
            JLabel idText = new JLabel("ID");
            JTextField idField = new JTextField();
            JLabel passwordText = new JLabel("PW");
            JPasswordField passwordField = new JPasswordField();
            JButton signButton = new JButton("회원가입");
            JButton loginButton = new JButton("로그인");

            noticeText.setBounds(120, 10, textWidth, 30);
            idText.setBounds(75, 90, textWidth, 30);
            idField.setBounds(75 + textWidth, 90, 150, 30);
            passwordText.setBounds(75, 130, textWidth, 30);
            passwordField.setBounds(75 + textWidth, 130, 150, 30);
            signButton.setBounds(80, 170, 90, 50);
            loginButton.setBounds(190, 170, 80, 50);

            add(noticeText);
            add(idText);
            add(idField);
            add(passwordText);
            add(passwordField);
            add(signButton);
            add(loginButton);


            signButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.signPanel);
                }
            });

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("로그인");
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("로그인 창 + " + e.getX() + "," + e.getY());
                }
            });
            setVisible(true);
        }
    }
}
