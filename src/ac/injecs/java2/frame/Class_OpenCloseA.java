package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Class_OpenCloseA extends JPanel {
	private Main mainFrame;
	private ImageIcon[] image = { new ImageIcon("images/lock.png"), new ImageIcon("images/unlock.png") };
	private JButton btn[] = new JButton[6];
	private String[] strArr = { "A111", "A112", "A113", "A211", "A212", "A213" };
	private Room rm[] = new Room[6];

	String rInfo;
	boolean dOpen;

	public Class_OpenCloseA(Main main) {
		mainFrame = main;
		setLayout(null);
		setBackground(Color.WHITE);

		JLabel title = new JLabel("강의실 개방 여부");
		title.setBounds(390, 0, 600, 35);
		title.setFont(new Font("나눔고딕", Font.BOLD, 30));

		for (int i = 0; i < 6; i++) {
			rm[i] = mainFrame.repository.getRoom(strArr[i]);
			rInfo = rm[i].getRoomInfo();
			dOpen = rm[i].getdoorOpen();

			if (rm[i].getdoorOpen()) { // Open
				btn[i] = new JButton(strArr[i], image[1]);
			} else { // Close
				btn[i] = new JButton(strArr[i], image[0]);
			}

			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton selectRoom = (JButton) e.getSource();

					Door door = new Door.Builder()
							.setuno(mainFrame.session.getUser().getId())
							.setrinfo(selectRoom.getText())
							.setdoorOpen(dOpen)
							.build();
					mainFrame.repository.insertDoor(door);
					// mainFrame.repository.roomupdate(mainFrame.repository.getRoom(rInfo));
				}
			});

			btn[i].setContentAreaFilled(false);
			btn[i].setBorderPainted(false);

			if (i < 3) {
				btn[i].setBounds(140 + (i * 300), 150, 150, 100);
			} else if (i >= 3) {
				btn[i].setBounds(140 + ((i - 3) * 300), 360, 150, 100);
			}
			add(btn[i]);
		}


		add(title);
	}

	public void updateContent() {
		// 개방 여부에 따라 이미지를 변경하면됨.
		List<Room> roomAll = mainFrame.repository.findRoomAll();
		for (int i = 0; i < roomAll.size(); i++){ // 총 강의실 개수 6개
			Room find = roomAll.get(i);	// btn Array와 roomAll은 매핑

			if (find.getdoorOpen()) {
				btn[i].setIcon(image[1]);
			} else {
				btn[i].setIcon(image[0]);
			}

		}
	}
}
