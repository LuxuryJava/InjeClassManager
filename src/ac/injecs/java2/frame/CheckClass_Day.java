package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.User;

import java.awt.*;
import javax.swing.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public class CheckClass_Day extends JPanel {
    private Main mainFrame;
    private checkWeekly checkW = new checkWeekly();

    public CheckClass_Day(Main main) {
        mainFrame = main;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("강의실 예약 조회", SwingConstants.CENTER);
        title.setFont(InjeFont.XLfont);

        add(title, BorderLayout.NORTH);
        add(checkW, BorderLayout.CENTER);

        setVisible(true);
    }

    public void updateContent(){
        checkW.updateContent();
    }

    public class checkWeekly extends JPanel {
        WeekReservationPanel[] weekReservationPanels;

        public checkWeekly() {
            setBackground(Color.WHITE);
            setLayout(null);

            JLabel[] weekNames = {
                    new JLabel("일"),
                    new JLabel("월"),
                    new JLabel("화"),
                    new JLabel("수"),
                    new JLabel("목"),
                    new JLabel("금"),
                    new JLabel("토")
            };

            DayOfWeek dayOfWeek = LocalDateTime.now().getDayOfWeek();
            int dayOfWeekNumber = dayOfWeek.getValue() - 1;

            weekNames[dayOfWeekNumber].setForeground(Color.MAGENTA);
            weekNames[0].setForeground(Color.RED);
            weekNames[6].setForeground(Color.BLUE);

            weekReservationPanels = new WeekReservationPanel[7];
            // 배치
            for (int i = 0 ; i < weekNames.length; i++){
                weekNames[i].setFont(InjeFont.PXLfont);
                weekReservationPanels[i] = new WeekReservationPanel();
            }
            weekNames[dayOfWeekNumber].setFont(InjeFont.XLfont);

            weekNames[0].setBounds(100, 10, 150, 50);
            weekReservationPanels[0].setBounds(50, 60, 150, 150);
            weekNames[1].setBounds(350, 10, 150, 50);
            weekReservationPanels[1].setBounds(300, 60, 150, 150);
            weekNames[2].setBounds(600, 10, 150, 50);
            weekReservationPanels[2].setBounds(550, 60, 150, 150);
            weekNames[3].setBounds(850, 10, 150, 50);
            weekReservationPanels[3].setBounds(800, 60, 150, 150);
            weekNames[4].setBounds(250, 250, 150, 50);
            weekReservationPanels[4].setBounds(200, 300, 150, 200);
            weekNames[5].setBounds(500, 250, 150, 50);
            weekReservationPanels[5].setBounds(450, 300, 150, 200);
            weekNames[6].setBounds(750, 250, 150, 50);
            weekReservationPanels[6].setBounds(700, 300, 150, 200);

            for(int i = 0; i < weekNames.length; i++) {
                add(weekNames[i]);
                add(weekReservationPanels[i]);
            }
            setVisible(true);
        }

        // 승인된 모든 예약 정보 가져옴
        public Vector<ResInfo> getAcceptReservation(){
            List<ResInfo> reservationAll = mainFrame.repository.findReservationAll();

            if (reservationAll == null) {
                return null;
            }
            Vector<ResInfo> acceptAll = new Vector<>();

            for (int i =0 ; i < reservationAll.size(); i++){
                ResInfo resInfo = reservationAll.get(i);
                if(resInfo.getaccept())
                    acceptAll.add(resInfo);
            }
            return acceptAll;
        }

        public int DayToInt(String day){
            int result = 0;
            if (day.equals("일"))
                result = 0;
            else if(day.equals("월"))
                result = 1;
            else if(day.equals("화"))
                result = 2;
            else if(day.equals("수"))
                result = 3;
            else if (day.equals("목"))
                result = 4;
            else if (day.equals("금"))
                result = 5;
            else
                result = 6;
            return result;
        }

        public Vector<ResInfo> getWeekReservationData(int day, Vector<ResInfo> acceptAll){
            Vector<ResInfo> resInfos = new Vector<>();
            for (ResInfo item : acceptAll) {
                // day로 주어진것만 추가한다.
                if (day == DayToInt(item.getuseday())) {
                    resInfos.add(item);
                }
            }
            Collections.sort(resInfos, new Comparator<ResInfo>() {
                @Override
                public int compare(ResInfo a, ResInfo b) {
                    Integer left = Integer.valueOf(a.getusetime().substring(0, 2));
                    Integer  right = Integer.valueOf(b.getusetime().substring(0, 2));
                    return left < right ? -1 : (left == right) ? 0 : 1;
                }
            });
            return resInfos;
        }

        public void updateContent(){
            Vector<ResInfo> acceptReservation = getAcceptReservation();
            if (acceptReservation == null) {
                for (int i = 0; i < 7; i++){
                    weekReservationPanels[i].clearListData();
                }
                return;
            }
            for (int i = 0; i < 7; i++){
                Vector<ResInfo> weekReservationData = getWeekReservationData(i, acceptReservation);
                weekReservationPanels[i].setListData(weekReservationData);
            }
        }

        class WeekReservationPanel extends JPanel {
            JList list;
            public WeekReservationPanel(){
                setLayout(new FlowLayout());
                setBackground(Color.WHITE);

                // 리스트 아이템 추가
                DefaultListModel items = new DefaultListModel();
                list = new JList<>(items);
                list.setEnabled(false); // 클릭 안되게 비활성화
                list.setFixedCellHeight(30);

                list.setCellRenderer(new ListCellRenderer() {
                    @Override
                    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                        JLabel label = new JLabel(value.toString());
                        label.setForeground(Color.BLACK);

                        return label;
                    }
                });

                add(list);

                setVisible(true);
            }

            public void clearListData(){
                DefaultListModel temp = (DefaultListModel) list.getModel();
                temp.removeAllElements();
            }

            public void setListData(Vector<ResInfo> values){
                DefaultListModel temp = (DefaultListModel) list.getModel();
                temp.removeAllElements();
                // 정렬
                for (ResInfo item : values) {
                    User user = mainFrame.repository.findUserById(String.valueOf(item.getuno())).get();
                    String result = item.getusetime() + " " + item.getrinfo() + " " + user.getName();
                    temp.addElement(result);
                }
            }
        }
    }
}
