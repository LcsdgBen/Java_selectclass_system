package system;

import system.login.login_account;

import javax.swing.*;
import java.awt.*;

public class system_run {
    public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static JFrame frame = new JFrame("学生选课系统");
    
    public static void main(String[] args){
        frame_build();
        login_account newx = new login_account();
        newx.run_login();
    }
    public static void frame_build(){
        frame.setSize(400,600);
        frame.setLocation(width/2-frame.getWidth()/2,height/2-frame.getHeight()/2);
        frame.setDefaultCloseOperation(3);
        frame.setBackground(Color.white);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.getContentPane().setLayout(null);
    }
}
