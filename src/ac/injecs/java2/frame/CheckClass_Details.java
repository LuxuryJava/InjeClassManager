package ac.injecs.java2.frame;

import ac.injecs.java2.Main;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.User;
import ac.injecs.java2.config.InjeFont;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
public class CheckClass_Details extends JPanel{
    private Main mainFrame;
    JLabel nameLabel = new JLabel("");
    JLabel classLabel = new JLabel("");
    JLabel dayLabel = new JLabel("");
    JLabel numLabel = new JLabel("");
    JLabel timeLabel = new JLabel("");
    JLabel purposeLabel = new JLabel("");
    JLabel acceptLabel = new JLabel("");

    JButton pre;
    JButton next;

    Vector<ResInfo> ri;
    int cnt;
    public boolean setInfo() {
            User user = mainFrame.session.user;
    	    ri = mainFrame.repository.getResinfo(user.getId());
    	    if(ri.size()==0)
    	{
    		nameLabel.setText("");;
    	    classLabel.setText("");
    	    dayLabel.setText("");
    	    numLabel.setText("");
    	    timeLabel.setText("");
    	    purposeLabel.setText("");
    	    acceptLabel.setText("");
    		JOptionPane aa=new JOptionPane();
    		aa.showMessageDialog(null,"예약정보가 없습니다.");
    		mainFrame.setCenterPanel(mainFrame.userInfoPanel);
    		return false;
    	}
    	cnt=0;
    	setField();
    	return true;
    }

	public void setField() {
    	nameLabel.setText(Integer.toString(ri.get(cnt).getuno()));
		classLabel.setText(ri.get(cnt).getrinfo());
		dayLabel.setText(ri.get(cnt).getuseday());
		numLabel.setText(Integer.toString(ri.get(cnt).getmemcnt()));
		timeLabel.setText(ri.get(cnt).getusetime());
		purposeLabel.setText(ri.get(cnt).getpurpose());
		acceptLabel.setText(Boolean.toString(ri.get(cnt).getaccept()));
    }
    // 버튼의 보여짐/안보여짐 결정
    public void setBtn() {
        //System.out.println(ri.size());
        if (ri.size() == 1) {
            pre.setVisible(false);
            next.setVisible(false);
            return;
        }

        if(cnt == 0 ) {
            pre.setVisible(false);
            next.setVisible(true);
        }
        else if(cnt == ri.size() - 1) {
            pre.setVisible(true);
            next.setVisible(false);
        }
        else {
            pre.setVisible(true);
            next.setVisible(true);
        }
    }
    public CheckClass_Details(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 조회", JLabel.CENTER);
        title.setBounds(410, 50, 200, 25);
        title.setFont(InjeFont.Lfont);

        DetailBox detailbox = new DetailBox();
        detailbox.setBounds(300, 100, 400, 370);

        pre  = new JButton("이전");
        next = new JButton("다음");
        JButton cancel=new JButton("예약취소");
        pre.setBounds(300, 512, 70, 30);
        next.setBounds(380, 512, 70, 30);
        cancel.setBounds(600, 512, 100, 30);
        pre.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(ri.size()==0)
        			return;
        		if(cnt==0)
        			return;
        		cnt--;
        		setField();
                setBtn();
        		
        	}

        	
        });
        next.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(ri.size()==0)
        			return;
        		if(cnt==ri.size()-1)
        			return;
        		cnt++;
        		setField();
                setBtn();
        		
        	}
        	
        	
        });
        cancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mainFrame.repository.deleteres(nameLabel.getText(), classLabel.getText());
                JOptionPane.showMessageDialog(null, "예약을 취소하시겠습니까 ?", "MESSAGE", JOptionPane.YES_NO_OPTION);
        		setInfo();
        		setBtn();
        	}


        });
        add(pre);
        add(next);
        add(cancel);

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
            titleText.setFont(InjeFont.Mfont);
            titleText.setBounds(170, 20, 100, 30);

            JLabel nameText = new JLabel("ID(이름):");
            
            JLabel classText = new JLabel("강의실:");
            
            JLabel numText = new JLabel("이용 예정 인원:");
            
            JLabel dayText = new JLabel("이용 요일:");
            
            JLabel timeText = new JLabel("이용 시간:");
            
            JLabel purposeText = new JLabel("이용 목적:");
            
            JLabel acceptText = new JLabel ("승인 여부: ");
            

            nameText.setBounds(60, textStartY -	35, textWidth, textHeight);
            nameLabel.setBounds(80 + textWidth, textStartY - 35, fieldWidth, textHeight);
            classText.setBounds(60, textStartY + 5, textWidth, textHeight);
            classLabel.setBounds(80 + textWidth, textStartY + 5, fieldWidth, textHeight);
            dayText.setBounds(60, textStartY + 85, textWidth, textHeight);
            dayLabel.setBounds(80 + textWidth, textStartY + 85, fieldWidth, textHeight);
            numText.setBounds(60, textStartY + 45, textWidth, textHeight);
            numLabel.setBounds(80 + textWidth, textStartY + 45, fieldWidth, textHeight);
            timeText.setBounds(60, textStartY + 125, textWidth, textHeight);
            timeLabel.setBounds(80 + textWidth, textStartY + 125, fieldWidth, textHeight);
            purposeText.setBounds(60, textStartY + 165, textWidth, textHeight);
            purposeLabel.setBounds(80 + textWidth, textStartY + 165, fieldWidth, textHeight);
            acceptText.setBounds(60, textStartY + 205, textWidth, textHeight);
            acceptLabel.setBounds(80 + textWidth, textStartY + 205, fieldWidth, textHeight);
            
            acceptLabel.setForeground(Color.red);

            nameText.setHorizontalAlignment(SwingConstants.RIGHT);
            classText.setHorizontalAlignment(SwingConstants.RIGHT);
            dayText.setHorizontalAlignment(SwingConstants.RIGHT);
            numText.setHorizontalAlignment(SwingConstants.RIGHT);
            timeText.setHorizontalAlignment(SwingConstants.RIGHT);
            purposeText.setHorizontalAlignment((SwingConstants.RIGHT));
            acceptText.setHorizontalAlignment(SwingConstants.RIGHT);
            
            nameLabel.setFont(InjeFont.PSfont);
            classLabel.setFont(InjeFont.PSfont);
            dayLabel.setFont(InjeFont.PSfont);
            numLabel.setFont(InjeFont.PSfont);
            timeLabel.setFont(InjeFont.PSfont);
            purposeLabel.setFont(InjeFont.PSfont);
            acceptLabel.setFont(InjeFont.PMfont);
	
            nameText.setFont(InjeFont.Sfont);
            classText.setFont(InjeFont.Sfont);
            dayText.setFont(InjeFont.Sfont);
            numText.setFont(InjeFont.Sfont);
            timeText.setFont(InjeFont.Sfont);
            purposeText.setFont(InjeFont.Sfont);
            acceptText.setFont(InjeFont.Sfont);

            add(nameText);
            add(nameLabel);
            add(classText);
            add(classLabel);
            add(dayText);
            add(dayLabel);
            add(numText);
            add(numLabel);
            add(timeText);
            add(timeLabel);
            add(purposeText);
            add(purposeLabel);
            add(acceptText);
            add(acceptLabel);

            add(titleText);
            setVisible(true);
        }
    }
}
