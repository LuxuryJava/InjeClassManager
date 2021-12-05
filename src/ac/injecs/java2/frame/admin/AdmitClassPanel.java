package ac.injecs.java2.frame.admin;

import ac.injecs.java2.Main;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class AdmitClassPanel extends JPanel {
    private Main mainFrame;
    Vector<ResInfo> ri = null;
    String[] header = { "학번", "강의실", "예약 요일", "사용 인원", "예약시간", "사용 목적", "예약상태" };
    DefaultTableModel model = new DefaultTableModel(null, header);
    JTable table;

    static String uno, room, memcnt, day, time, purpose, status;

    public AdmitClassPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 예약 승인");
        title.setBounds(10, 0, 300, 50);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(200, 80, 600, 400);

        JButton btn = new JButton("예약 승인/거부");
        btn.setBounds(550, 500, 140, 40);
        add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean accept = Boolean.parseBoolean(String.valueOf(model.getValueAt(table.getSelectedRow(), 6)));
                ResInfo newData = new ResInfo(
                        Integer.valueOf((String)model.getValueAt(table.getSelectedRow(), 0)),
                        String.valueOf(model.getValueAt(table.getSelectedRow(), 1)),
                        String.valueOf(model.getValueAt(table.getSelectedRow(), 2)),
                        Integer.valueOf((String)model.getValueAt(table.getSelectedRow(), 3)),
                        String.valueOf(model.getValueAt(table.getSelectedRow(), 4)),
                        String.valueOf(model.getValueAt(table.getSelectedRow(), 5)),
                        !accept
                );
                mainFrame.repository.setResinfoAccept(newData);
                update();
            }
        });

        JButton delBtn = new JButton("삭 제");
        delBtn.setBounds(700, 500, 100, 40);
        add(delBtn);

        delBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ResInfo newData = new ResInfo(
                        Integer.valueOf((String) model.getValueAt(table.getSelectedRow(), 0)),
                        String.valueOf(model.getValueAt(table.getSelectedRow(), 1)),
                        String.valueOf(model.getValueAt(table.getSelectedRow(), 2)),
                        Integer.valueOf((String) model.getValueAt(table.getSelectedRow(), 3)),
                        String.valueOf(model.getValueAt(table.getSelectedRow(), 4)),
                        String.valueOf(model.getValueAt(table.getSelectedRow(), 5)),
                        Boolean.valueOf((String) model.getValueAt(table.getSelectedRow(), 6))
                );
                mainFrame.repository.deleteResinfoByResinfo(newData);
                update();
            }
        });

        add(title);
        add(scrollPane);

        setVisible(true);
    }

    public void update() {
        User user = mainFrame.session.user;
        ri = mainFrame.repository.getResinfo(user.getId());
        model.setNumRows(0);

        for (int i = 0; i < ri.size(); i++) {
            uno = Integer.toString(ri.get(i).getuno());
            room = ri.get(i).getrinfo();
            day = ri.get(i).getuseday();
            memcnt = Integer.toString(ri.get(i).getmemcnt());
            time = ri.get(i).getusetime();
            purpose = ri.get(i).getpurpose();
            status = Boolean.toString(ri.get(i).getaccept());
            Object[][] contents = { { uno, room, day, memcnt, time, purpose, status } };
            model.addRow(contents[0]);
        }
    }
}