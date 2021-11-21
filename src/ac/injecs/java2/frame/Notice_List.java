package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.repository.NoticeRepositoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Notice_List  extends JPanel {
    private Main mainFrame;
    public Notice_List(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel Maintitle = new JLabel("게시글 목록", JLabel.CENTER);
        Maintitle.setBounds(430, 30, 200, 25);
        Maintitle.setFont(InjeFont.Lfont);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 49, 560, 189);



    }
}
