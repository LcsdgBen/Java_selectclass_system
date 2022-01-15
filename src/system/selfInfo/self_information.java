package system.selfInfo;

import UI_SELF.BORDER;
import UI_SELF.font;
import system.mainMenu.main_menu;
import system.system_run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class self_information {
    private String account ;//账户账户
    private BORDER info_border = new BORDER();//个人信息界面border
    private font info_font = new font();//个人信息界面font
    public self_information(String stu_id){
        this.account = stu_id;
    }
    private Timer timer = new Timer();//定时器配置

    //主执行函数
    public void set_interface(){
        set_info();
    }

    //内容的配置函数
    public void set_info(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/title_info.png").getImage().
                getScaledInstance(500,60, Image.SCALE_SMOOTH));
        JLabel title = new JLabel(img);
        system_run.frame.getContentPane().add(title,1,0);
        title.setBounds(-100,0,600,60);
        title.setBorder(info_border.info_title);
        JLabel title_text = new JLabel("个人信息");
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
        title_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system_run.frame.getContentPane().removeAll();
                system_run.frame.repaint();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        main_menu x = new main_menu(account);
                        x.run();
                    }
                };
                timer.schedule(task,100);
            }
        });


        int starty = 113;
        for(int i=1;i<=6;i++){
            JLabel line = new JLabel();
            Icon img3 = new ImageIcon(new ImageIcon("src/meterial/line.png").getImage().
                    getScaledInstance(400,2, Image.SCALE_SMOOTH));
            line.setIcon(img3);
            system_run.frame.getContentPane().add(line,2,0);
            line.setBounds(0,starty,400,2);
            starty+=57;
        }
        starty = 70;
        for (int i=1;i<=6;i++){
            JLabel line = new JLabel();
            Icon img3 = getIcon(i);
            line.setIcon(img3);
            system_run.frame.getContentPane().add(line,2,0);
            line.setBounds(20,starty,30,30);
            starty+=57;
        }
        starty = 70;
        String[] list = {"姓名","年级","系别","班级","学号","密码"};
        for (int i=1;i<=6;i++){
            JLabel line = new JLabel(list[i-1]);
            system_run.frame.getContentPane().add(line,2,0);
            line.setBounds(65,starty,100,30);
            starty+=57;
            line.setFont(info_font.info_met);
        }

        JLabel name = new JLabel(student_mysql.find_name(account));
        system_run.frame.getContentPane().add(name,2,0);
        name.setBounds(335,70,100,30);
        name.setFont(info_font.info_met);
        name.setForeground(new Color(0,118,224));

        JLabel grade = new JLabel(student_mysql.find_grade(account));
        system_run.frame.getContentPane().add(grade,2,0);
        grade.setBounds(315,130,100,30);
        grade.setFont(info_font.info_met);
        grade.setForeground(new Color(0,118,224));

        JLabel major = new JLabel(student_mysql.find_major(account));
        system_run.frame.getContentPane().add(major,2,0);
        major.setBounds(310,190,150,30);
        major.setFont(info_font.info_met);
        major.setForeground(new Color(0,118,224));

        JLabel classx = new JLabel(student_mysql.find_class(account));
        system_run.frame.getContentPane().add(classx,2,0);
        classx.setBounds(300,250,150,30);
        classx.setFont(info_font.info_met);
        classx.setForeground(new Color(0,118,224));

        JLabel id = new JLabel(account);
        system_run.frame.getContentPane().add(id,2,0);
        id.setBounds(252,310,150,30);
        id.setFont(info_font.info_met);
        id.setForeground(new Color(0,118,224));

        Icon imgx = new ImageIcon(new ImageIcon("src/meterial/next_mima.png").getImage().
                getScaledInstance(25,25, Image.SCALE_SMOOTH));
        JButton modify_password = new JButton(imgx);
        system_run.frame.getContentPane().add(modify_password,2,0);
        modify_password.setBounds(340,360,30,30);
        modify_password.setBorder(info_border.info_title);
        modify_password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system_run.frame.getContentPane().removeAll();
                system_run.frame.repaint();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        passwoed_change x = new passwoed_change(account);
                        x.set_interface();
                    }
                };
                timer.schedule(task,100);
            }
        });
    }

    //图标配置函数
    public Icon getIcon(int index){
        if(index == 1) return new ImageIcon(new ImageIcon("src/meterial/xingming.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        if(index == 2) return new ImageIcon(new ImageIcon("src/meterial/nianji.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        if(index == 3) return new ImageIcon(new ImageIcon("src/meterial/xueyuan.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        if(index == 4) return new ImageIcon(new ImageIcon("src/meterial/banji.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        if(index == 5) return new ImageIcon(new ImageIcon("src/meterial/zhenshixingming.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        if(index == 6) return new ImageIcon(new ImageIcon("src/meterial/weibiaoti--.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        return null;
    }
}
