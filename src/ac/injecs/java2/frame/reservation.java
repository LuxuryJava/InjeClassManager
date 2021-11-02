package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reservation extends JPanel{
    private Main mainFrame;
    private String[] unit = {"A111", "A112", "A113", "A211", "A212", "A213"};
    static JTextField unitField = new JTextField();
<<<<<<< HEAD
    static Font Lfont = new Font("나눔고딕", Font.BOLD, 25);
    static Font Mfont = new Font("나눔고딕", Font.BOLD, 20);
    static Font Sfont = new Font("나눔고딕", Font.BOLD, 15);
=======
>>>>>>> be97f7ca9bf4c7dcd9c86fef825187813cd4eb03
    public reservation(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 예약", JLabel.CENTER);
<<<<<<< HEAD
        title.setBounds(400, 50, 200, 25);
        title.setFont(Lfont);

        JComboBox<String> cb = new JComboBox<String>(unit);
        JLabel text = new JLabel("강의실 선택", JLabel.CENTER);
        text.setFont(Mfont);
        text.setBounds(100, 100, 150, 20);
=======
        title.setBounds(500, 50, 100, 20);

        JComboBox<String> cb = new JComboBox<String>(unit);
        JLabel text = new JLabel("강의실 선택", JLabel.CENTER);
        text.setBounds(100, 100, 100, 20);
>>>>>>> be97f7ca9bf4c7dcd9c86fef825187813cd4eb03
        cb.setBounds(250, 100, 100, 20);

        InfoBox infobox = new InfoBox();
        infobox.setBounds(70, 170, 400, 300);
        ResBox resbox = new ResBox();
        resbox.setBounds(500, 170, 400, 300);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> cb = (JComboBox<String>)e.getSource();
                int index = cb.getSelectedIndex();
                unitField.setText(unit[index]);
            }
        });

        add(title);
        add(cb);
        add(text);
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
            setBackground(Color.CYAN);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel titleText = new JLabel("강의실 정보");
<<<<<<< HEAD
            titleText.setFont(Mfont);
            titleText.setBounds(160, 20, 150, 30);

            JLabel unitText = new JLabel("강의실:");
=======
            titleText.setBounds(160, 20, 100, 30);

            JLabel unitText = new JLabel("강의실:");
            //JTextField unitField = new JTextField();
>>>>>>> be97f7ca9bf4c7dcd9c86fef825187813cd4eb03
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

<<<<<<< HEAD
            unitText.setFont(Sfont);
            beamText.setFont(Sfont);
            numText.setFont(new Font("나눔고딕", Font.BOLD, 12));

=======
>>>>>>> be97f7ca9bf4c7dcd9c86fef825187813cd4eb03
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

<<<<<<< HEAD
        private String[] day = {"일", "월", "화", "수", "목", "금", "토"};
        private JComboBox<String> Daycb = new JComboBox<String>(day);
        private String[] time = {"09:00 ~ 09:50", "10:00 ~ 10:50", "11:00 ~ 11:50", "12:00 ~ 12:50",
                "13:00 ~ 13:50", "14:00 ~ 14:50", "15:00 ~ 15:50", "16:00 ~ 16:50", "17:00 ~ 17:50",
                "18:00 ~ 18:50", "19:00 ~ 19:50", "20:00 ~ 20:50", "21:00 ~ 21:50", "22:00 ~ 22:50",
                "23:00 ~ 23:50"};
        private JComboBox<String> Timecb = new JComboBox<String>(time);

=======
>>>>>>> be97f7ca9bf4c7dcd9c86fef825187813cd4eb03
        public ResBox() {
            setLayout(null);
            setBackground(Color.CYAN);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel titleText = new JLabel("예약 정보");
<<<<<<< HEAD
            titleText.setFont(Mfont);
            titleText.setBounds(170, 20, 100, 30);

            JLabel nameText = new JLabel("ID(이름):");
            JTextField nameField = new JTextField("홍길동");
            JLabel numText = new JLabel("이용 예정 인원:");
            JTextField numField = new JTextField();
            JLabel dayText = new JLabel("이용 요일:");
            JLabel timeText = new JLabel("이용 시간:");
            JLabel purposeText = new JLabel("이용 목적:");
            JTextField purposeField = new JTextField();

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

            nameText.setFont(Sfont);
            numText.setFont(Sfont);
            dayText.setFont(Sfont);
            timeText.setFont(Sfont);
            purposeText.setFont(Sfont);

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

=======
            titleText.setBounds(170, 20, 100, 30);

>>>>>>> be97f7ca9bf4c7dcd9c86fef825187813cd4eb03
            add(titleText);
            setVisible(true);
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> be97f7ca9bf4c7dcd9c86fef825187813cd4eb03
