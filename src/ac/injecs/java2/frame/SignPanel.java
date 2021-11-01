package ac.injecs.java2.frame;

import ac.injecs.java2.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignPanel extends JPanel {
    // DI 주입
    private Main mainFrame;

    public SignPanel(Main main) {
        this.mainFrame = main;

        setLayout(null);

        JLabel text = new JLabel("회원가입", JLabel.CENTER);
        text.setBounds(500, 100, 50, 20);

        SignBox signBox = new SignBox();
        signBox.setBounds(380, 100, 300, 400);

        add(text);
        add(signBox);

        setVisible(true);
    }

    public class SignBox extends JPanel{
        private int textStartY = 20;
        private int textWidth = 50;
        private int textHeight = 30;
        private int fieldWidth = 150;

        public SignBox() {
            setLayout(null);
            setBackground(Color.CYAN);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel nameText = new JLabel("이름");
            JTextField nameField = new JTextField();
            JLabel departText = new JLabel("학과");
            JTextField departField = new JTextField();
            JLabel codeText = new JLabel("학번");
            JTextField codeField = new JTextField();
            JLabel emailText = new JLabel("이메일");
            JTextField emailField = new JTextField();
            JLabel phoneText = new JLabel("전화번호");
            JTextField phoneField = new JTextField();
            JLabel passwordText = new JLabel("비밀번호");
            JPasswordField passwordField = new JPasswordField();
            JLabel repasswordText = new JLabel("비밀번호 확인");
            JTextField repasswordField = new JPasswordField();

            JButton doneButton = new JButton("회원가입");
            doneButton.setBounds(110, 240, 100, 50);


            nameText.setBounds(60, textStartY, textWidth, textHeight);
            nameField.setBounds(60 + textWidth, textStartY, fieldWidth, textHeight);
            departText.setBounds(60, textStartY + 30, textWidth, textHeight);
            departField.setBounds(60 + textWidth, textStartY + 30, fieldWidth, textHeight);
            codeText.setBounds(60, textStartY + 60, textWidth, textHeight);
            codeField.setBounds(60 + textWidth, textStartY + 60, fieldWidth, textHeight);
            emailText.setBounds(50, textStartY + 90, textWidth, textHeight);
            emailField.setBounds(60 + textWidth, textStartY + 90, fieldWidth, textHeight);
            phoneText.setBounds(40, textStartY + 120, textWidth, textHeight);
            phoneField.setBounds(60 + textWidth, textStartY + 120, fieldWidth, textHeight);
            passwordText.setBounds(40, textStartY + 150, textWidth, textHeight);
            passwordField.setBounds(60 + textWidth, textStartY + 150, fieldWidth, textHeight);
            repasswordText.setBounds(20, textStartY + 180, textWidth + 30, textHeight);
            repasswordField.setBounds(60 + textWidth, textStartY + 180, fieldWidth, textHeight);

            add(nameText);
            add(nameField);
            add(departText);
            add(departField);
            add(codeText);
            add(codeField);
            add(emailText);
            add(emailField);
            add(phoneText);
            add(phoneField);
            add(passwordText);
            add(passwordField);
            add(repasswordText);
            add(repasswordField);
            add(doneButton);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("SignBox = " + e.getX() + ", " + e.getY());
                }
            });
            setVisible(true);
        }
    }
}
