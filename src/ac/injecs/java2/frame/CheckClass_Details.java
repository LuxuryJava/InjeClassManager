package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.entity.ResInfo;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CheckClass_Details extends JPanel{
    
    private Main mainFrame;
    static Font Lfont = new Font("나눔고딕", Font.BOLD, 25);
    static Font Mfont = new Font("나눔고딕", Font.BOLD, 20);
    static Font Sfont = new Font("나눔고딕", Font.BOLD, 15);
    JTextField nameField = new JTextField("");
    JTextField classField = new JTextField("");
    JTextField numField = new JTextField("");
    JTextField dayField = new JTextField("");
    JTextField timeField = new JTextField("");
    JTextField purposeField = new JTextField("");
    public void setInfo() {
    		ResInfo ri=mainFrame.studentRepository.getResinfo(mainFrame.session.user.getId().toString());
    		nameField.setText(Integer.toString(ri.getsno()));
    		classField.setText(ri.getrinfo());
    		numField.setText(Integer.toString(ri.getmemcnt()));
    		dayField.setText(ri.getuseday());
    		timeField.setText(ri.getusetime());
    		purposeField.setText(ri.getpurpose());	
    }
    public CheckClass_Details(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 조회", JLabel.CENTER);
        title.setBounds(420, 50, 200, 25);
        title.setFont(Lfont);

        DetailBox detailbox = new DetailBox();
        detailbox.setBounds(300, 150, 400, 350);

        add(title);
        add(detailbox);
        setVisible(true);

    }
    public class DetailBox extends JPanel {
        private int textStartY = 100;
        private int textWidth = 100;
        private int textHeight = 30;
        private int fieldWidth = 150;

        public DetailBox() {
            setLayout(null);
            setBackground(new Color(0x4FDAE4));
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel titleText = new JLabel("예약 정보");
            titleText.setFont(Mfont);
            titleText.setBounds(170, 20, 100, 30);

            JLabel nameText = new JLabel("ID(이름):");
            
            JLabel classText = new JLabel("강의실:");
            
            JLabel numText = new JLabel("이용 예정 인원:");
            
            JLabel dayText = new JLabel("이용 요일:");
            
            JLabel timeText = new JLabel("이용 시간:");
            
            JLabel purposeText = new JLabel("이용 목적:");
            

            nameText.setBounds(60, textStartY - 20, textWidth, textHeight);
            nameField.setBounds(80 + textWidth, textStartY - 20, fieldWidth, textHeight);
            classText.setBounds(60, textStartY + 20, textWidth, textHeight);
            classField.setBounds(80 + textWidth, textStartY + 20, fieldWidth, textHeight);
            numText.setBounds(60, textStartY + 60, textWidth, textHeight);
            numField.setBounds(80 + textWidth, textStartY + 60, fieldWidth, textHeight);
            dayText.setBounds(60, textStartY + 100, textWidth, textHeight);
            dayField.setBounds(80 + textWidth, textStartY + 100, fieldWidth, textHeight);
            timeText.setBounds(60, textStartY + 140, textWidth, textHeight);
            timeField.setBounds(80 + textWidth, textStartY + 140, fieldWidth, textHeight);
            purposeText.setBounds(60, textStartY + 180, textWidth, textHeight);
            purposeField.setBounds(80 + textWidth, textStartY + 180, fieldWidth, textHeight);

            nameText.setHorizontalAlignment(SwingConstants.RIGHT);
            classText.setHorizontalAlignment(SwingConstants.RIGHT);
            numText.setHorizontalAlignment(SwingConstants.RIGHT);
            dayText.setHorizontalAlignment(SwingConstants.RIGHT);
            timeText.setHorizontalAlignment(SwingConstants.RIGHT);
            purposeText.setHorizontalAlignment((SwingConstants.RIGHT));

            nameText.setFont(Sfont);
            classText.setFont(Sfont);
            numText.setFont(Sfont);
            dayText.setFont(Sfont);
            timeText.setFont(Sfont);
            purposeText.setFont(Sfont);

            nameField.setEnabled(false);
            classField.setEnabled(false);
            numField.setEnabled(false);
            dayField.setEnabled(false);
            timeField.setEnabled(false);
            purposeField.setEnabled(false);

            add(nameText);
            add(classText);
            add(classField);
            add(nameField);
            add(numText);
            add(numField);
            add(dayText);
            add(dayField);
            add(timeText);
            add(timeField);
            add(purposeText);
            add(purposeField);

            add(titleText);
            setVisible(true);
        }
    }
}
