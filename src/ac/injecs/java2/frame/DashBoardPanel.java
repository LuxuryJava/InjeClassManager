package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;
import java.util.Timer;

public class DashBoardPanel extends JPanel {
    private Main mainFrame;

    public DashBoardPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);
        BoxPanel boxPanel = new BoxPanel();
        boxPanel.setBounds(0, 80, FrameConstant.WIDTH.getValue(), 200);

        JLabel title = new JLabel("대시보드");
        title.setBounds(0, 0, 100, 30);

        JLabel updateText = new JLabel("최근 업데이트 : " + LocalDate.now());
        updateText.setBounds(0, 40, 300, 30);

        add(title);
        add(updateText);
        add(boxPanel);

        setVisible(true);
    }

    public class BoxPanel extends JPanel{
        public BoxPanel(){
            setLayout(new GridLayout(1, 4, 10, 10));

            JLabel text2 = new JLabel("예약된 강의실");
            JLabel reserClassText = new JLabel("23");

            add(text2);
            add(reserClassText);

            setVisible(true);
        }
    }

    public class NoticeBoxPanel extends JPanel{

    }
}
