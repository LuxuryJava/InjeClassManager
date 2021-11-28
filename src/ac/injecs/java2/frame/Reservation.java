package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.DBConnect;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ac.injecs.java2.entity.ResInfo;
public class Reservation extends JPanel {
    private Main mainFrame;
    private String[] unit = {"A111", "A112", "A113", "A211", "A212", "A213"};
    private JButton bt = new JButton("확인");
    static JTextField unitField = new JTextField();
    private Student user;
    JTextField nameField = new JTextField("아무개");
    JTextField numField = new JTextField();
    JTextField purposeField = new JTextField();
    private String[] day = {"일", "월", "화", "수", "목", "금", "토"};
    
    private String[] time = {"09:00 ~ 09:50", "10:00 ~ 10:50", "11:00 ~ 11:50", "12:00 ~ 12:50",
            "13:00 ~ 13:50", "14:00 ~ 14:50", "15:00 ~ 15:50", "16:00 ~ 16:50", "17:00 ~ 17:50",
            "18:00 ~ 18:50", "19:00 ~ 19:50", "20:00 ~ 20:50", "21:00 ~ 21:50", "22:00 ~ 22:50",
            "23:00 ~ 23:50"};
    private JComboBox<String> Daycb = new JComboBox<String>(day);
    private JComboBox<String> Timecb = new JComboBox<String>(time);

    public Reservation(Main main) {
        this.mainFrame = main;
        setLayout(null);
        user = (Student) mainFrame.session.getUser();

        JLabel title = new JLabel("강의실 예약", JLabel.CENTER);
        title.setBounds(400, 50, 300, 25);
        title.setFont(InjeFont.Lfont);

        JComboBox<String> cb = new JComboBox<String>(unit);
        JLabel text = new JLabel("강의실 선택", JLabel.CENTER);
        text.setFont(InjeFont.Mfont);
        text.setBounds(50, 120, 150, 20);
        title.setBounds(400, 50, 200, 30);

        cb.setBounds(200, 120, 150, 20);
        bt.setBounds(830, 480, 70, 40);
        bt.setFont(InjeFont.Sfont);
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                ResInfo res=new ResInfo(Integer.parseInt(nameField.getText()), cb.getSelectedItem().toString(), Integer.parseInt(numField.getText()),
                		Daycb.getSelectedItem().toString(), Timecb.getSelectedItem().toString(), purposeField.getText());
                mainFrame.studentRepository.insertres(res);
                
            }
        });

        InfoBox infobox = new InfoBox();
        infobox.setBounds(70, 170, 400, 300);
        ResBox resbox = new ResBox();
        resbox.setBounds(500, 170, 400, 300);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cb = (JComboBox<String>) e.getSource();
                int index = cb.getSelectedIndex();
                unitField.setText(unit[index]);
            }
        });

        add(title);
        add(cb);
        add(text);
        add(bt);
        add(infobox);
        add(resbox);

        setVisible(true);
    }

    public class InfoBox extends JPanel {
        private int textStartY = 100;
        private int textWidth = 100;
        private int textHeight = 30;
        private int fieldWidth = 150;

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
            JTextField beamField = new JTextField("여");
            JLabel numText = new JLabel("최대 수용 가능 인원:");
            JTextField numField = new JTextField("30");

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


            titleText.setBounds(170, 20, 100, 30);

            add(titleText);
            setVisible(true);
        }
    }
    public void setid(String id) {
    	nameField.setText(id);
    }
}