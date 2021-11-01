package ac.injecs.java2.class_open;

import ac.injecs.java2.constant.FrameConstant;
import java.awt.*;
import javax.swing.*;

public class class_opencloseA extends JPanel {
	public class_opencloseA() {
		setLayout(new BorderLayout());
		JLabel title = new JLabel("강의실 개방 여부", SwingConstants.CENTER);
		title.setBackground(Color.LIGHT_GRAY);
		title.setFont(new Font("굴림", Font.BOLD, 30));
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
			
			setLayout(new GridLayout(2, 3, 10, 10));
			for(int i = 0; i < image.length; i++) {
				add(label[i]);
			}
		}
	}
}
