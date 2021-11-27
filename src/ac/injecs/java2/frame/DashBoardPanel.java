package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.constant.FrameConstant;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;
import java.util.Timer;
import java.util.Vector;

public class DashBoardPanel extends JPanel {
    private Main mainFrame;
    private int boxWidth = 150;
    private int boxHeight = 80;
    private int boxWidthGap = 120;

    private String[] emptyClass = {"E325", "C202", "J101", "E101", "E112"};
    private String[] realtimeClass = {"18-박성훈 컴퓨터공학부 입실 E312 오후 03:04", "학번-이름 학과 상태 장소 시간"};
    private String[] notices = {"공지사항입니다 2021.09.23(목)", "강의실관련 공지사항 2021.11.01(일)"};
    //    private Vector<String> notices = {"공지사항입니다", "2021.09.23(목)", "강의실관련 공지사항", "2021.11.01(일)"};

    BoxPanel boxPanel1;
    BoxPanel boxPanel2;
    BoxPanel boxPanel3;
    BoxPanel boxPanel4;

    public DashBoardPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);

        setOpaque(true);
        setBackground(Color.RED);

        JLabel title = new JLabel("대시보드");
        title.setBounds(10, 0, 300, 50);
        title.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        JLabel updateText = new JLabel("최근 업데이트 : " + LocalDate.now());
        updateText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
        updateText.setBounds(12, 40, 300, 30);

        BoxPanel boxPanel1 = new BoxPanel("총 강의실", "23", new Color(0x071F6));
        boxPanel1.setBounds(50, 80, boxWidth, boxHeight);
        BoxPanel boxPanel2 = new BoxPanel("예약된 강의실", "23", new Color(0x071F6));
        boxPanel2.setBounds(50 + boxWidthGap * 2, 80, boxWidth, boxHeight);
        BoxPanel boxPanel3 = new BoxPanel("사용중 강의실", "3", new Color(0xFF6C2D));
        boxPanel3.setBounds(50 + boxWidthGap * 4, 80, boxWidth, boxHeight);
        BoxPanel boxPanel4 = new BoxPanel("남은 강의실", "40", new Color(0xC12503));
        boxPanel4.setBounds(50 + boxWidthGap * 6, 80, boxWidth, boxHeight);

        NoticeBoxPanel noticeBoxPanel1 = new NoticeBoxPanel("비어있는 강의실", emptyClass, 300, 170);
        noticeBoxPanel1.setBounds(70, 190, 300, 170);
        NoticeBoxPanel noticeBoxPanel3 = new NoticeBoxPanel("공지사항", notices, 300, 170);
        noticeBoxPanel3.setBounds(70, 370, 300, 170);
        NoticeBoxPanel noticeBoxPanel2 = new NoticeBoxPanel("실시간 강의실 기록", realtimeClass, 500, 350);
        noticeBoxPanel2.setBounds(390, 190, 500, 350);

        add(title);
        add(updateText);
        add(boxPanel1);
        add(boxPanel2);
        add(boxPanel3);
        add(boxPanel4);
        add(noticeBoxPanel1);
        add(noticeBoxPanel2);
        add(noticeBoxPanel3);

        setVisible(true);
    }

    public void paintComponent(Graphics graphics) {

    }

    public class BoxPanel extends JPanel{
        JLabel titleText;
        JLabel valueText;

        public BoxPanel(String title, String value, Color color){
            setLayout(null);
            setBackground(color);

            JLabel titleText = new JLabel(title);
            titleText.setForeground(Color.WHITE);
            titleText.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

            JLabel valueText = new JLabel(value);
            valueText.setForeground(Color.WHITE);
            valueText.setFont(new Font("맑은 고딕", Font.PLAIN, 25));

            titleText.setBounds(5, 5, 100, 50);
            valueText.setBounds(50, 30, 100, 50);
            add(titleText);
            add(valueText);

            setVisible(true);
        }
    }

    // 공지사항
    public class NoticeBoxPanel extends JPanel{

        public NoticeBoxPanel(String title, String[] values, int width, int height) {
            LineBorder lineBorder = new LineBorder(Color.BLACK, 2, true);
            setLayout(null);
            setBackground(Color.WHITE);

            // 타이틀 설정
            JLabel text = new JLabel(title);
            text.setBounds(10, 10, width, 20);
            text.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
            text.setForeground(Color.BLACK);

            // 리스트 아이템 추가
            DefaultListModel items = new DefaultListModel();
            for (String item : values) {
                items.addElement(item);
            }
            // x 좌표 기준 정렬
            int x = width/2 - 30;
            // 리스트 설정
            JList list = new JList<>(items);
            list.setEnabled(false); // 클릭 안되게 비활성화
            if (title.indexOf("실") != -1) {
                x = 90;
            } else if (title.indexOf("공") != -1) {
                x = 30;
            }
            list.setBounds(x, 35, width - 10 - x, height - 50);
            list.setFixedCellHeight(30);

            // 리스트 모양 설정
            list.setCellRenderer(new ListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index,
                                                              boolean isSelected, boolean cellHasFocus) {
                    JLabel label = new JLabel(value.toString());
                    label.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
                    label.setForeground(Color.BLACK);

                    return label;
                }
            });

            add(list);
            add(text);
            setBorder(lineBorder);
            setVisible(true);
        }
    }
}
