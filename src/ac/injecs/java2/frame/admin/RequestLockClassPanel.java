package ac.injecs.java2.frame.admin;

import ac.injecs.java2.Main;
import ac.injecs.java2.entity.Door;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RequestLockClassPanel extends JPanel {
    private Main mainFrame;
    Vector<Door> di = null;
    String[] header = {"요청번호", "요청자", "강의실", "요청내용", "잠금상태"};
    DefaultTableModel model = new DefaultTableModel(null, header);
    JTable table;
    
    static String uno, rinfo, request, doorOpen;
    
    public RequestLockClassPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 개방/잠금 요청");
        title.setBounds(10, 0, 600, 50);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 80, 600, 400);
        
        JButton btn = new JButton("요청 승인");
        btn.setBounds(550, 500, 140, 40);
        add(btn);
        
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String uno = String.valueOf(model.getValueAt(table.getSelectedRow(), 1));
                String rinfo = String.valueOf(model.getValueAt(table.getSelectedRow(), 2));
                boolean doorOpen;
                if(String.valueOf(model.getValueAt(table.getSelectedRow(), 4))=="열림") {
                	doorOpen=false;
                }
                else {
                	doorOpen=true;
                }
                Door door = new Door.Builder().setuno(uno).setrinfo(rinfo).setdoorOpen(doorOpen).build(); 
                
                mainFrame.repository.roomupdate(mainFrame.repository.getRoom(rinfo));
                mainFrame.class_openCloseA.update();
                mainFrame.repository.deletedoor(door);                
                
            }
        });

        add(title);
        add(scrollPane);

        setVisible(true);
    }
    
    public void update() {
    	di = mainFrame.repository.getDoorinfo(rinfo);
    	model.setNumRows(0);
    	
    	for(int i = 0; i < di.size(); i++) {
    		uno = di.get(i).getuno();
    		rinfo = di.get(i).getrinfo(); 		
    		if(di.get(i).getdoorOpen()) {
    			request = "잠가주세요";
    			doorOpen = "열림";
    		}
    		else {
    			request = "열어주세요";
    			doorOpen = "잠김";
    		}
    		Object[][] contents = { { i + 1, uno, rinfo, request, doorOpen } };
    		model.addRow(contents[0]);
    	}
    }
}
