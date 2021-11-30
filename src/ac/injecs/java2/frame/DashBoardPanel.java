package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.constant.FrameConstant;
import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.Room;
import ac.injecs.java2.entity.User;
import com.mysql.cj.util.StringUtils;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.Vector;

public class DashBoardPanel extends JPanel {
    private Main mainFrame;
    private int boxWidth = 150;
    private int boxHeight = 80;
    private int boxWidthGap = 120;

    private Vector<String> emptyClass = new Vector<>();
    private Vector<String> realtimeClass = new Vector<>();
    private Vector<String> notices = new Vector<>();
    //    private Vector<String> notices = {"공지사항입니다", "2021.09.23(목)", "강의실관련 공지사항", "2021.11.01(일)"};

    List<Room> rooms;

    BoxPanel boxPanel1;
    BoxPanel boxPanel2;
    BoxPanel boxPanel3;
    BoxPanel boxPanel4;

    public DashBoardPanel(Main main) {
        this.mainFrame = main;
        setLayout(null);
        int width = FrameConstant.WIDTH.getValue() - FrameConstant.MENUWIDTH.getValue();
        setSize(width, 600);
        setOpaque(true);

        setBackground(Color.WHITE);

        rooms = mainFrame.repository.findRoomAll();
        // 초기 데이터 설정
        getNotificationData();
        getDatas();
        getReservationData();

        JLabel title = new JLabel("대시보드");
        title.setBounds(10, 0, 300, 50);
        title.setFont(InjeFont.XLfont);


        JLabel updateText = new JLabel("최근 업데이트 : " + LocalDate.now());
        updateText.setFont(InjeFont.PSfont);
        updateText.setBounds(12, 40, 300, 30);


        boxPanel1 = new BoxPanel("총 강의실", "NULL", new Color(0x071F6));
        boxPanel1.setBounds(50, 80, boxWidth, boxHeight);
        boxPanel1.setValueText(String.valueOf(rooms.size()));
        boxPanel2 = new BoxPanel("예약된 강의실", "NULL", new Color(0x071F6));
        boxPanel2.setBounds(50 + boxWidthGap * 2, 80, boxWidth, boxHeight);
        boxPanel3 = new BoxPanel("사용중 강의실", "NULL", new Color(0xFF6C2D));
        boxPanel3.setBounds(50 + boxWidthGap * 4, 80, boxWidth, boxHeight);
        boxPanel4 = new BoxPanel("남은 강의실", "NULL", new Color(0xC12503));
        boxPanel4.setBounds(50 + boxWidthGap * 6, 80, boxWidth, boxHeight);

        NoticeBoxPanel noticeBoxPanel1 = new NoticeBoxPanel("비어있는 강의실", emptyClass, 300, 170);
        noticeBoxPanel1.setBounds(70, 190, 300, 170);
        NoticeBoxPanel noticeBoxPanel3 = new NoticeBoxPanel("공지사항", notices, 300, 170);
        noticeBoxPanel3.setBounds(70, 370, 300, 170);

        noticeBoxPanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.setCenterPanel(mainFrame.lecture_list);
            }
        });

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

    private void clearDatas(){
        notices.clear();
        emptyClass.clear();
        rooms.clear();
    }

    private void getNotificationData(){
        List<Notice> noticeAll = mainFrame.repository.findNoticeAll();
        for (int i = 0; i < noticeAll.size(); i++){
            notices.add(noticeAll.get(i).getTitle());
        }
    }

    private void getReservationData(){
        List<ResInfo> reservationAll = mainFrame.repository.findReservationAll();
        for (int i = 0; i < reservationAll.size(); i++){
            ResInfo resInfo = reservationAll.get(i);
            if (resInfo == null) {
                continue;
            }

            if (resInfo.getaccept()) {
                User user= mainFrame.repository.findUserById(String.valueOf(resInfo.getuno())).get();
                String showResInfo = user.getId().substring(2, 4)
                        + "-" + user.getName()
                        + " " + user.getDepartment()
                        + " " + resInfo.getrinfo()
                        + " " + resInfo.getusetime();

                realtimeClass.add(showResInfo);
            }
        }
    }


    private void getDatas(){
        // 모든 강의실 가져오기
        for (Room room : rooms) {
            //System.out.println(room);
            // 빈 강의실 지정
            if (room.getroomUsing() == false) {
                emptyClass.add(room.getRoomInfo());
            }
        }
    }

    public void paintComponent(Graphics graphics) {
        clearDatas();
        getDatas();
        getNotificationData();
        getReservationData();
    }

    public class BoxPanel extends JPanel{
        JLabel titleText;
        JLabel valueText;

        public BoxPanel(String title, String value, Color color){
            setLayout(null);
            setBackground(color);

            titleText = new JLabel(title);
            titleText.setForeground(Color.WHITE);
            titleText.setFont(InjeFont.PSfont);

            valueText = new JLabel(value);
            valueText.setForeground(Color.WHITE);
            valueText.setFont(InjeFont.Lfont);

            titleText.setBounds(5, 5, 100, 50);
            valueText.setBounds(50, 30, 100, 50);
            add(titleText);
            add(valueText);

            setVisible(true);
        }

        public void setValueText(String valueText){
            this.valueText.setText(valueText);
        }

    }

    // 공지사항
    public class NoticeBoxPanel extends JPanel{

        public NoticeBoxPanel(String title, Vector<String> values, int width, int height) {
            LineBorder lineBorder = new LineBorder(Color.BLACK, 2, true);
            setLayout(null);
            setBackground(Color.WHITE);

            // 타이틀 설정
            JLabel text = new JLabel(title);
            text.setBounds(10, 10, width, 20);
            text.setFont(InjeFont.Mfont);
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
                    label.setFont(InjeFont.PSfont);
                    label.setForeground(Color.BLACK);

                    return label;
                }
            });

            add(list);
            add(text);
            setBorder(lineBorder);
            setVisible(true);


            // 공지사항 마우스 클릭 이벤트
            if (title.equals("공지사항")) {
                list.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        mainFrame.setCenterPanel(mainFrame.lecture_list);
                    }
                });
            }

        }
    }
}
