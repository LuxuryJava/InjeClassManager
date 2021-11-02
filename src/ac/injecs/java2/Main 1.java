package ac.injecs.java2;

import ac.injecs.java2.frame.MenuBar;
import ac.injecs.java2.frame.SignPanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame MainFrame;
    public Main(){
        MainFrame = new JFrame();
        MainFrame.setTitle("인제 클래스 매니저");
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = MainFrame.getContentPane();
        c.setLayout(new BorderLayout());

        // 하위 패널 추가
        c.add(BorderLayout.WEST,new MenuBar());

        c.add(BorderLayout.CENTER, new SignPanel());

        MainFrame.setResizable(false);
        MainFrame.setSize(1200, 600);
        MainFrame.setVisible(true);
    }
    public static void main(String[] args) {
	    new Main();
    }
}
