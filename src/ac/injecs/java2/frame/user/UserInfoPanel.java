package ac.injecs.java2.frame.user;

import ac.injecs.java2.Main;
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
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));


        add(title);

        setVisible(true);
    }

    public void update(){
        Student user = mainFrame.session.getUser();

        JLabel name = new JLabel("");
        name.setBounds(300, 100, 100, 30);
        add(name);
    }
}
