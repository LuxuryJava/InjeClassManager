package ac.injecs.java2;

import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.frame.LoginPanel;
import ac.injecs.java2.frame.MenuBarPanel;
import ac.injecs.java2.frame.SignPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    private JFrame MainFrame;
    private JPanel nowPanel;

    public MenuBarPanel menuBarPanel;
    public SignPanel signPanel;
    public LoginPanel loginPanel;

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
    public void setMenuPanel(MenuBarPanel menuBarPanel) {
        MainFrame.add(menuBarPanel);
        updateContent();
    }

    // 센터 패널 부착
    public void setCenterPanel(JPanel panel) {
        if (nowPanel != null) {
            MainFrame.remove(nowPanel);
        }
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
        main.menuBarPanel = new MenuBarPanel(main); // 의존성 주입
        main.signPanel = new SignPanel(main);
        main.loginPanel = new LoginPanel(main);

        main.setMenuPanel(main.menuBarPanel);

    }
}

/*
    왜 의존성 주입을 할까요? 그 이유는 패널 교체를 할떄 클래스 외부에서 접근하는게 아닌
    생성자 함수에 MainFrame을 넘기면 MainFrame을 의존하게되어 해당 클래스 멤버를 접근할 수 있게됨
    따라서 복잡하지 않게 패널 전환을 가능함.
 */