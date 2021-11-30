package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.entity.*;
import javax.swing.*;
import java.awt.*;

public class Class_OpenCloseA extends JPanel {
	private Main mainFrame;
	private ImageIcon[] image= { new ImageIcon("images/lock.png"),new ImageIcon("images/unlock.jpg") };
	private JLabel label[]= new JLabel[6];
	private String[] strArr= {"A111","A112","A113","A211","A212","A213"};
	private Room rm;
	public Class_OpenCloseA(Main main) {
		mainFrame=main;
		setLayout(new BorderLayout());
		JLabel title = new JLabel("강의실 개방 여부", SwingConstants.CENTER);
		title.setFont(new Font("나눔고딕", Font.BOLD, 30));
		add(title, BorderLayout.NORTH);
		classP panel = new classP();
		add(panel, BorderLayout.CENTER);
	}
	public class classP extends JPanel {
		public classP() {

			setLayout(new GridLayout(2, 3, 0, 0 ));
			for(int i = 0; i < 6; i++) {
				rm=mainFrame.repository.getRoom(strArr[i]);

				if(rm.getdoorOpen()) {
					label[i]=new JLabel(strArr[i],image[1], SwingConstants.CENTER);
				}
				else {
					label[i]=new JLabel(strArr[i],image[0], SwingConstants.CENTER);
				}
				add(label[i]);
			}

		}
	}
	//아래 코드 관리자가 개방,폐쇄함에 따라 이미지 변경
	public void changeImg(String str,int n) {
		for(int i=0;i<label.length;i++) {
			if(strArr[i]==str) {
				if(n==0)
					label[i].setIcon(image[n]);
				else
					label[i].setIcon(image[n]);
			}
		}
	}

}
