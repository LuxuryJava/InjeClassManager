package ac.injecs.java2.frame.user;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.entity.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserInfoPanel extends JPanel {
    Main mainFrame = null;

    public UserInfoPanel(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);

        JLabel title = new JLabel("내 정보");
        title.setBounds(10, 0, 300, 50);
        title.setFont(InjeFont.Mfont);

        JLabel nameText = new JLabel("이름");
        nameText.setBounds(270, 150, 100, 30);
        nameText.setFont(InjeFont.Sfont);

        JLabel idText = new JLabel("학번");
        idText.setBounds(270, 200, 100, 30);
        idText.setFont(InjeFont.Sfont);

        JLabel departText = new JLabel("소속");
        departText.setBounds(270, 250, 100, 30);
        departText.setFont(InjeFont.Sfont);

        JLabel emailText = new JLabel("이메일");
        emailText.setBounds(260, 300, 100, 30);
        emailText.setFont(InjeFont.Sfont);


        JLabel phoneText = new JLabel("전화번호");
        phoneText.setBounds(250, 350, 100, 30);
        phoneText.setFont(InjeFont.Sfont);

        add(title);
        add(nameText);
        add(idText);
        add(departText);
        add(emailText);
        add(phoneText);

        setVisible(true);
    }

    public void update(){
        Student user = mainFrame.session.getUser();

        JLabel name = new JLabel("");
        name.setBounds(300, 100, 100, 30);
        add(name);
    }
}
