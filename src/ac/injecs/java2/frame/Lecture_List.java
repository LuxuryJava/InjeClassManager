package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.entity.Notice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Lecture_List extends JPanel {
    private Main mainFrame;
    private List list;

    public Lecture_List(Main main) {
        mainFrame = main;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("공지사항 및 특강", SwingConstants.CENTER);
        title.setFont(InjeFont.XLfont);
        add(title, BorderLayout.NORTH);

        list = new List();
        add(list);

        setVisible(true);
    }

    public void updateContent(){
        list.showLectureData();
        if(mainFrame.session.isLogin){
            if (mainFrame.session.getUser().isManager()) {
                list.AddBtn.setVisible(true);
            }
        }
    }

    public void setButton(int i, String url){
        list.setButtonEvent(i, url);
    }


    public class List extends JPanel {
        JButton AddBtn;
        Lecture[] lectures;
        class Lecture {
            RoundedButton btn;
            String URL;

            public Lecture(){
                btn = new RoundedButton();
                URL = "";
            }

            public Lecture(RoundedButton btn, String URL) {
                this.btn = btn;
                this.URL = URL;
            }
            public RoundedButton getBtn() {
                return btn;
            }

            public void setBtn(RoundedButton btn) {
                this.btn = btn;
            }

            public String getURL() {
                return URL;
            }

            public void setURL(String URL) {
                this.URL = URL;
            }
        }

        public List() {
            setBackground(Color.WHITE);
            setSize(FrameConstant.WIDTH.getValue() - FrameConstant.MENUWIDTH.getValue(), FrameConstant.HEIGHT.getValue());
            setLayout(null);

            AddBtn = new JButton("글 쓰기");
            AddBtn.setFont(InjeFont.PSfont);
            AddBtn.setLocation(830, 495);
            AddBtn.setSize(100, 30);
            AddBtn.setVisible(false);
            add(AddBtn);

            lectures = new Lecture[5];
            for (int i = 0; i < lectures.length; i++) {
                lectures[i] = new Lecture();
                //이미지만 남기기
                lectures[i].getBtn().setBorderPainted(false);
                lectures[i].getBtn().setFocusPainted(false);
                lectures[i].getBtn().setContentAreaFilled(false);
                lectures[i].getBtn().setLocation(40, 90 * i + 50);
                lectures[i].getBtn().setSize(900, 80);
                lectures[i].getBtn().setText("");

                add(lectures[i].getBtn());
                //글쓰기 버튼 클릭 시
                AddBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.setCenterPanel(mainFrame.notice_add);
                    }
                });
            }
            // Data Load To DB
            getLectureData();
        }

        public void showLectureData(){
            java.util.List<Notice> noticeAll = mainFrame.repository.findNoticeAll();
            for (int i = 0; i < noticeAll.size();  i++) {
                Notice item = noticeAll.get(i);
                lectures[i].getBtn().setText(item.getTitle());
                lectures[i].setURL(item.getContent());
            }
        }

        public void setButtonEvent(int i, String url){
            lectures[i].getBtn().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try { //해당 공지사항 클릭 시 웹 페이지로 이동
                        Desktop.getDesktop().browse(new URL(url).toURI());
                    } catch (Exception exe) {
                        System.out.println(exe.getMessage());
                    }
                }
            });
        }

        public void getLectureData(){
            // 데이터를 전부 가져온다
            java.util.List<Notice> noticeAll = mainFrame.repository.findNoticeAll();
            for (int i = 0; i < noticeAll.size();  i++){
                Notice item = noticeAll.get(i);
                lectures[i].getBtn().setText( item.getTitle());
                lectures[i].setURL(item.getContent());
                setButtonEvent(i, item.getContent());
            }
        }

    }
}
