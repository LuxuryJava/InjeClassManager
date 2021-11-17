package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.dto.StudentFormDto;
import ac.injecs.java2.entity.Student;

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
            JLabel idText = new JLabel("학번:");
            JTextField idField = new JTextField();
            JLabel nameText = new JLabel("이름:");
            JTextField nameField = new JTextField();
            JLabel departText = new JLabel("학과:");
            JTextField departField = new JTextField();
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

            idText.setBounds(380, 81, textWidth, textHeight);
            idField.setBounds(400 + textWidth, 81, fieldWidth, textHeight);
            nameText.setBounds(380, 121, textWidth, textHeight);
            nameField.setBounds(400 + textWidth, 121, fieldWidth, textHeight);
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

            idText.setHorizontalAlignment(SwingConstants.RIGHT);
            nameText.setHorizontalAlignment(SwingConstants.RIGHT);
            departText.setHorizontalAlignment(SwingConstants.RIGHT);
            emailText.setHorizontalAlignment(SwingConstants.RIGHT);
            phoneText.setHorizontalAlignment(SwingConstants.RIGHT);
            passwordText.setHorizontalAlignment(SwingConstants.RIGHT);
            repasswordText.setHorizontalAlignment(SwingConstants.RIGHT);

            idText.setFont(Sfont);
            nameText.setFont(Sfont);
            departText.setFont(Sfont);
            emailText.setFont(Sfont);
            phoneText.setFont(Sfont);
            passwordText.setFont(Sfont);
            repasswordText.setFont(Sfont);

            add(idText);
            add(idField);
            add(nameText);
            add(nameField);
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
                    StudentFormDto student = new StudentFormDto();
                    student.setId(Long.valueOf(idField.getText()));
                    student.setDepartment(departField.getText());
                    student.setEmail(emailField.getText());
                    student.setName(nameField.getText());
                    student.setPhoneNumber(phoneField.getText());
                    student.setPassword(String.valueOf(passwordField.getPassword()));

                    System.out.println(student.toString());
                }
            });
            setVisible(true);
        }
    }
}
