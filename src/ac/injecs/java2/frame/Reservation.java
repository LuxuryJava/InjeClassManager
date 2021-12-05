package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import ac.injecs.java2.entity.User;

public class Reservation extends JPanel {
    static JTextField unitField = new JTextField();
    private Main mainFrame;
    private String[] unit = new String[6];
    private JButton bt = new JButton("확인");
    private List<Room> rooms;
    private User user;

    JTextField nameField = new JTextField("아무개");
    JTextField numField = new JTextField();
    JTextField purposeField = new JTextField();
    JTextField acceptField = new JTextField();

    private String[] day = {"일", "월", "화", "수", "목", "금", "토"};
    private String[] time = {"09:00 ~ 09:50", "10:00 ~ 10:50", "11:00 ~ 11:50", "12:00 ~ 12:50",
            "13:00 ~ 13:50", "14:00 ~ 14:50", "15:00 ~ 15:50", "16:00 ~ 16:50", "17:00 ~ 17:50",
            "18:00 ~ 18:50", "19:00 ~ 19:50", "20:00 ~ 20:50", "21:00 ~ 21:50", "22:00 ~ 22:50",
            "23:00 ~ 23:50"};
    private JComboBox<String> Daycb = new JComboBox<String>(day);
    private JComboBox<String> Timecb = new JComboBox<String>(time);

    private InfoBox infobox;
    private ResBox resbox;

