package ac.injecs.java2.frame.admin;

import ac.injecs.java2.Main;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class AdmitClassPanel extends JPanel {
    private Main mainFrame;
    Vector<ResInfo> ri;

    String[] header = {"학번", "강의실", "사용 인원", "예약시간", "사용 목적", "예약상태"};
    String[][] contents = { {"1", "E112", "8", "13:00", "ㅇㅇㅇ", "신청"} };
    String sno;
    String room;
    String mencnt;
    String time;
    String purpose;
    String status;
    
    public AdmitClassPanel(Main main) {
    	
   
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 예약 승인");
        title.setBounds(10, 0, 300, 50);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));


        DefaultTableModel model = new DefaultTableModel(header, 0);
        model.addRow(contents[0]);
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 80, 600, 400);

        add(title);
        add(scrollPane);

        setVisible(true);
    }
    
    public void update() {
    	User user  = mainFrame.session.user;
    	ri = null;
    	ri = mainFrame.repository.getResinfo(user.getId());
    	if(ri.size() == 0) {
    		
    	}
    	
    }
}
