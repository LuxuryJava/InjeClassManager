package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.repository.Repository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.net.*;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class Lecture_List extends JPanel {
    private Main mainFrame;

    public Lecture_List(Main main) {
        mainFrame = main;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("공지사항 및 특강", SwingConstants.CENTER);
        title.setFont(InjeFont.XLfont);
        add(title, BorderLayout.NORTH);

        List list = new List();
        add(list);

        setVisible(true);
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
                System.out.println(getWidth()-100);
                lectures[i].getBtn().setText("");

                add(lectures[i].getBtn());
                //목록 버튼 클릭 시 해당 공지사항 링크로 연결
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
        private void showLectureData(){
            java.util.List<Notice> noticeAll = mainFrame.repository.findNoticeAll();
            for (int i = 0; i < noticeAll.size();  i++) {
                Notice item = noticeAll.get(i);
                lectures[i].getBtn().setText(item.getTitle());
                lectures[i].setURL(item.getContent());
            }
        }

        private void getLectureData(){
            // 데이터를 전부 가져온다
            java.util.List<Notice> noticeAll = mainFrame.repository.findNoticeAll();
            for (int i = 0; i < noticeAll.size();  i++){
                Notice item = noticeAll.get(i);
                lectures[i].getBtn().setText(item.getTitle());
                lectures[i].setURL(item.getContent());

                lectures[i].getBtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URL(item.getContent()).toURI());//www.google.com").toURI());
                        } catch (Exception exe) {
                             System.out.println(exe.getMessage());
                        }
                    }
                });
            }
        }
        //관리자일 때만 버튼 보임 
        public void paintComponent(Graphics g) {
            showLectureData();
            if(mainFrame.session.isLogin){
                if (mainFrame.session.getUser().isManager()) {
                    AddBtn.setVisible(true);
                }
            }
        }
    }
}
