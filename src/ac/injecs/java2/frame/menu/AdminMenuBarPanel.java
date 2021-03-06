package ac.injecs.java2.frame.menu;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    public void paintComponent(Graphics g) {
        mainFrame.updateContent();
    }

    public class MenuBarTopLabel extends JPanel {
        public MenuBarTopLabel() {
            setLayout(null);
            JLabel notice = new JLabel("인제 클래스 매니저");
            notice.setFont(InjeFont.Mfont);

            JLabel name = new JLabel("관리자님");
            notice.setBounds(20, 20, 200, 30);
            name.setBounds(20, 60, 200, 30);
            name.setFont(InjeFont.Sfont);

            add(notice);
            add(name);

            setVisible(true);
        }
    }
    public class MenuBarButtons extends JPanel {
        private String resourcePath = "./resources/images/";
        private ImageIcon image1 = new ImageIcon(resourcePath + "대시보드.png");
        private ImageIcon image2 = new ImageIcon(resourcePath + "강의실관리.png");
        private ImageIcon image3 = new ImageIcon(resourcePath + "승인대기현황.png");
        private ImageIcon image4 = new ImageIcon(resourcePath + "공지사항.png");

        private void addButtonImage(ImageIcon image, JButton target) {
            Image img = image.getImage().getScaledInstance(200, 30, Image.SCALE_SMOOTH);
            target.setIcon(new ImageIcon(img));
            target.setBorderPainted(false);
            target.setContentAreaFilled(false);
        }

        public MenuBarButtons() {
            setLayout(new GridLayout(7, 1, 0, 15));

            JButton dashboardButton = new JButton();
            addButtonImage(image1, dashboardButton);

            JButton classReservationButton = new JButton();
            addButtonImage(image2, classReservationButton);

            JButton classCheckButton = new JButton();
            addButtonImage(image3, classCheckButton);

            JButton lectureButton = new JButton();
            addButtonImage(image4, lectureButton);

            add(dashboardButton);
            add(classReservationButton);
            add(classCheckButton);
            add(lectureButton);

            dashboardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.dashBoardPanel);
                    mainFrame.setMode("대시보드");
                }
            });
            classReservationButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.requestLockClassPanel);
                    mainFrame.requestLockClassPanel.update();
                    mainFrame.setMode("강의실관리");
                }
            });
            classCheckButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.admitClassPanel);
                    mainFrame.admitClassPanel.update();
                    mainFrame.setMode("승인대기현황");
                }
            });
            lectureButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.lecture_list);
                    mainFrame.setMode("수업및특강등록");
                }
            });
            setVisible(true);
        }
    }

    public class MenuBarUser extends JPanel {
        JButton logoutButton = new JButton("로그아웃");

        public MenuBarUser() {
            setLayout(new FlowLayout());
            setOpaque(true);
            setForeground(Color.white);

            logoutButton.setFont(InjeFont.Sfont);

            add(logoutButton);

            logoutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    // 로그아웃
                    mainFrame.userMode();
                    mainFrame.setCenterPanel(mainFrame.dashBoardPanel);
                    mainFrame.session.outSession();
                }
            });
            setVisible(true);
        }

        private void setUserButtonVisible(boolean status) {
            if (mainFrame.session.getUser() == null) {
                logoutButton.setVisible(status);
                return;
            }
            if (mainFrame.session.getUser().getName().equals("관리자")) {
                logoutButton.setVisible(true);
            } else {
                logoutButton.setVisible(status);
            }
        }

        public void paintComponent(Graphics g) {
            setUserButtonVisible(mainFrame.session.isLogin);
        }
    }
}
