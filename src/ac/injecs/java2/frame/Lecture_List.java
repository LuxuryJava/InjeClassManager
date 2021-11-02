package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

public class Lecture_List extends JPanel {
    private Main mainFrame;
    private List list = new List();
    public Lecture_List(Main main) {
        mainFrame = main;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("특강 목록", SwingConstants.CENTER);
        title.setFont(new Font("나눔고딕", Font.BOLD, 30));
        add(title, BorderLayout.NORTH);
        add(list);

        setVisible(true);
    }
    public class List extends JPanel {
        public List() {
            setBackground(Color.WHITE);
            setSize(FrameConstant.WIDTH.getValue() - FrameConstant.MENUWIDTH.getValue(), FrameConstant.HEIGHT.getValue());
            setLayout(null);

            RoundedButton[] btnList = new RoundedButton[4];
            for(int i = 0; i < btnList.length; i++) {
                btnList[i] = new RoundedButton();
                //이미지만 남기기
                btnList[i].setBorderPainted(false);
                btnList[i].setFocusPainted(false);
                btnList[i].setContentAreaFilled(false);
                btnList[i].setLocation(10, 140 * i);
                btnList[i].setSize(getWidth() - 40, 100);
            }


            for(int i = 0; i < btnList.length; i++) {
                add(btnList[i]);
            }

        }
    }
}
