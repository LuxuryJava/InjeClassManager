package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignPanel extends JPanel {
    // DI 주입
    private Main mainFrame;
    static Font Sfont = new Font("나눔고딕", Font.BOLD, 15);
    public SignPanel(Main main) {
        this.mainFrame = main;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("회원가입", SwingConstants.CENTER);
        title.setFont(new Font("나눔고딕", Font.BOLD, 30));
        add(title, BorderLayout.NORTH);

        SignBox signBox = new SignBox();
        add(signBox, BorderLayout.CENTER);
    }

    public class SignBox extends JPanel{
        private int textStartY = 20;
        private int textWidth = 50;
        private int textHeight = 30;
        private int fieldWidth = 150;

        public SignBox() {
            setLayout(null);
            setBackground(new Color(0xA2E8DB));
            JLabel nameText = new JLabel("이름:");
            JTextField nameField = new JTextField();
            JLabel departText = new JLabel("학과:");
            JTextField departField = new JTextField();
            JLabel codeText = new JLabel("학번:");
            JTextField codeField = new JTextField();
            JLabel emailText = new JLabel("이메일:");
            JTextField emailField = new JTextField();
            JLabel phoneText = new JLabel("전화번호:");
            JTextField phoneField = new JTextField();
            JLabel passwordText = new JLabel("비밀번호:");
            JPasswordField passwordField = new JPasswordField();
            JLabel repasswordText = new JLabel("비밀번호 확인:");
            JTextField repasswordField = new JPasswordField();

            JButton doneButton = new JButton("회원가입");
            doneButton.setBounds(420, 410, 100, 30);
            doneButton.setFont(Sfont);

            nameText.setBounds(380, 121, textWidth, textHeight);
            nameField.setBounds(400 + textWidth, 121, fieldWidth, textHeight);
            departText.setBounds(380, 121 + 40, textWidth, textHeight);
            departField.setBounds(400 + textWidth, 121 + 40, fieldWidth, textHeight);
            codeText.setBounds(380, 121 + 80, textWidth, textHeight);
            codeField.setBounds(400 + textWidth, 121 + 80, fieldWidth, textHeight);
            emailText.setBounds(370, 121 + 120, textWidth + 10, textHeight);
            emailField.setBounds(400 + textWidth, 121 + 120, fieldWidth, textHeight);
            phoneText.setBounds(330, 121 + 160, textWidth + 50, textHeight);
            phoneField.setBounds(400 + textWidth, 121 + 160, fieldWidth, textHeight);
            passwordText.setBounds(330, 121 + 200, textWidth + 50, textHeight);
            passwordField.setBounds(400 + textWidth, 121 + 200, fieldWidth, textHeight);
            repasswordText.setBounds(300, 121 + 240, textWidth + 80, textHeight);
            repasswordField.setBounds(400 + textWidth, 121 + 240, fieldWidth, textHeight);

            nameText.setHorizontalAlignment(SwingConstants.RIGHT);
            departText.setHorizontalAlignment(SwingConstants.RIGHT);
            codeText.setHorizontalAlignment(SwingConstants.RIGHT);
            emailText.setHorizontalAlignment(SwingConstants.RIGHT);
            phoneText.setHorizontalAlignment(SwingConstants.RIGHT);
            passwordText.setHorizontalAlignment(SwingConstants.RIGHT);
            repasswordText.setHorizontalAlignment(SwingConstants.RIGHT);

            nameText.setFont(Sfont);
            departText.setFont(Sfont);
            codeText.setFont(Sfont);
            emailText.setFont(Sfont);
            phoneText.setFont(Sfont);
            passwordText.setFont(Sfont);
            repasswordText.setFont(Sfont);

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

            doneButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    // 회원가입
                    User user = new User();
                    user.setDepartment(departField.getText());
                    user.setEmail(emailField.getText());
                    user.setName(nameField.getText());
                    user.setPhoneNuber(phoneField.getText());
                    user.setPassword(String.valueOf(passwordField.getPassword()));
                    System.out.println(user.toString());

                    mainFrame.memoryUserRepository.save(user);
                }
            });
            setVisible(true);
        }
    }
}
