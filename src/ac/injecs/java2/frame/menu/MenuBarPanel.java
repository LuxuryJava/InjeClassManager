package ac.injecs.java2.frame.menu;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.entity.User;

import javax.swing.*;
import java.awt.*;

public class MenuBarPanel extends JPanel {
    protected Main mainFrame;
    protected int menuBarWidth = FrameConstant.MENUWIDTH.getValue();

    public MenuBarPanel(Main main){
        this.mainFrame = main;
        this.setBackground(new Color(0xFFFFFF));
    }

    public class MenuBarTopLabel extends JPanel {
        JLabel name =  new JLabel("어서오세요.");
        public MenuBarTopLabel() {
            setLayout(null);
            JLabel notice = new JLabel("인제 클래스 매니저");

            notice.setBounds(20, 20, 200, 30);
            name.setBounds(20, 60, 200, 30);

            notice.setFont(InjeFont.Mfont);
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
}

