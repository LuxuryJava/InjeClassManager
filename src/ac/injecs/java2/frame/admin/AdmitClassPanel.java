package ac.injecs.java2.frame.admin;

import ac.injecs.java2.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdmitClassPanel extends JPanel {

    private Main mainFrame;

    public AdmitClassPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 예약 승인");
        title.setBounds(10, 0, 300, 50);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        String[] header = {"예약번호", "예약자", "강의실", "예약시간", "예약상태"};
        String[][] contents = { {"1", "박성훈", "E112", "13:00", "신청"} };

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
}
