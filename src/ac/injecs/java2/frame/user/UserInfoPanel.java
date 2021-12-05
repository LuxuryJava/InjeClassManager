package ac.injecs.java2.frame.user;

import ac.injecs.java2.Main;
import ac.injecs.java2.config.InjeFont;
import ac.injecs.java2.entity.ResInfo;
import ac.injecs.java2.entity.User;

import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;

public class UserInfoPanel extends JPanel {
    Main mainFrame = null;
    JTextField jt[]= new JTextField[5];
    Vector<ResInfo> ri;

    public UserInfoPanel(Main mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(null);
        
        JLabel title = new JLabel("내 정보");
        title.setBounds(10, 0, 300, 50);
        title.setFont(InjeFont.Mfont);       

        JLabel nameText = new JLabel("이름");
        nameText.setBounds(270, 150, 100, 30);
        nameText.setFont(InjeFont.Sfont);

        JLabel idText = new JLabel("학번");
        idText.setBounds(270, 200, 100, 30);
        idText.setFont(InjeFont.Sfont);

        JLabel departText = new JLabel("소속");
        departText.setBounds(270, 250, 100, 30);
        departText.setFont(InjeFont.Sfont);

        JLabel emailText = new JLabel("이메일");
        emailText.setBounds(260, 300, 100, 30);
        emailText.setFont(InjeFont.Sfont);

        JLabel phoneText = new JLabel("전화번호");
        phoneText.setBounds(250, 350, 100, 30);
        phoneText.setFont(InjeFont.Sfont);

        add(title);
        add(nameText);
        add(idText);
        add(departText);
        add(emailText);
        add(phoneText);
        JButton logout=new JButton("로그아웃");
        
        logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mainFrame.session.outSession();
        		mainFrame.setCenterPanel(mainFrame.dashBoardPanel);
        	}        	
        	
        });
        
        JButton resinfo=new JButton("예약정보");
        resinfo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    if(ri == null){
                    mainFrame.checkClass_details.setInfo();
                }
        	    else {
                    if(mainFrame.checkClass_details.setInfo()){
                        mainFrame.checkClass_details.setBtn();
                        mainFrame.setCenterPanel(mainFrame.checkClass_details);
                    }
                }
        	}
        });

        logout.setBounds(773, 508,100,30);
        resinfo.setBounds(663,508,100,30);
        add(logout);
        add(resinfo);

        for(int i=0;i<5;i++) {
        	jt[i]=new JTextField(10);
        	jt[i].setBounds(340,(150+i*50),200,30);
        	add(jt[i]);
        }

        setVisible(true);
    }

    public void update(){
        User user = mainFrame.session.getUser();
        jt[0].setText(user.getName().toString());
        jt[1].setText(user.getId().toString());
        jt[2].setText(user.getDepartment().toString());
        jt[3].setText(user.getEmail().toString());
        jt[4].setText(user.getPhoneNumber().toString());

        JLabel name = new JLabel("");
        name.setBounds(300, 100, 100, 30);
        add(name);
    }

    public void updateContent(){
        ri = mainFrame.repository.getResinfo(mainFrame.session.user.getId());
    }
}
