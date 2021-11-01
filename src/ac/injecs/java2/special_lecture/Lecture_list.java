package ac.injecs.java2.special_lecture;

import ac.injecs.java2.constant.FrameConstant;

import java.awt.*;
import javax.swing.*;

public class Lecture_list extends JPanel {
	private List list = new List();
	public Lecture_list() {
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("특강 목록", SwingConstants.CENTER);
		title.setBackground(Color.LIGHT_GRAY);
		title.setFont(new Font("굴림", Font.BOLD, 30));
		add(title, BorderLayout.NORTH);
		add(list);
		setVisible(true);
	}
	
	public class List extends JPanel {
		public List() {
			ImageIcon[] image = { new ImageIcon("images/lectures1.png"), new ImageIcon("images/lectures2.png"),
					new ImageIcon("images/lectures3.png"), new ImageIcon("images/lectures4.png")};
			JButton[] btnList = {new JButton(image[0]), new JButton(image[1]), new JButton(image[2]), new JButton(image[3])};
			
			setLayout(new GridLayout(4, 1, 10, 10));
			
			for(int i = 0; i < image.length; i++) {
				add(btnList[i]);
				//이미지만 남기기
				btnList[i].setBorderPainted(false);
				btnList[i].setFocusPainted(false);
				btnList[i].setContentAreaFilled(false);
			}
			
		}
	}
	
}

