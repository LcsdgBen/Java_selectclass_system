package system.login;

import UI_SELF.BORDER;
import UI_SELF.font;
import system.mainMenu.main_menu;
import system.system_run;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Timer;
import java.util.TimerTask;

public class login_account {

    private BORDER login_border = new BORDER();//设置login的BORDER
    private font login_font = new font();//设置login的font
    private JTextField input_account = new JTextField("");//设置login的账号输入框
    private JPasswordField input_password = new JPasswordField("");//设置login的密码输入框
    private JButton login_button = new JButton();//设置登入按钮
    private JLabel log_fail = new JLabel("账号或密码错误");//账号密码错误提示
    private Timer timer = new Timer();//定时器设置

    //login主执行函数
    public void run_login(){
        set_logo();//设置logo标志
        set_inputBackground();//设置输入背景框
        set_inputaccount();//设置输入账号编辑框
        set_inputpassword();//设置输入密码框
        set_loginbutton();//设置登录按钮
        set_logfail();//设置错误提示
    }

    //输入账号框背景
    public void set_inputBackground(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/back.png").getImage().
                getScaledInstance(300,50,Image.SCALE_SMOOTH));
        JLabel account_background = new JLabel();
        JLabel password_background = new JLabel();
        account_background.setIcon(img);
        password_background.setIcon(img);
        account_background.setBorder(login_border.login_background);
        password_background.setBorder(login_border.login_background);
        system_run.frame.getContentPane().add(account_background,1,0);
        system_run.frame.getContentPane().add(password_background,1,0);
        account_background.setBounds(system_run.frame.getWidth()/2-150,230,300,50);
        password_background.setBounds(system_run.frame.getWidth()/2-150,310,300,50);
        Icon img2 = new ImageIcon(new ImageIcon("src/meterial/zhanghao.png").getImage().
                getScaledInstance(30,30,Image.SCALE_SMOOTH));
        Icon img3 = new ImageIcon(new ImageIcon("src/meterial/mima.png").getImage().
                getScaledInstance(30,30,Image.SCALE_SMOOTH));
        JLabel icon_account = new JLabel(img2);
        JLabel icon_password = new JLabel(img3);
        icon_account.setBorder(login_border.login_background);
        icon_password.setBorder(login_border.login_background);
        system_run.frame.getContentPane().add(icon_account,1,0);
        system_run.frame.getContentPane().add(icon_password,1,0);
        icon_account.setBounds(70,239,30,30);
        icon_password.setBounds(70,319,30,30);
    }

    //logo
    public void set_logo(){
        Icon icon = new ImageIcon( new ImageIcon("src/meterial/logo.png").getImage().getScaledInstance(300,73,Image.SCALE_SMOOTH));
        JLabel logo = new JLabel(icon);
        logo.setSize(300,73);
        system_run.frame.getContentPane().add(logo,2,0);
        logo.setBounds(system_run.frame.getWidth()/2-logo.getWidth()/2,80,logo.getWidth(),logo.getHeight());
    }

    //设置输入账号框
    public void set_inputaccount() {
        input_account.setSize(200, 40);
        system_run.frame.getContentPane().add(input_account, 2, 0);
        input_account.setBounds(system_run.frame.getWidth() / 2 - input_account.getWidth() / 2 + 20,
                235, input_account.getWidth(), input_account.getHeight());
        input_account.setBackground(new Color(245,245,250));
        input_account.setBorder(login_border.login_input);
        input_account.setFont(login_font.login_input);
        input_account.setText("请输入账号");
        input_account.setForeground(Color.GRAY);
        input_account.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                if ( input_account.getText().equals("请输入账号")){
                    input_account.setText("");
                    input_account.setForeground(Color.black);
                }

            }

            @Override
            public void focusLost(FocusEvent arg0) {
                // TODO Auto-generated method stub
                if ( input_account.getText().equals("")){
                    input_account.setText("请输入账号");
                    input_account.setForeground(Color.gray);
                }

            }
        });
    }

    //密码输入框
    public void set_inputpassword() {
        input_password.setSize(200, 40);
        system_run.frame.getContentPane().add(input_password, 2, 0);
        input_password.setBounds(system_run.frame.getWidth() / 2 - input_account.getWidth() / 2 + 20,
                315, input_account.getWidth(), input_account.getHeight());
        input_password.setBackground(new Color(245,245,250));
        input_password.setBorder(login_border.login_input);
        input_password.setFont(login_font.login_input);
        input_password.setText("请输入密码");
        input_password.setEchoChar('\0');
        input_password.setForeground(Color.GRAY);
        input_password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent arg0) {
                // TODO Auto-generated method stub
                if ( new String(input_password.getPassword()).equals("请输入密码")){
                    input_password.setText("");
                    input_password.setForeground(Color.black);
                    input_password.setEchoChar('*');
                }

            }
            @Override
            public void focusLost(FocusEvent arg0) {
                // TODO Auto-generated method stub
                if ( new String(input_password.getPassword()).equals("")){
                    input_password.setText("请输入密码");
                    input_password.setForeground(Color.GRAY);
                    input_password.setEchoChar('\0');
                }

            }
        });
    }

    //设置登入错误
    public void set_logfail(){
        log_fail.setSize(100,50);
        system_run.frame.getContentPane().add(log_fail,2,0);
        log_fail.setBounds(155,480,log_fail.getWidth(),log_fail.getHeight());
        log_fail.setForeground(Color.RED);
        log_fail.setVisible(false);
    }

    //登入按钮设置
    public void set_loginbutton(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/login.png").getImage().
                getScaledInstance(300,50,Image.SCALE_SMOOTH));
        JLabel login_info = new JLabel("登录");
        login_info.setForeground(Color.white);
        login_button.setSize(300,50);
        login_button.setIcon(img);
        system_run.frame.getContentPane().add(login_button,2,0);
        login_button.setBounds(system_run.frame.getWidth()/2-login_button.getWidth()/2,
                410,login_button.getWidth(),login_button.getHeight());
        login_button.setBorder(login_border.login_button);
        login_button.setBackground(null);
        system_run.frame.getContentPane().add(login_info,3, 0);
        login_info.setFont(login_font.mune_logout);
        login_info.setBounds(178,408,100,50);
        login_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account_id = input_account.getText();
                String account_password = new String(input_password.getPassword());
                login_mysql check = new login_mysql();
                if(check.find_id(account_id,account_password)){
                    system_run.frame.getContentPane().removeAll();
                    system_run.frame.repaint();
                    main_menu new_login = new main_menu(account_id);
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            new_login.run();
                        }
                    };
                    timer.schedule(task,100);
                }else{
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            log_fail.setVisible(false);
                        }
                    };
                    log_fail.setVisible(true);
                    timer.schedule(task,2000);
                }
            }
        });
    }
}
