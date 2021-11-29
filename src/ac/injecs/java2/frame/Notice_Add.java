package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.dto.NoticeDto;
import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.entity.ResInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Writer;

//Frame
public class Notice_Add  extends JPanel {
    private Main mainFrame;
    private JTextField WriterFelid;

    public Notice_Add(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel Maintitle = new JLabel("게시글 등록", JLabel.CENTER);
        Maintitle.setBounds(430, 30, 200, 25);
        Maintitle.setFont(InjeFont.Lfont);

        JLabel  Ntitle = new JLabel("글제목");
        Ntitle.setBounds(375, 150, 57, 20);
        Ntitle.setFont(InjeFont.Mfont);

        JTextField TitleFelid = new JTextField();
        TitleFelid.setBounds(450, 150, 200, 20);

        JLabel  Ncontent = new JLabel("글내용");
        Ncontent.setBounds(375, 200, 60, 20);
        Ncontent.setFont(InjeFont.Mfont);

        JTextArea NtextArea = new JTextArea();
        NtextArea.setLineWrap(true);
        NtextArea.setBounds(450, 200, 340, 130);

        JLabel Nwriter = new JLabel("작성자");
        Nwriter.setBounds(375, 330, 57, 20);
        Nwriter.setFont(InjeFont.Mfont);

        WriterFelid = new JTextField("아무개");
        WriterFelid.setBounds(450, 330, 116, 21);
        WriterFelid.setEnabled(false);

        JButton Endbtn = new JButton("작성완료");
        Endbtn.setBounds(500, 400, 150, 25);
        Endbtn.setFont(InjeFont.Sfont);

        add(Maintitle);
        add(Ntitle);
        add(TitleFelid);
        add(Ncontent);
        add(NtextArea);
        add(Nwriter);
        add(WriterFelid);
        add(Endbtn);


        Endbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    //공지사항 등록
                    NoticeDto notice = new NoticeDto();
                    notice.setTitle(TitleFelid.getText());
                    notice.setContent(NtextArea.getText());
                    System.out.println(notice);

                    mainFrame.noticeController.post(notice);

                    System.out.println(notice.toString());

                } catch (IllegalStateException e) {
                    JOptionPane.showMessageDialog(null, "필드를 채워주세요.", "MESSAGE", JOptionPane.WARNING_MESSAGE);
                } catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "다른 제목으로 지어주세요.", "MESSAGE", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        setVisible(true);
    }
    public void paintComponent(Graphics g){
        if(mainFrame.session.isLogin){
            String name = mainFrame.session.getUser().getName();
            WriterFelid.setText(name);
        }
    }
}
