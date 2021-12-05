package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {
    private Main mainFrame;
    private LoginBox loginBox;
    public LoginPanel(Main main) {
        this.mainFrame = main;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("로그인", SwingConstants.CENTER);
        title.setFont(InjeFont.XLfont);
        add(title, BorderLayout.NORTH);

        loginBox = new LoginBox();
        add(loginBox, BorderLayout.CENTER);
        setVisible(true);
    }

    public class LoginBox extends JPanel {
        private int textWidth = 50;
        JTextField idField;
        public LoginBox(){
            setLayout(null);
            setBackground(new Color(0xA2E8DB));

            JLabel idText = new JLabel(" 학번: ");
            idField = new JTextField();
            JLabel passwordText = new JLabel("비밀번호:");
            JPasswordField passwordField = new JPasswordField();
            JButton signButton = new JButton("회원가입");
            JButton loginButton = new JButton("로그인");
            JLabel errorMessage = new JLabel("");
            errorMessage.setForeground(Color.RED);

            idText.setBounds(380, 200, textWidth, 30);
            idField.setBounds(400 + textWidth, 200, 150, 30);
            passwordText.setBounds(380, 240, textWidth + 20, 30);
            passwordField.setBounds(400 + textWidth, 240, 150, 30);
            signButton.setBounds(400, 320, 90, 30);
            loginButton.setBounds(640, 200, 90, 70);
            errorMessage.setBounds(430, 280, 300, 30);

            idText.setHorizontalAlignment(SwingConstants.RIGHT);
            passwordText.setHorizontalAlignment(SwingConstants.RIGHT);

            idText.setFont(InjeFont.Sfont);
            passwordText.setFont(InjeFont.Sfont);
           signButton.setFont(new Font("나눔고딕", Font.BOLD, 13));
            loginButton.setFont(InjeFont.Sfont);
            errorMessage.setFont(InjeFont.Sfont);

            add(idText);
            add(idField);
            add(passwordText);
            add(passwordField);
            add(loginButton);
            add(errorMessage);

            signButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.signPanel);
                }
            });

            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String password = String.valueOf(passwordField.getPassword());
                    try {
                        String id = idField.getText();
                        boolean isLogin = mainFrame.userController.login(mainFrame.session, id, password);

                        if(isLogin) {
                            // 관리자인지 확인
                            if (mainFrame.session.getUser().isManager()){
                                mainFrame.managerMode();
                                System.out.println("관리자임");
                            }
                            mainFrame.setCenterPanel(mainFrame.dashBoardPanel);
                            mainFrame.userInfoPanel.update();
                            mainFrame.setsno(id);
                            errorMessage.setText("");
                            idField.setText("");
                            passwordField.setText("");
                            mainFrame.reservation.setid(id.toString());
                        }
                        else {
                            errorMessage.setText("비밀번호를 확인해주세요");
                        }
                    } catch (NumberFormatException e) {
                        errorMessage.setText("모든 필드를 채워주세요");
                    } catch (IllegalStateException e) {
                        errorMessage.setText(e.getMessage());
                    }
                }
            });
            setVisible(true);
        }

        public void fieldFocuse(boolean state) {
            idField.setFocusable(state);
            idField.requestFocus();
        }
    }
    public void fieldFocuse(boolean state){
        loginBox.fieldFocuse(state);
    }
}
