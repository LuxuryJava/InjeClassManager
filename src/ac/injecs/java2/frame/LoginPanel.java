package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

public class LoginPanel extends JPanel {
    private Main mainFrame;
    public LoginPanel(Main main) {
        this.mainFrame = main;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("로그인", SwingConstants.CENTER);
        title.setFont(InjeFont.XLfont);
        add(title, BorderLayout.NORTH);

        LoginBox loginBox = new LoginBox();
        add(loginBox, BorderLayout.CENTER);
        setVisible(true);
    }

    public class LoginBox extends JPanel {
        private int textWidth = 50;

        public LoginBox(){
            setLayout(null);
            setBackground(new Color(0xA2E8DB));

            JLabel idText = new JLabel(" 학번: ");
            JTextField idField = new JTextField();
            JLabel passwordText = new JLabel("비밀번호:");
            JPasswordField passwordField = new JPasswordField();
            JButton signButton = new JButton("회원가입");
            JButton loginButton = new JButton("로그인");

            idText.setBounds(395, 180, textWidth, 30);
            idField.setBounds(405 + textWidth, 180, 150, 30);
            passwordText.setBounds(380, 230, textWidth + 20, 30);
            passwordField.setBounds(405 + textWidth, 230, 150, 30);
            signButton.setBounds(420, 300, 90, 30);
            loginButton.setBounds(525, 300, 90, 30);

            idText.setHorizontalAlignment(SwingConstants.RIGHT);
            //passwordText.setHorizontalAlignment(SwingConstants.RIGHT);

            idText.setFont(InjeFont.Sfont);
            passwordText.setFont(InjeFont.Sfont);
            signButton.setFont(new Font("나눔고딕", Font.BOLD, 13));
            loginButton.setFont(InjeFont.Sfont);

            add(idText);
            add(idField);
            add(passwordText);
            add(passwordField);
            add(signButton);
            add(loginButton);

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    Long id = Long.valueOf(idField.getText());
                    String password = String.valueOf(passwordField.getPassword());
                    mainFrame.studentController.getLoginPanel(id, password);
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