    public Reservation(Main main) {
        this.mainFrame = main;
        setLayout(null);
        user = mainFrame.session.getUser();

        JLabel title = new JLabel("강의실 예약", JLabel.CENTER);
        title.setBounds(400, 50, 300, 25);
        title.setFont(InjeFont.Lfont);

        JLabel text = new JLabel("강의실 선택", JLabel.CENTER);

        // 강의실 DB 가져오기
        rooms = mainFrame.repository.findRoomAll();
        for (int i = 0; i < rooms.size(); i++) {
            Room item = rooms.get(i);
            unit[i] = item.getRoomInfo();
        }

        JComboBox<String> cb = new JComboBox<String>(unit);

        text.setBounds(50, 120, 150, 20);
        title.setBounds(400, 50, 200, 30);
        cb.setBounds(200, 120, 150, 20);
        bt.setBounds(830, 480, 70, 40);

        text.setFont(InjeFont.Mfont);
        bt.setFont(InjeFont.Sfont);

        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResInfo res = new ResInfo(Integer.parseInt(nameField.getText()), cb.getSelectedItem().toString(),Daycb.getSelectedItem().toString() ,
                        Integer.parseInt(numField.getText()), Timecb.getSelectedItem().toString(), purposeField.getText(), Boolean.parseBoolean(acceptField.getText()));

                // 이미 예약된 건지 확인
                String resText = cb.getSelectedItem().toString();
                String useTime = Timecb.getSelectedItem().toString();
                String useDay = Daycb.getSelectedItem().toString();
                List<ResInfo> reservationByUseTime = mainFrame.repository.findReservationByUseTime(useTime);

               if(rooms.get(cb.getSelectedIndex()).getroomPeople() <  Integer.parseInt(numField.getText())){
                    JOptionPane.showMessageDialog(null, "최대 인원을 초과하였습니다.", "MESSAGE", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (reservationByUseTime != null) {
                    for (ResInfo resInfo : reservationByUseTime) {
                        if (resInfo.getaccept()) {
                            if (resInfo.getuseday().equals(useDay) && resInfo.getusetime().equals(useTime)) {
                                String message = "[" + useTime +"] " + resText + "\n이미 예약된 강의실입니다.";
                                JOptionPane.showMessageDialog(null, message, "MESSAGE", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                        }
                        else {
                            if (resInfo.getuseday().equals(useDay) && resInfo.getusetime().equals(useTime)) {
                                String message = "[" + useTime + "] " + resText + "\n해당시간대에 이미 예약 신청하셨습니다.";
                                JOptionPane.showMessageDialog(null, message, "MESSAGE", JOptionPane.WARNING_MESSAGE);
                                return;
                            }
                        }
                    }
                }
                mainFrame.repository.insertres(res);
                JOptionPane.showMessageDialog(null, "예약 요청이 완료되었습니다!", "MESSAGE", JOptionPane.WARNING_MESSAGE);
            }
        });

        infobox = new InfoBox();
        infobox.setBounds(70, 170, 400, 300);
        resbox = new ResBox();
        resbox.setBounds(500, 170, 400, 300);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cb = (JComboBox<String>) e.getSource();
                int index = cb.getSelectedIndex(); // 선택중인 위치
                unitField.setText(unit[index]);
                String procjetor = rooms.get(index).gethasProjector() ? "여" : "부";

                infobox.beamField.setText(procjetor);
                infobox.numField.setText(String.valueOf(rooms.get(index).getroomPeople()));
            }
        });

        add(title);
        add(cb);
        add(text);
        add(bt);
        add(infobox);
        add(resbox);

        setResInfoData();
        setVisible(true);
    }

    private void setResInfoData(){
        int index = Daycb.getSelectedIndex(); // 선택중인 위치
        unitField.setText(unit[index]);
        String procjetor = rooms.get(index).gethasProjector() ? "여" : "부";

        infobox.beamField.setText(procjetor);
        infobox.numField.setText(String.valueOf(rooms.get(index).getroomPeople()));
    }

    public class InfoBox extends JPanel {
        private int textStartY = 100;
        private int textWidth = 100;
        private int textHeight = 30;
        private int fieldWidth = 150;

        private JTextField beamField;
        private JTextField numField;

        public InfoBox() {
            setLayout(null);
            setBackground(new Color(0x4FDAE4));
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel titleText = new JLabel("강의실 정보");
            titleText.setFont(InjeFont.Mfont);
            titleText.setBounds(150, 20, 250, 30);

            JLabel unitText = new JLabel("강의실:");
            unitText.setBounds(160, 20, 100, 30);

            JLabel beamText = new JLabel("프로젝터 여부:");
            beamField = new JTextField();
            JLabel numText = new JLabel("최대 수용 가능 인원:");
            numField = new JTextField();

            unitText.setBounds(60, textStartY, textWidth, textHeight);
            unitField.setBounds(80 + textWidth, textStartY, fieldWidth, textHeight);

            beamText.setBounds(60, textStartY + 40, textWidth, textHeight);
            beamField.setBounds(80 + textWidth, textStartY + 40, fieldWidth, textHeight);

            numText.setBounds(60, textStartY + 80, 110, textHeight);
            numField.setBounds(80 + textWidth, textStartY + 80, fieldWidth, textHeight);

            numText.setHorizontalAlignment(SwingConstants.RIGHT);
            unitText.setHorizontalAlignment(SwingConstants.RIGHT);
            beamText.setHorizontalAlignment(SwingConstants.RIGHT);

            unitText.setFont(InjeFont.Sfont);
            beamText.setFont(InjeFont.Sfont);
            numText.setFont(new Font("나눔고딕", Font.BOLD, 12));

            unitField.setEnabled(false);
            beamField.setEnabled(false);
            numField.setEnabled(false);

            add(titleText);
            add(unitText);
            add(unitField);
            add(beamText);
            add(beamField);
            add(numText);
            add(numField);
            setVisible(true);
        }
    }

    public class ResBox extends JPanel {
        private int textStartY = 100;
        private int textWidth = 100;
        private int textHeight = 30;
        private int fieldWidth = 150;

        public ResBox() {
            setLayout(null);
            setBackground(new Color(0x4FDAE4));
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel titleText = new JLabel("예약 정보");

            titleText.setFont(InjeFont.Mfont);
            titleText.setBounds(170, 20, 100, 30);

            JLabel nameText = new JLabel("ID(이름):");
            JLabel numText = new JLabel("이용 예정 인원:");
            JLabel dayText = new JLabel("이용 요일:");
            JLabel timeText = new JLabel("이용 시간:");
            JLabel purposeText = new JLabel("이용 목적:");

            nameText.setBounds(60, textStartY - 20, textWidth, textHeight);
            nameField.setBounds(80 + textWidth, textStartY - 20, fieldWidth, textHeight);
            numText.setBounds(60, textStartY + 20, textWidth, textHeight);
            numField.setBounds(80 + textWidth, textStartY + 20, fieldWidth, textHeight);
            dayText.setBounds(60, textStartY + 60, textWidth, textHeight);
            Daycb.setBounds(80 + textWidth, textStartY + 60, fieldWidth, textHeight);
            timeText.setBounds(60, textStartY + 100, textWidth, textHeight);
            Timecb.setBounds(80 + textWidth, textStartY + 100, fieldWidth, textHeight);
            purposeText.setBounds(60, textStartY + 140, textWidth, textHeight);
            purposeField.setBounds(80 + textWidth, textStartY + 140, fieldWidth, textHeight);
            titleText.setBounds(170, 20, 100, 30);

            nameText.setHorizontalAlignment(SwingConstants.RIGHT);
            numText.setHorizontalAlignment(SwingConstants.RIGHT);
            dayText.setHorizontalAlignment(SwingConstants.RIGHT);
            timeText.setHorizontalAlignment(SwingConstants.RIGHT);
            purposeText.setHorizontalAlignment((SwingConstants.RIGHT));

            nameText.setFont(InjeFont.Sfont);
            numText.setFont(InjeFont.Sfont);
            dayText.setFont(InjeFont.Sfont);
            timeText.setFont(InjeFont.Sfont);
            purposeText.setFont(InjeFont.Sfont);

            nameField.setEnabled(false);

            add(nameText);
            add(nameField);
            add(numText);
            add(numField);
            add(dayText);
            add(Daycb);
            add(timeText);
            add(Timecb);
            add(purposeText);
            add(purposeField);
            add(titleText);

            setVisible(true);
        }
    }

    public void setid(String id) {
        nameField.setText(id);
    }
}