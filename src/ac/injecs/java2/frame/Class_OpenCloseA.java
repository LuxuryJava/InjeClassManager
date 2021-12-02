package ac.injecs.java2.frame;

 import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Class_OpenCloseA extends JPanel {
	private Main mainFrame;
	private ImageIcon[] image = { new ImageIcon("images/lock.png"), new ImageIcon("images/unlock.png") };
	private JButton btn[] = new JButton[6];
	private String[] strArr = { "A111", "A112", "A113", "A211", "A212", "A213" };
	private Room rm[]=new Room[6];

	public Class_OpenCloseA(Main main) {
		mainFrame = main;
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		JLabel title = new JLabel("강의실 개방 여부", SwingConstants.CENTER);
		title.setFont(new Font("나눔고딕", Font.BOLD, 30));
		add(title, BorderLayout.NORTH);
		classP panel = new classP();
		add(panel, BorderLayout.CENTER);
	}

	public class classP extends JPanel {
		public classP() {
			setBackground(Color.WHITE);
			setLayout(new GridLayout(2, 3, 0, 0));
			for (int i = 0; i < 6; i++) {
				rm[i] = mainFrame.repository.getRoom(strArr[i]);

				if (rm[i].getdoorOpen()) {
					btn[i] = new JButton(strArr[i], image[1]);
				} else {
					btn[i] = new JButton(strArr[i], image[0]);
				}
				String str=strArr[i];
				String rInfo = rm[i].getRoomInfo();
				boolean dOpen = rm[i].getdoorOpen();
				btn[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {	
						Door door = new Door.Builder().setuno(mainFrame.session.getUser().getId()).setrinfo(rInfo).setdoorOpen(dOpen).build();
						mainFrame.repository.insertDoor(door);
						mainFrame.repository.roomupdate(mainFrame.repository.getRoom(rInfo));
					}	
				});
				
				btn[i].setContentAreaFilled(false);
				btn[i].setBorderPainted(false);
				
				add(btn[i]);
			}

		}
	}
	
	// 아래 코드 관리자가 개방,폐쇄함에 따라 이미지 변경
	public void changeImg(String str, int n) {
		for (int i = 0; i < btn.length; i++) {
			if (strArr[i] == str) {
				if (n == 0)
					btn[i].setIcon(image[n]);
				else
					btn[i].setIcon(image[n]);
			}
		}
	}

}
