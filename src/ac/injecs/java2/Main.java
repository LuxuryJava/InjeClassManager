package ac.injecs.java2;

import ac.injecs.java2.frame.MenuBar;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main(){
        setTitle("인제 클래스 매니저");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        add(new MenuBar());

        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
	    new Main();
    }
}
