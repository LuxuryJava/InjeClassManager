package ac.injecs.java2.frame.user;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.entity.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserInfoPanel extends JPanel {
    Main mainFrame = null;
    UserLabel userLabel = new UserLabel();

    class UserLabel {
        public JLabel name;
        public JLabel id;
        public JLabel depart;
        public JLabel email;
        public JLabel phone;
    }

    public UserInfoPanel(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);

        JLabel title = new JLabel("내 정보");
        title.setBounds(10, 0, 300, 50);
        title.setFont(InjeFont.Mfont);


        JLabel nameText = new JLabel("이름");
        nameText.setBounds(270, 150, 100, 30);
        nameText.setFont(InjeFont.Sfont);

        userLabel.name = new JLabel("박성훈");
        userLabel.name.setBounds(350, 150, 300, 30);
        userLabel.name.setFont(InjeFont.Mfont);

        JLabel idText = new JLabel("학번");
        idText.setBounds(270, 200, 100, 30);
        idText.setFont(InjeFont.Sfont);

        userLabel.id = new JLabel("20182621");
        userLabel.id.setBounds(350, 200, 300, 30);
        userLabel.id.setFont(InjeFont.Mfont);

        JLabel departText = new JLabel("소속");
        departText.setBounds(270, 250, 100, 30);
        departText.setFont(InjeFont.Sfont);

        userLabel.depart = new JLabel("컴퓨터공학부");
        userLabel.depart.setBounds(350, 250, 300, 30);
        userLabel.depart.setFont(InjeFont.Mfont);

        JLabel emailText = new JLabel("이메일");
        emailText.setBounds(260, 300, 100, 30);
        emailText.setFont(InjeFont.Sfont);

        userLabel.email = new JLabel("shonn@naver.com");
        userLabel.email.setBounds(350, 300, 300, 30);
        userLabel.email.setFont(InjeFont.Mfont);

        JLabel phoneText = new JLabel("전화번호");
        phoneText.setBounds(250, 350, 100, 30);
        phoneText.setFont(InjeFont.Sfont);

        userLabel.phone = new JLabel("0100213");
        userLabel.phone.setBounds(350, 350, 300, 30);
        userLabel.phone.setFont(InjeFont.Mfont);

        add(title);
        add(nameText);
        add(idText);
        add(departText);
        add(emailText);
        add(phoneText);
        add(userLabel.name);
        add(userLabel.id);
        add(userLabel.depart);
        add(userLabel.email);
        add(userLabel.phone);

        setVisible(true);
    }

    public void paintComponent(Graphics g){
        updateComponent();
    }


    public void updateComponent(){
        if (mainFrame.session.getUser().getName().equals("관리자")) {
            return;
        }
        Student user = (Student) mainFrame.session.getUser();
        userLabel.name.setText(user.getName());
        userLabel.id.setText(user.getId().toString());
        userLabel.depart.setText(user.getDepartment());
        userLabel.email.setText(user.getEmail());
        userLabel.phone.setText(user.getPhoneNumber());
    }
}
