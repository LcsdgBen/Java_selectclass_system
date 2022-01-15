package system.selfInfo;

import UI_SELF.BORDER;
import UI_SELF.font;
import system.system_run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.TimerTask;
import java.util.Timer;

public class passwoed_change {
    private String account;//账号设置
    private font info_font = new font();//修改密码界面font设置
    private BORDER info_border = new BORDER();//修改密码界面BORDER设置
    private JPasswordField password1 = new JPasswordField();//输入新密码1框
    private JPasswordField password2 = new JPasswordField();//输入新密码2框
    private Timer timer = new Timer();//定时器配置
    public passwoed_change(String id){
        this.account = id;
    }

    //主执行程序
    public void set_interface(){
        set_title();
        set_pass1();
        set_pass2();
        set_save();
    }

    //设置标题
    public void set_title(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/title_info.png").getImage().
                getScaledInstance(500,60, Image.SCALE_SMOOTH));
        JLabel title = new JLabel(img);
        system_run.frame.getContentPane().add(title,1,0);
        title.setBounds(-100,0,600,60);
        title.setBorder(info_border.info_title);
        JLabel title_text = new JLabel("修改密码");
        title_text.setSize(100,50);
        system_run.frame.getContentPane().add(title_text,2,0);
        title_text.setBounds(system_run.frame.getWidth()/2-title_text.getWidth()/2+10,5,
                title_text.getWidth(),title_text.getHeight());
        title_text.setFont(info_font.info_title);

        Icon img2 = new ImageIcon(new ImageIcon("src/meterial/info_back.png").getImage().
                getScaledInstance(25,25, Image.SCALE_SMOOTH));
        JButton title_back = new JButton(img2);
        system_run.frame.getContentPane().add(title_back,2,0);
        title_back.setBorder(info_border.info_title);
        title_back.setBounds(15,18,25,25);

        int starty = 103;
        for(int i=1;i<=2;i++){
            JLabel line = new JLabel();
            Icon img3 = new ImageIcon(new ImageIcon("src/meterial/line.png").getImage().
                    getScaledInstance(400,2, Image.SCALE_SMOOTH));
            line.setIcon(img3);
            system_run.frame.getContentPane().add(line,2,0);
            line.setBounds(0,starty,400,2);
            starty+=47;
        }

        title_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system_run.frame.getContentPane().removeAll();
                system_run.frame.repaint();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        self_information x = new self_information(account);
                        x.set_interface();
                    }
                };
                timer.schedule(task,100);
            }
        });
    }

    //密码1框设置
    public void set_pass1(){
        password1.setSize(300, 30);
        system_run.frame.getContentPane().add(password1, 2, 0);
        password1.setBounds(20, 65, password1.getWidth(), password1.getHeight());
        password1.setBackground(new Color(255,255,255));
        password1.setBorder(info_border.info_input);
        password1.setFont(info_font.info_input);
        password1.setText("请输入新密码");
        password1.setEchoChar('\0');
        password1.setForeground(Color.GRAY);
        password1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                if ( new String(password1.getPassword()).equals("请输入新密码")){
                    password1.setText("");
                    password1.setForeground(Color.black);
                    password1.setEchoChar('*');
                }

            }
            @Override
            public void focusLost(FocusEvent arg0) {
                // TODO Auto-generated method stub
                if ( new String(password1.getPassword()).equals("")){
                    password1.setText("请输入新密码");
                    password1.setForeground(Color.GRAY);
                    password1.setEchoChar('\0');
                }

            }
        });
    }

    //密码2框设置
    public void set_pass2(){
        password2.setSize(300, 30);
        system_run.frame.getContentPane().add(password2, 2, 0);
        password2.setBounds(20, 115, password2.getWidth(), password2.getHeight());
        password2.setBackground(new Color(255,255,255));
        password2.setBorder(info_border.info_input);
        password2.setFont(info_font.info_input);
        password2.setText("请再次输入新密码");
        password2.setEchoChar('\0');
        password2.setForeground(Color.GRAY);
        password2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                if ( new String(password2.getPassword()).equals("请再次输入新密码")){
                    password2.setText("");
                    password2.setForeground(Color.black);
                    password2.setEchoChar('*');
                }

            }
            @Override
            public void focusLost(FocusEvent arg0) {
                // TODO Auto-generated method stub
                if ( new String(password2.getPassword()).equals("")){
                    password2.setText("请再次输入新密码");
                    password2.setForeground(Color.GRAY);
                    password2.setEchoChar('\0');
                }

            }
        });
    }

    //完成按钮设置
    public void set_save(){
        JButton save = new JButton("完成");
        system_run.frame.getContentPane().add(save,2,0);
        save.setBorder(info_border.info_title);
        save.setBounds(335,18,50,25);
        save.setFont(info_font.info_save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s1 = new String(password1.getPassword());
                String s2 = new String(password2.getPassword());
                if(s1.equals(s2)){
                    student_mysql.update_password(account,s1);
                    system_run.frame.getContentPane().removeAll();
                    system_run.frame.repaint();
                    self_information x = new self_information(account);
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            x.set_interface();
                        }
                    };
                    timer.schedule(task,100);
                }else{
                    JLabel text = new JLabel("密码不一致");
                    system_run.frame.getContentPane().add(text,2,0);
                    text.setBounds(162,170,80,30);
                    text.setForeground(Color.RED);
                    text.setFont(info_font.info_save);
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            text.setVisible(false);
                        }
                    };
                    timer.schedule(task,2000);
                }
            }
        });
    }
}
