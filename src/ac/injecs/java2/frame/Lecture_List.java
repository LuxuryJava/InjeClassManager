package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;

public class Lecture_List extends JPanel {
    private Main mainFrame;
    private List list = new List();
    public Lecture_List(Main main) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("특강 목록", SwingConstants.CENTER);
        title.setFont(new Font("나눔고딕", Font.BOLD, 30));
        add(title, BorderLayout.NORTH);
        add(list);
        setVisible(true);
    }
    public class List extends JPanel {
        public List() {
            ImageIcon[] image = { new ImageIcon("images/lectures1.png"), new ImageIcon("images/lectures1.png"),
                    new ImageIcon("images/lectures1.png"), new ImageIcon("images/lectures1.png")};
            JButton[] btnList = {new JButton(image[0]), new JButton(image[1]), new JButton(image[2]), new JButton(image[3])};

            setLayout(new GridLayout(4, 1, 0, 0));

            for(int i = 0; i < image.length; i++) {
                add(btnList[i]);
                //이미지만 남기기
                btnList[i].setBorderPainted(false);
                btnList[i].setFocusPainted(false);
                btnList[i].setContentAreaFilled(false);
            }

        }
    }
}
