package ac.injecs.java2.frame;

import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuBar extends JPanel {
    private int menuBarWidth = 400;

    private MenuBarTopLabel menuBarTopLabel = new MenuBarTopLabel();
    private MenuBarButtons menuBarButtons = new MenuBarButtons();
    private MenuBarUser menuBarUser = new MenuBarUser();

    public MenuBar() {
        setLayout(new GridLayout(8, 1, 10, 0));
        setSize(menuBarWidth, FrameConstant.HEIGHT.getValue()); // 600 size
        setBackground(Color.GRAY);

        // setSize
//        menuBarTopLabel.setBounds(0, 0, menuBarWidth, 200);
//        menuBarButtons.setBounds(0, 200, menuBarWidth, 200);
//        menuBarUser.setBounds(0,400, menuBarWidth, 200);

        // add
        add(menuBarTopLabel);
        add(menuBarButtons);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(menuBarUser);

        setVisible(true);
    }

    public class MenuBarTopLabel extends JPanel {
        public MenuBarTopLabel() {
            setLayout(new GridLayout(2, 1, 10, 10));
            JLabel notice = new JLabel("인제 클래스 매니저");
            JLabel name = new JLabel("어서오세요. 아무개님");

            add(notice);
            add(name);

            setVisible(true);
        }
    }

    public class MenuBarButtons extends JPanel {
        public MenuBarButtons() {
            setLayout(new GridLayout(3, 1, 10, 10));

            JButton dashboardButton = new JButton("대시보드");
            JButton classButton = new JButton("강의실");


            add(dashboardButton);
            add(classButton);

            setVisible(true);
        }
    }

    public class MenuBarUser extends JPanel {
        public MenuBarUser() {
            setLayout(new FlowLayout());

            JButton accountButton = new JButton("계정");
            JButton loginButton = new JButton("로그인");

            add(accountButton);
            add(loginButton);

            setVisible(true);
        }
    }

}
