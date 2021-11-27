package ac.injecs.java2.frame.menu;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;

public class MenuBarPanel extends JPanel {
    protected Main mainFrame;
    protected int menuBarWidth = FrameConstant.MENUWIDTH.getValue();

    public MenuBarPanel(Main main){
        this.mainFrame = main;
    }
}

