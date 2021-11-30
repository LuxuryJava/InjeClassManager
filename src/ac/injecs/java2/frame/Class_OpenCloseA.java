package ac.injecs.java2.frame;

import ac.injecs.java2.Main;

import javax.swing.*;
import java.awt.*;

public class Class_OpenCloseA extends JPanel {
	private Main mainFrame;
	public Class_OpenCloseA(Main main) {
		setLayout(new BorderLayout());
		JLabel title = new JLabel("강의실 개방 여부", SwingConstants.CENTER);
		title.setFont(new Font("나눔고딕", Font.BOLD, 30));
		add(title, BorderLayout.NORTH);
		classP panel = new classP();
		add(panel, BorderLayout.CENTER);
	}
	public class classP extends JPanel {
		public classP() {
			ImageIcon[] image = { new ImageIcon("images/classopenclose.png"),
					new ImageIcon("images/classopenclose.png"), new ImageIcon("images/classopenclose.png"),
					new ImageIcon("images/classopenclose.png"), new ImageIcon("images/classopenclose.png"),
					new ImageIcon("images/classopenclose.png") };
			JLabel[] label = { new JLabel("A101",image[0], SwingConstants.CENTER), new JLabel("A102", image[1], SwingConstants.CENTER),
					new JLabel("A103", image[2], SwingConstants.CENTER), new JLabel("A201", image[3], SwingConstants.CENTER),
					new JLabel("A202", image[4], SwingConstants.CENTER), new JLabel("A203", image[5], SwingConstants.CENTER)};

			setLayout(new GridLayout(2, 3, 0, 0 ));
			for(int i = 0; i < image.length; i++) {
				add(label[i]);
			}
		}
	}
}
