package ac.injecs.java2.frame;

import ac.injecs.java2.Main;

import javax.swing.*;
import java.awt.*;

public class SelectDongPanel extends JPanel {
    private Main mainFrame;

    public SelectDongPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 예약");
        title.setFont(new Font("나눔고딕", Font.PLAIN, 20));
        title.setBounds(480, 20, 150, 30);

        RoundedButton aButton = new RoundedButton("A동");
        aButton.setBounds(200, 200, 150, 150);
        aButton.setFont(new Font("나눔고딕", Font.PLAIN, 30));

        RoundedButton bButton = new RoundedButton("B동");
        bButton.setBounds(450, 200, 150, 150);
        bButton.setFont(new Font("나눔고딕", Font.PLAIN, 30));

        RoundedButton cButton = new RoundedButton("C동");
        cButton.setBounds(700, 200, 150, 150);
        cButton.setFont(new Font("나눔고딕", Font.PLAIN, 30));

        add(cButton);
        add(bButton);
        add(aButton);
        add(title);

        setVisible(true);
    }
}
