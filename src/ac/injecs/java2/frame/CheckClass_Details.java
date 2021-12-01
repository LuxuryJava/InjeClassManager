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
	InjeFont font;
    
    private Main mainFrame;
    JLabel nameLabel = new JLabel("");
    JLabel classLabel = new JLabel("");
    JLabel dayLabel = new JLabel("");
    JLabel numLabel = new JLabel("");
    JLabel timeLabel = new JLabel("");
    JLabel purposeLabel = new JLabel("");
    JLabel acceptLabel = new JLabel("");
    
    Vector<ResInfo> ri;
    int cnt;
    public void setInfo() {
            User user = mainFrame.session.user;
    	    ri=null;
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
    		return;
    	}
    	cnt=0;
    	setField();   	 			
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
    public CheckClass_Details(Main main) {
        this.mainFrame = main;
        setLayout(null);

        JLabel title = new JLabel("강의실 조회", JLabel.CENTER);
        title.setBounds(410, 50, 200, 25);
        title.setFont(font.Lfont);

        DetailBox detailbox = new DetailBox();
        detailbox.setBounds(300, 100, 400, 370);
        
        JButton pre=new JButton("이전");
        JButton next=new JButton("다음");
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
        		
        	}
        	
        	
        });
        cancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mainFrame.repository.deleteres(nameLabel.getText(), classLabel.getText());
        		setInfo();
        		
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
            titleText.setFont(font.Mfont);
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
            
            nameLabel.setFont(font.PSfont);
            classLabel.setFont(font.PSfont);
            dayLabel.setFont(font.PSfont);
            numLabel.setFont(font.PSfont);
            timeLabel.setFont(font.PSfont);
            purposeLabel.setFont(font.PSfont);
            acceptLabel.setFont(font.PMfont);
	
            nameText.setFont(font.Sfont);
            classText.setFont(font.Sfont);
            dayText.setFont(font.Sfont);
            numText.setFont(font.Sfont);
            timeText.setFont(font.Sfont);
            purposeText.setFont(font.Sfont);
            acceptText.setFont(font.Sfont);

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
