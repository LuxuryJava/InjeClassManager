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
    public reservation(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 예약", JLabel.CENTER);
        title.setBounds(500, 50, 100, 20);

        JComboBox<String> cb = new JComboBox<String>(unit);
        JLabel text = new JLabel("강의실 선택", JLabel.CENTER);
        text.setBounds(100, 100, 100, 20);
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
            titleText.setBounds(160, 20, 100, 30);

            JLabel unitText = new JLabel("강의실:");
            //JTextField unitField = new JTextField();
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
            setBackground(Color.CYAN);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel titleText = new JLabel("예약 정보");
            titleText.setBounds(170, 20, 100, 30);

            add(titleText);
            setVisible(true);
        }
    }
}
