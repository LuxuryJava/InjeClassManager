package ac.injecs.java2;

import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.controller.StudentController;
import ac.injecs.java2.frame.*;
import ac.injecs.java2.repository.StudentRepository;
import ac.injecs.java2.repository.StudentRepositoryImpl;
import ac.injecs.java2.service.StudentService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    private StudentRepository studentRepository = new StudentRepositoryImpl();
    private StudentService studentService = new StudentService(studentRepository);
    public StudentController studentController = new StudentController(studentService);

    private JFrame MainFrame;
    private JPanel nowPanel;
    private JPanel prevPanel;
    private String mode;

    public DashBoardPanel dashBoardPanel;
    public Admin_MenuBarPanel menuBarPanel;
    public SignPanel signPanel;
    public LoginPanel loginPanel;
    public SelectDongPanel selectDongPanel;
    public Class_OpenCloseA class_openCloseA;
    public Class_OpenCloseB class_openCloseB;
    public Class_OpenCloseC class_openCloseC;
    public CheckClass_Day checkClass_day;
    public CheckClass_Details checkClass_details;
    public Lecture_List lecture_list;
    public reservation reservation;

    // 프레임 초기 설정
    public Main(){
        MainFrame = new JFrame();
        MainFrame.setTitle("인제 클래스 매니저");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainFrame.setLayout(null);

        MainFrame.setResizable(false);
        MainFrame.setSize(1200, 600);
        MainFrame.setVisible(true);
    }

    // 현재 센터를 가지는 패널 지정
    public void setNowPanel(JPanel panel) {
        nowPanel = panel;
        nowPanel.setBackground(Color.WHITE);
        nowPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("센터 좌표 : "+ e.getX() + ", " + e.getY());
            }
        });
    }

    public JPanel getNowPanel(){
        return nowPanel;
    }

    // 사이드 메뉴 부착
    public void setMenuPanel(Admin_MenuBarPanel menuBarPanel) {
        MainFrame.add(menuBarPanel);
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

    // 센터 패널 부착
    public void setCenterPanel(JPanel panel) {
        if (nowPanel != null) {
            MainFrame.remove(nowPanel);
        }
        setPrevPanel(nowPanel);
        setNowPanel(panel);
        int width = FrameConstant.WIDTH.getValue() - FrameConstant.MENUWIDTH.getValue();
        panel.setBounds(FrameConstant.MENUWIDTH.getValue(), 0, width, 600);
        MainFrame.add(panel);
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
        //main.menuBarPanel = new User_MenuBarPanel(main); // 의존성 주입
        main.menuBarPanel = new Admin_MenuBarPanel(main);
        main.signPanel = new SignPanel(main);
        main.loginPanel = new LoginPanel(main);
        main.selectDongPanel = new SelectDongPanel(main);
        main.class_openCloseA = new Class_OpenCloseA(main);
        main.class_openCloseB = new Class_OpenCloseB(main);
        main.class_openCloseC = new Class_OpenCloseC(main);
        main.checkClass_day = new CheckClass_Day(main);
        main.checkClass_details = new CheckClass_Details(main);
        main.lecture_list = new Lecture_List(main);
        main.reservation = new reservation(main);

        main.setMenuPanel(main.menuBarPanel);
        //main.setCenterPanel(main.dashBoardPanel);
        main.setCenterPanel(new Notice(main));
    }
}