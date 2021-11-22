package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import  ac.injecs.java2.entity.Notice;
import ac.injecs.java2.repository.NoticeRepository;
import ac.injecs.java2.repository.NoticeRepositoryImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTable.*;

public class Notice_List  extends JPanel {
    private Main mainFrame;
    private  String[] Tag = new String[] {"글 번호", "제목", "내용", "작성자", "작성일"};
    public Notice_List(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel Maintitle = new JLabel("게시글 목록", JLabel.CENTER);
        Maintitle.setBounds(400, 30, 200, 30);
        Maintitle.setFont(InjeFont.XLfont);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 80, 900, 450);

        JTable table = new JTable();



        add(Maintitle);
        add(scrollPane);


    }
}
