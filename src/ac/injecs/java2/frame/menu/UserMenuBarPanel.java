package ac.injecs.java2.frame.menu;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.entity.Student;
import ac.injecs.java2.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserMenuBarPanel extends MenuBarPanel {

    public UserMenuBarPanel(Main main) {
        super(main);
        setLayout(null);
        setBounds(0, 0, menuBarWidth, FrameConstant.HEIGHT.getValue());
        setOpaque(true);

        // add
        MenuBarTopLabel menuBarTopLabel = new MenuBarTopLabel();
        menuBarTopLabel.setOpaque(true);
        menuBarTopLabel.setBackground(Color.WHITE);
        MenuBarButtons menuBarButtons = new MenuBarButtons();
        menuBarButtons.setOpaque(true);
        menuBarButtons.setBackground(Color.WHITE);

        MenuBarUser menuBarUser = new MenuBarUser();
        menuBarUser.setOpaque(true);
        menuBarUser.setBackground(Color.WHITE);


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

    public void paintComponent(Graphics g){
        mainFrame.updateContent();
    }

    public class MenuBarTopLabel extends JPanel {
        JLabel name;
        public MenuBarTopLabel() {
            setLayout(null);
            JLabel notice = new JLabel("인제 클래스 매니저");
            notice.setFont(InjeFont.Mfont);

            name = new JLabel("어서오세요.");
            notice.setBounds(20, 20, 200, 30);
            name.setBounds(20, 60, 200, 30);
            name.setFont(InjeFont.Sfont);

            add(notice);
            add(name);

            setVisible(true);
        }

        private void profile(){
            if(mainFrame.session.isLogin){
                User user = mainFrame.session.getUser();
                name.setText("어서오세요 " + user.getName() + " 님");
            }else
            {
                name.setText("어서오세요");
            }
        }

        public void paintComponent(Graphics g) {
            profile();
        }
    }

    public class MenuBarButtons extends JPanel {
        private String resourcePath = "./resources/images/";
        private ImageIcon image1 = new ImageIcon(resourcePath + "대시보드.png");
        private ImageIcon image2 = new ImageIcon(resourcePath + "강의실예약.png");
        private ImageIcon image3 = new ImageIcon(resourcePath + "강의실조회.png");
        private ImageIcon image4 = new ImageIcon(resourcePath + "강의실개방.png");
        private ImageIcon image5 = new ImageIcon(resourcePath + "특강.png");

        private void addButtonImage(ImageIcon image, JButton target){
            Image img = image.getImage().getScaledInstance(200, 40, Image.SCALE_SMOOTH);
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

            JButton classStateButton = new JButton();
            addButtonImage(image4, classStateButton);

            JButton lectureButton = new JButton();
            addButtonImage(image5, lectureButton);

            add(dashboardButton);
            add(classReservationButton);
            add(classCheckButton);
            add(classStateButton);
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
                    mainFrame.setCenterPanel(mainFrame.selectDongPanel);
                    mainFrame.selectDongPanel.title.setText("강의실 예약");

                    mainFrame.setMode("예약");
                }
            });
            classCheckButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.checkClass_day);
                    mainFrame.setMode("조희");
                }
            });
            classStateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.selectDongPanel);
                    mainFrame.selectDongPanel.title.setText("강의실 개방");
                    mainFrame.setMode("개방");
                }
            });
            lectureButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.lecture_list);
                    mainFrame.setMode("특강");
                }
            });

            setVisible(true);
        }
    }

    public class MenuBarUser extends JPanel {
        JButton signButton = new JButton("회원가입");
        JButton loginButton = new JButton("로그인");
        JButton accountButton = new JButton("계정");
        JButton logoutButton = new JButton("로그아웃");

        public MenuBarUser() {
            setLayout(new FlowLayout());
            setOpaque(true);
            setForeground(Color.WHITE);
//            JButton accountButton = new JButton("계정");

//            add(accountButton);
            signButton.setFont(InjeFont.Sfont);
            loginButton.setFont(InjeFont.Sfont);
            accountButton.setFont(InjeFont.Sfont);
            logoutButton.setFont(InjeFont.Sfont);

            add(loginButton);
            add(signButton);
            add(accountButton);
            add(logoutButton);

            signButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.signPanel);
                }
            });
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.loginPanel);
                }
            });

            accountButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.setCenterPanel(mainFrame.userInfoPanel);
                }
            });

            logoutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    mainFrame.session.outSession();
                    mainFrame.setCenterPanel(mainFrame.dashBoardPanel);
                    repaint();
                }
            });

            setVisible(true);
        }

        private void setUserButtonVisible(boolean status){
            if (mainFrame.session.getUser() == null) {
                accountButton.setVisible(status);
                logoutButton.setVisible(status);
                loginButton.setVisible(!status);
                signButton.setVisible(!status);
                return;
            }
            if (mainFrame.session.getUser().getName().equals("관리자")) {
                accountButton.setVisible(false);
                logoutButton.setVisible(true);
                loginButton.setVisible(false);
                signButton.setVisible(false);
            }
            else{
                accountButton.setVisible(status);
                logoutButton.setVisible(status);
                loginButton.setVisible(!status);
                signButton.setVisible(!status);
            }
        }


        public void paintComponent(Graphics g){
            setUserButtonVisible(mainFrame.session.isLogin);
        }
    }

}
