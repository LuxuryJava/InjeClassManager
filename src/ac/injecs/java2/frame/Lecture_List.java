package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

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
        public List() {
            setBackground(Color.WHITE);
            setSize(FrameConstant.WIDTH.getValue() - FrameConstant.MENUWIDTH.getValue(), FrameConstant.HEIGHT.getValue());
            setLayout(null);

            JButton AddBtn = new JButton("글 쓰기");
            AddBtn.setFont(InjeFont.PSfont);
            AddBtn.setLocation(830,  495);
            AddBtn.setSize(100, 30);

            //오류 발생
           // if (mainFrame.session.getUser().isManager()){
             //   add(AddBtn);
            //}

            RoundedButton[] btnList = new RoundedButton[5];
            for(int i = 0; i < btnList.length; i++) {
                btnList[i] = new RoundedButton();
                //이미지만 남기기
                btnList[i].setBorderPainted(false);
                btnList[i].setFocusPainted(false);
                btnList[i].setContentAreaFilled(false);
                btnList[i].setLocation(50, 90 * i+50);
                btnList[i].setSize(getWidth() - 100, 80);
                btnList[i].setText("Test");

                add(btnList[i]);

            }
        }
    }
}
