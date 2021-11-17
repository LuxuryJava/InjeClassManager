package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

public class LoginPanel extends JPanel {
    private Main mainFrame;
    static Font Sfont = new Font("나눔고딕", Font.BOLD, 15);
    public LoginPanel(Main main) {
        this.mainFrame = main;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("로그인", SwingConstants.CENTER);
        title.setFont(new Font("나눔고딕", Font.BOLD, 30));
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

            JLabel idText = new JLabel("ID:");
            JTextField idField = new JTextField();
            JLabel passwordText = new JLabel("PW:");
            JPasswordField passwordField = new JPasswordField();
            JButton signButton = new JButton("회원가입");
            JButton loginButton = new JButton("로그인");

            idText.setBounds(380, 200, textWidth, 30);
            idField.setBounds(400 + textWidth, 200, 150, 30);
            passwordText.setBounds(380, 240, textWidth, 30);
            passwordField.setBounds(400 + textWidth, 240, 150, 30);
            signButton.setBounds(400, 300, 90, 30);
            loginButton.setBounds(500, 300, 90, 30);

            idText.setHorizontalAlignment(SwingConstants.RIGHT);
            passwordText.setHorizontalAlignment(SwingConstants.RIGHT);

            idText.setFont(Sfont);
            passwordText.setFont(Sfont);
            signButton.setFont(new Font("나눔고딕", Font.BOLD, 13));
            loginButton.setFont(Sfont);

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
                    Optional<User> find = mainFrame.userRepository.findById(idField.getText());
                    if(find.isEmpty()){
                        System.out.println("존재하지 않는 계정");
                        return;
                    }
                    User user = find.get();

                    boolean equals = user.getPassword().equals(String.valueOf(passwordField.getPassword()));
                    if(equals){
                        System.out.println("로그인 성공");
                    }
                    else{
                        System.out.println("비밀번호가 틀렸습니다");
                    }
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
