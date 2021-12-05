package ac.injecs.java2;

import ac.injecs.java2.frame.*;
import ac.injecs.java2.config.SessionConfig;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.controller.UserController;
import  ac.injecs.java2.controller.NoticeController;
import ac.injecs.java2.frame.admin.AdmitClassPanel;
import ac.injecs.java2.frame.admin.RequestLockClassPanel;
import ac.injecs.java2.frame.menu.AdminMenuBarPanel;
import ac.injecs.java2.frame.menu.UserMenuBarPanel;
import ac.injecs.java2.frame.user.UserInfoPanel;
import ac.injecs.java2.repository.Repository;
import ac.injecs.java2.service.NoticeService;
import ac.injecs.java2.service.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public Repository repository = new Repository(); // 통합 DB 접근 객체
    public SessionConfig session = new SessionConfig();

    private UserService userService = new UserService(repository);
    public UserController userController = new UserController(userService);

    private NoticeService noticeService = new NoticeService(repository);
    public NoticeController noticeController = new NoticeController(noticeService);

    private JFrame MainFrame;
    private String sno;
    private JPanel nowPanel;
    private JPanel prevPanel;
    private String mode;
 
    public DashBoardPanel dashBoardPanel;
    public AdminMenuBarPanel adminMenuBarPanel;
    public UserMenuBarPanel userMenuBarPanel;
    public SignPanel signPanel;
    public LoginPanel loginPanel;
    public Class_OpenCloseA class_openCloseA;
    public CheckClass_Day checkClass_day;
    public CheckClass_Details checkClass_details;
    public Lecture_List lecture_list;
    public Notice_Add notice_add;
    public Reservation reservation;
    public AdmitClassPanel admitClassPanel;
    public RequestLockClassPanel requestLockClassPanel;
    public UserInfoPanel userInfoPanel;

    // 프레임 초기 설정
    public Main(){
        MainFrame = new JFrame();
        MainFrame.setTitle("인제 클래스 매니저");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainFrame.setBackground(Color.WHITE);
        MainFrame.setLayout(null);

        MainFrame.setResizable(false);
        MainFrame.setSize(1200, 600);
        MainFrame.setVisible(true);
    }

    // 현재 센터를 가지는 패널 지정
    public void setNowPanel(JPanel panel) {
        nowPanel = panel;
    }
    public JPanel getNowPanel(){
        return nowPanel;
    }

    // 사이드 메뉴 부착
    public void setMenuPanel(JPanel menuBarPanel) {
        MainFrame.add(menuBarPanel);
        updateContent();
    }

    public void managerMode(){
        MainFrame.remove(userMenuBarPanel);
        MainFrame.add(adminMenuBarPanel);
        updateContent();
    }

    public void userMode(){
        MainFrame.remove(adminMenuBarPanel);
        MainFrame.add(userMenuBarPanel);
        updateContent();
    }

    public void setPrevPanel(JPanel panel) {
        prevPanel = panel;
    }
    public JPanel getPrevPanel() {
        return prevPanel;
    }

    public void setMode(String mode){
        this.mode = mode;
    }
    public String getMode(){
        return this.mode;
    }

    public void setsno(String sno) {
    	this.sno=sno;
    }
    public String getsno() {
    	return sno;
    }

    // 센터 패널 부착
    public void setCenterPanel(JPanel panel) {
        if (nowPanel != null) {
            MainFrame.remove(nowPanel);
        }

        setPrevPanel(nowPanel);
        setNowPanel(panel);
        int width = FrameConstant.WIDTH.getValue() - FrameConstant.MENUWIDTH.getValue();
        panel.setBounds(FrameConstant.MENUWIDTH.getValue(), 0, width, 600);
        panel.setBackground(Color.WHITE);

        MainFrame.add(panel);
        if (prevPanel != null) {
            if(!prevPanel.equals(nowPanel))
                MainFrame.remove(prevPanel);
        }

        // 업데이트
        if (panel.equals(dashBoardPanel)) {
            dashBoardPanel.updateContent();
        }
        if (panel.equals(reservation)){
            reservation.setid(session.getUser().getId());
            reservation.clearField();
        }
        if(panel.equals(notice_add)){
            notice_add.setNameData();
            notice_add.updateContent();
        }
        if (panel.equals(checkClass_day)) {
            checkClass_day.updateContent();
        }
        if(panel.equals(userInfoPanel)){
            userInfoPanel.updateContent();
        }
        if (panel.equals(class_openCloseA)) {
            class_openCloseA.updateContent();
        }
        if (panel.equals(loginPanel)) {
            loginPanel.fieldFocuse(true);
        }

        updateContent();
    }

    public void updateContent(){
        MainFrame.repaint();
        MainFrame.revalidate();
    }

    public static void main(String[] args) {
        Main main = new Main();
        // 사용자 정의 패널 생성
        main.dashBoardPanel = new DashBoardPanel(main);
        main.userMenuBarPanel = new UserMenuBarPanel(main); // 의존성 주입
        main.adminMenuBarPanel = new AdminMenuBarPanel(main);
        main.signPanel = new SignPanel(main);
        main.loginPanel = new LoginPanel(main);
        main.class_openCloseA = new Class_OpenCloseA(main);
        main.checkClass_day = new CheckClass_Day(main);
        main.checkClass_details = new CheckClass_Details(main);
        main.lecture_list = new Lecture_List(main);
        main.notice_add = new Notice_Add(main);
        main.reservation = new Reservation(main);
        main.admitClassPanel = new AdmitClassPanel(main);
        main.requestLockClassPanel = new RequestLockClassPanel(main);
        main.userInfoPanel = new UserInfoPanel(main);

        main.setCenterPanel(main.dashBoardPanel);
        main.setMenuPanel(main.userMenuBarPanel);
    }
}