package ac.injecs.java2.frame.menu;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminMenuBarPanel extends MenuBarPanel {

    public AdminMenuBarPanel(Main main) {
        super(main);
        setLayout(null);
        setBounds(0, 0, menuBarWidth, FrameConstant.HEIGHT.getValue());

        MenuBarTopLabel menuBarTopLabel = new MenuBarTopLabel();
        MenuBarButtons menuBarButtons = new MenuBarButtons();
        MenuBarUser menuBarUser = new MenuBarUser();

        menuBarTopLabel.setBounds(0, 0, menuBarWidth, 100);
        menuBarButtons.setBounds(0, 100, menuBarWidth, 400);
        menuBarUser.setBounds(0, 500, menuBarWidth, 60);

        add(menuBarTopLabel);
        add(menuBarButtons);
        add(menuBarUser);

        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("메뉴바 : " + e.getX() + ", " + e.getY());
            }
        });
    }

    public class MenuBarButtons extends JPanel {
        public MenuBarButtons() {
            setLayout(new GridLayout(5, 1, 40, 10));

            JButton dashboardButton = new JButton("대시보드");
            JButton classReservationButton = new JButton("강의실 관리 ");
            JButton classCheckButton = new JButton("승인 대기 현황");
            JButton classStateButton = new JButton("수업 및 특강 등록");
            JButton lectureButton = new JButton("공지사항");

            add(dashboardButton);
            add(classReservationButton);
            add(classCheckButton);
            add(classStateButton);
            add(lectureButton);

            setVisible(true);
        }
    }

    public class MenuBarUser extends JPanel {
        JButton signButton = null;
        JButton logoutButton = null;
        public MenuBarUser() {
            setLayout(new FlowLayout());

//            JButton accountButton = new JButton("계정");
            logoutButton = new JButton("로그아웃");

//            add(accountButton);
            add(logoutButton);

            logoutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    // 로그아웃
                    mainFrame.session.outSession();
                    mainFrame.setMenuPanel();
                    mainFrame.setCenterPanel(mainFrame.dashBoardPanel);
                }
            });

            setVisible(true);
        }

        private void setUserButtonVisible(boolean status){
            if (mainFrame.session.getUser() == null) {
                logoutButton.setVisible(status);
                return;
            }
            if (mainFrame.session.getUser().getName().equals("관리자")) {
                logoutButton.setVisible(true);
            }
            else{
                logoutButton.setVisible(status);
            }
        }

        public void paintComponent(Graphics g){
            setUserButtonVisible(mainFrame.session.isLogin);
        }
    }
}