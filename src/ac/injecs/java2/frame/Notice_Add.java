package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;

import javax.swing.*;
import java.awt.event.*;

//Frame
public class Notice_Add  extends JPanel {
    private Main mainFrame;
    public Notice_Add(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel Maintitle = new JLabel("게시글 등록", JLabel.CENTER);
        Maintitle.setBounds(430, 30, 200, 25);
        Maintitle.setFont(InjeFont.Lfont);

        JLabel  Ntitle = new JLabel("글제목");
        Ntitle.setBounds(375, 150, 57, 20);
        Ntitle.setFont(InjeFont.Mfont);

        JTextField TitleFelid = new JTextField("글제목입니다.");
        TitleFelid.setBounds(450, 150, 200, 20);

        JLabel  Ncontent = new JLabel("글내용");
        Ncontent.setBounds(375, 200, 60, 20);
        Ncontent.setFont(InjeFont.Mfont);

        JTextArea NtextArea = new JTextArea("글내용 글내용..");
        NtextArea.setLineWrap(true);
        NtextArea.setBounds(450, 200, 340, 130);

        JLabel Nwriter = new JLabel("작성자");
        Nwriter.setBounds(375, 330, 57, 20);
        Nwriter.setFont(InjeFont.Mfont);

        JTextField WriterFelid = new JTextField("아무개");
        WriterFelid.setBounds(450, 330, 116, 21);
        WriterFelid.setEnabled(false);

        JButton Endbtn = new JButton("작성완료");
        Endbtn.setBounds(500, 400, 150, 25);
        Endbtn.setFont(InjeFont.Sfont);

        Endbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        add(Maintitle);
        add(Ntitle);
        add(TitleFelid);
        add(Ncontent);
        add(NtextArea);
        add(Nwriter);
        add(WriterFelid);
        add(Endbtn);

        setVisible(true);
    }
}
