package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.ValidateForm;
import ac.injecs.java2.dto.UserFormDto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignPanel extends JPanel {
    // DI 주입
    private Main mainFrame;
    static Font Sfont = new Font("나눔고딕", Font.BOLD, 15);
    JTextField nameField = new JTextField();
    JTextField idField = new JTextField();
    JTextField departField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField phoneField = new JTextField();
    JTextField passwordField = new JPasswordField();
    JTextField repasswordField = new JPasswordField();
    public SignPanel(Main main) {
        this.mainFrame = main;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("회원가입", SwingConstants.CENTER);
        title.setFont(new Font("나눔고딕", Font.BOLD, 30));
        add(title, BorderLayout.NORTH);

        SignBox signBox = new SignBox();
        add(signBox, BorderLayout.CENTER);
    }

    public void fieldClear(){
    	nameField.setText("");
    	idField.setText("");
    	departField.setText("");
    	emailField.setText("");
    	phoneField.setText("");
    	passwordField.setText("");
    	repasswordField.setText("");
    }
    
    public class SignBox extends JPanel{
        private int textWidth = 50;
        private int textHeight = 30;
        private int fieldWidth = 150;
        

        public SignBox() {
            setLayout(null);
            setBackground(new Color(0xA2E8DB));

            JLabel nameText = new JLabel("이름:");
            JLabel idText = new JLabel("학번:");
            
            JLabel departText = new JLabel("학과:");
            JLabel emailText = new JLabel("이메일:");
            JLabel phoneText = new JLabel("전화번호:");
            JLabel passwordText = new JLabel("비밀번호:");
            JLabel repasswordText = new JLabel("비밀번호 확인:");

            JLabel errorMessage = new JLabel("");
            errorMessage.setForeground(Color.RED);
            errorMessage.setBounds(390, 360, 300, 30);

            JButton doneButton = new JButton("회원가입");
            doneButton.setBounds(420, 410, 100, 30);
            doneButton.setFont(Sfont);

            nameText.setBounds(380, 81, textWidth, textHeight);
            nameField.setBounds(400+textWidth, 81, fieldWidth, textHeight);
            idText.setBounds(380, 121, textWidth, textHeight);
            idField.setBounds(400 + textWidth, 121, fieldWidth, textHeight);
            departText.setBounds(380, 121 + 40, textWidth, textHeight);
            departField.setBounds(400 + textWidth, 121 + 40, fieldWidth, textHeight);
            emailText.setBounds(370, 121 + 80, textWidth + 10, textHeight);
            emailField.setBounds(400 + textWidth, 121 + 80, fieldWidth, textHeight);
            phoneText.setBounds(330, 121 + 120, textWidth + 50, textHeight);
            phoneField.setBounds(400 + textWidth, 121 + 120, fieldWidth, textHeight);
            passwordText.setBounds(330, 121 + 160, textWidth + 50, textHeight);
            passwordField.setBounds(400 + textWidth, 121 + 160, fieldWidth, textHeight);
            repasswordText.setBounds(300, 121 + 200, textWidth + 80, textHeight);
            repasswordField.setBounds(400 + textWidth, 121 + 200, fieldWidth, textHeight);

            nameText.setHorizontalAlignment(SwingConstants.RIGHT);
            idText.setHorizontalAlignment(SwingConstants.RIGHT);
            departText.setHorizontalAlignment(SwingConstants.RIGHT);
            emailText.setHorizontalAlignment(SwingConstants.RIGHT);
            phoneText.setHorizontalAlignment(SwingConstants.RIGHT);
            passwordText.setHorizontalAlignment(SwingConstants.RIGHT);
            repasswordText.setHorizontalAlignment(SwingConstants.RIGHT);

            nameText.setFont(Sfont);
            idText.setFont(Sfont);
            departText.setFont(Sfont);
            emailText.setFont(Sfont);
            phoneText.setFont(Sfont);
            passwordText.setFont(Sfont);
            repasswordText.setFont(Sfont);
            errorMessage.setFont(Sfont);

            add(nameText);
            add(nameField);
            add(idText);
            add(idField);
            add(departText);
            add(departField);
            add(emailText);
            add(emailField);
            add(phoneText);
            add(phoneField);
            add(passwordText);
            add(passwordField);
            add(repasswordText);
            add(repasswordField);
            add(doneButton);
            add(errorMessage);

            doneButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        // 회원가입
                        UserFormDto user = new UserFormDto();
                        user.setId(idField.getText());
                        user.setDepartment(departField.getText());
                        user.setEmail(emailField.getText());
                        user.setName(nameField.getText());
                        user.setPhoneNumber(phoneField.getText());
                        user.setPassword(passwordField.getText());

                        // 이름, 이메일 validate
                        if (!ValidateForm.isKorean(nameField.getText())){
                            errorMessage.setText("이름은 한글만 입력해주세요.");
                            return;
                        }

                        if (!ValidateForm.isEmail(emailField.getText())) {
                            errorMessage.setText("이메일형식을 지켜서 입력해주세요.");
                            return;
                        }

                        if (!passwordField.getText().equals(repasswordField.getText())) {
                            errorMessage.setText("비밀번호가 서로 같지 않습니다.");
                            return;
                        }
                        errorMessage.setText("");
                        System.out.println(user.toString());
                        mainFrame.userController.signUp(user);
                        mainFrame.userController.login(mainFrame.session, idField.getText(), passwordField.getText());
                        mainFrame.userInfoPanel.update();
                        mainFrame.setCenterPanel(mainFrame.dashBoardPanel);
                    } catch (NumberFormatException e){
                        errorMessage.setText("모든 필드를 채워주세요.");
                    } catch (Exception e) {
                        errorMessage.setText(e.getMessage());
                    }
                }
            });
            setVisible(true);
        }
    }
}
