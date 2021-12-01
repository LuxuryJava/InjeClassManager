package ac.injecs.java2.frame.admin;

import ac.injecs.java2.Main;
import ac.injecs.java2.entity.ResInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class RequestLockClassPanel extends JPanel {
    private Main mainFrame;
    Vector<ResInfo> ri = null;
    String[] header = {"요청번호", "요청자", "강의실", "요청내용", "잠금상태"};
    DefaultTableModel model = new DefaultTableModel(null, header);
    JTable table;
    
    public RequestLockClassPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 개방/잠금 요청");
        title.setBounds(10, 0, 600, 50);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        String[][] contents = {
                {"1", "박성훈", "E112", "개방", "잠금"},
                {"2", "정민영", "E113", "잠금", "개방"}
        };

        model.addRow(contents[0]);
        model.addRow(contents[1]);
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 80, 600, 400);

        add(title);
        add(scrollPane);

        setVisible(true);
    }
    
    public void update() {
    	
    }

}
