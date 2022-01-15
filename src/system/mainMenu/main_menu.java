package system.mainMenu;

import UI_SELF.BORDER;
import UI_SELF.font;
import system.dropClass.drop_class;
import system.login.login_account;
import system.queryInfo.query_info;
import system.selectClass.select_class;
import system.selfInfo.self_information;
import system.system_run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class main_menu {
    private String account ;//学号
    private font mune_font = new font();//主菜单font
    private BORDER mune_border = new BORDER();//主菜单BORDER
    private Timer timer = new Timer();//定时器配置
    public main_menu(String naccount){
        this.account = naccount;
    }

    //主菜单主执行程序
    public void run(){
        set_logo();
        set_select_class_button();
        set_checkout_class_button();
        set_quary_class_button();
        set_modify_info();
        set_logout();
    }

    //logo的配置
    public void set_logo(){
        Icon icon = new ImageIcon( new ImageIcon("src/meterial/logo.png").getImage().getScaledInstance(300,73, Image.SCALE_SMOOTH));
        JLabel logo = new JLabel(icon);
        logo.setSize(300,73);
        system_run.frame.getContentPane().add(logo,2,0);
        logo.setBounds(system_run.frame.getWidth()/2-logo.getWidth()/2,30,logo.getWidth(),logo.getHeight());
    }

    //选课按钮的设置
    public void set_select_class_button(){
        Icon icon = new ImageIcon( new ImageIcon("src/meterial/courseSelection.png").getImage().
                getScaledInstance(70,70, Image.SCALE_SMOOTH));
        JButton select_button = new JButton();
        select_button.setIcon(icon);
        select_button.setSize(100,100);
        select_button.setBorder(mune_border.mune_icon);
        system_run.frame.getContentPane().add(select_button,2,0);
        select_button.setBounds(75,140,select_button.getWidth(),select_button.getHeight());
        JLabel select_info = new JLabel("选课");
        system_run.frame.getContentPane().add(select_info,2,0);
        select_info.setSize(100,40);
        select_info.setBounds(105,225,select_info.getWidth(),select_info.getHeight());
        select_info.setFont(mune_font.mune_info);
        String id = account;
        select_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system_run.frame.getContentPane().removeAll();
                system_run.frame.repaint();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        system_run.frame.setSize(system_run.width,system_run.height-100);
                        system_run.frame.setLocation(0,0);
                        select_class newx = new select_class(id);
                        newx.select_class_run();
                    }
                };
                timer.schedule(task,300);
            }
        });
    }

    //退课按钮的设置
    public void set_checkout_class_button(){
        Icon icon = new ImageIcon( new ImageIcon("src/meterial/deselection.png").getImage().
                getScaledInstance(65,65, Image.SCALE_SMOOTH));
        JButton checkout_button = new JButton();
        checkout_button.setIcon(icon);
        checkout_button.setSize(100,100);
        checkout_button.setBorder(mune_border.mune_icon);
        system_run.frame.getContentPane().add(checkout_button,2,0);
        checkout_button.setBounds(230,140,checkout_button.getWidth(),checkout_button.getHeight());
        JLabel checkout_info = new JLabel("退课");
        system_run.frame.getContentPane().add(checkout_info,2,0);
        checkout_info.setSize(100,40);
        checkout_info.setBounds(260,225,checkout_info.getWidth(),checkout_info.getHeight());
        checkout_info.setFont(mune_font.mune_info);
        String id = account;
        checkout_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system_run.frame.getContentPane().removeAll();
                system_run.frame.repaint();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        system_run.frame.setSize(system_run.width,system_run.height-100);
                        System.out.println(system_run.frame.getWidth());
                        System.out.println(system_run.frame.getHeight());
                        system_run.frame.setLocation(0,0);
                        drop_class newx = new drop_class(id);
                        newx.drop_class_run();
                    }
                };
                timer.schedule(task,300);
            }
        });
    }

    //查询按钮的配置
    public void set_quary_class_button(){
        Icon icon = new ImageIcon( new ImageIcon("src/meterial/query.png").
                getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH));
        JButton quary_button = new JButton();
        quary_button.setIcon(icon);
        quary_button.setSize(100,100);
        quary_button.setBorder(mune_border.mune_icon);
        system_run.frame.getContentPane().add(quary_button,2,0);
        quary_button.setBounds(75,280,quary_button.getWidth(),quary_button.getHeight());
        JLabel query_info = new JLabel("查询");
        system_run.frame.getContentPane().add(query_info,2,0);
        query_info.setSize(100,40);
        query_info.setBounds(105,365,query_info.getWidth(),query_info.getHeight());
        query_info.setFont(mune_font.mune_info);
        quary_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system_run.frame.getContentPane().removeAll();
                system_run.frame.repaint();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        system.queryInfo.query_info x = new query_info(account);
                        x.set_interface();
                    }
                };
                timer.schedule(task,100);
            }
        });
    }

    //个人信息按钮的配置
    public void set_modify_info(){
        Icon icon = new ImageIcon( new ImageIcon("src/meterial/personalInformation.png").
                getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH));
        JButton modify_button = new JButton();
        modify_button.setIcon(icon);
        modify_button.setSize(100,100);
        modify_button.setBorder(mune_border.mune_icon);
        system_run.frame.getContentPane().add(modify_button,2,0);
        modify_button.setBounds(230,280,modify_button.getWidth(),modify_button.getHeight());
        JLabel query_info = new JLabel("个人信息");
        system_run.frame.getContentPane().add(query_info,2,0);
        query_info.setSize(100,40);
        query_info.setBounds(245,365,query_info.getWidth(),query_info.getHeight());
        query_info.setFont(mune_font.mune_info);
        modify_button.addActionListener(new ActionListener() {
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

    //退出登入的配置
    public void set_logout(){
        Icon icon = new ImageIcon( new ImageIcon("src/meterial/logout.png").
                getImage().getScaledInstance(250,45, Image.SCALE_SMOOTH));
        JButton logout = new JButton();
        logout.setIcon(icon);
        system_run.frame.getContentPane().add(logout,2,0);
        logout.setFocusPainted(false);
        logout.setBorder(mune_border.mune_icon);
        logout.setBounds(80,450,250,45);
        JLabel logout_info = new JLabel("退出登录");
        system_run.frame.getContentPane().add(logout_info,2,0);
        logout_info.setFont(mune_font.mune_logout);
        logout_info.setBounds(165,455,200,30);
        logout_info.setForeground(Color.white);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system_run.frame.getContentPane().removeAll();
                system_run.frame.repaint();
                login_account x = new login_account();
                x.run_login();
            }
        });
    }
}
