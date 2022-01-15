package system.dropClass;

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

public class drop_class {
    private String account;//学生账号
    private int class_versionnum;//一定可以获取课程数量
    private BORDER drop_border = new BORDER();//退课UI的border
    private font drop_font = new font();//退课的UI的font
    private Timer timer = new Timer();//定时器设置
    private JLabel drop[] = new JLabel[1010];//课程栏课程序号设置
    private JLabel exc_id[] = new JLabel[1010];//课程栏背景设置
    private int now_page = 1;//所在页
    private int all_page;//所有页
    private JLabel class_name[] = new JLabel[1010];//课程名字显示
    private JLabel class_id[] = new JLabel[1010];//课程编号显示
    private JLabel class_college[] = new JLabel[1010];//开课学院显示
    private JLabel class_point[] = new JLabel[1010];//课程学分显示
    private JLabel class_teacher[] = new JLabel[1010];//任课老师显示
    private JLabel class_needtime[] = new JLabel[1010];//所需课时显示
    private JLabel class_pos[] = new JLabel[1010];//上课地点显示
    private JLabel class_stu[] = new JLabel[1010];//课程学生总量显示
    private JLabel class_loss[] = new JLabel[1010];//课程余量显示
    private JButton checkBox[] = new JButton[1010];//退课按钮设置
    private JLabel class_time[] = new JLabel[1010];//上课时间显示
    private JLabel select_title = new JLabel();//标题显示
    public drop_class(String naccount){
        this.account = naccount;
    }

    //退课总执行函数
    public void drop_class_run(){
        set_title();//标语设置
        class_versionnum = getversionclassnum();//获取课程数
        set_exceltitle();//获取课程表格标题
        set_excelmet(class_versionnum);//设置课程栏标题显示
        all_page = class_versionnum/13 + (class_versionnum%13!=0?1:0);//获取总页数
        student_mysql.sort_class(account);//对学生按编号排序
        set_back();//返回按钮设置
        set_pagechange();//上下页按钮设置
        set_classinfo(class_versionnum);//具体信息设置
    }

    //设置标语函数
    public void set_title(){
        String title_info = student_mysql.find_name(account)+"你好，请选择需要退选的课程！";
        select_title.setText(title_info);
        system_run.frame.getContentPane().add(select_title,2,0);
        select_title.setBounds(60,10,800,80);
        select_title.setFont(drop_font.select_title);
    }

    //获取课程数函数
    public int getversionclassnum(){
        return student_mysql.find_classnum(account);
    }

    //设置课程栏标题函数
    public void set_exceltitle(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/tuikelan.png").getImage().
                getScaledInstance(1300,40, Image.SCALE_SMOOTH));
        JLabel img_title = new JLabel(img);
        system_run.frame.getContentPane().add(img_title,2,0);
        img_title.setBounds(60,90,1300,40);
    }

    //设置课程表格背景函数
    public void set_excelmet(int num){
        int start_y = 90;
        int id = 1 + (now_page - 1)*13;
        for(int i=1;i<=13;i++){
            if(drop[i]!=null)drop[i].setVisible(false);
            if(drop[i]!=null)exc_id[i].setVisible(false);
        }
        for(int i=1;i<=Math.min(num-(now_page-1)*13,13);i++){
            Icon img = new ImageIcon(new ImageIcon("src/meterial/tuike_tiao.png").getImage().
                    getScaledInstance(1300,40, Image.SCALE_SMOOTH));
            drop[i] = new JLabel(img);
            system_run.frame.getContentPane().add(drop[i],2,0);
            drop[i].setBounds(60,start_y+40,1300,40);
            exc_id[i] = new JLabel(String.valueOf(id));
            system_run.frame.getContentPane().add(exc_id[i],2,0);
            exc_id[i].setBounds(85,start_y+40,1300,40);
            id ++;
            start_y+=40;
        }

    }

    //设置返回按钮函数
    public void set_back(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/fanhuishouye_tuike.png").getImage().
                getScaledInstance(30,40, Image.SCALE_SMOOTH));
        JButton back = new JButton(img);
        system_run.frame.getContentPane().add(back,2,0);
        back.setBounds(1250,30,30,40);
        back.setBorder(drop_border.select_query);
        JLabel back_info = new JLabel("返回首页");
        system_run.frame.getContentPane().add(back_info,2,0);
        back_info.setBounds(1295,30,100,40);
        back_info.setFont(drop_font.select_query);
        String id = account;

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                system_run.frame.getContentPane().removeAll();
                system_run.frame.repaint();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        system_run.frame.setSize(400,600);
                        system_run.frame.setLocation(system_run.width/2-system_run.frame.getWidth()/2,system_run.height/2-system_run.frame.getHeight()/2);
                        main_menu newx = new main_menu(id);
                        newx.run();
                    }
                };
                timer.schedule(task,300);
            }
        });
    }

    //设置上下页按钮函数
    public void set_pagechange(){
        Icon img1 = new ImageIcon(new ImageIcon("src/meterial/last_page_orange.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        Icon img2 = new ImageIcon(new ImageIcon("src/meterial/next_page_orange.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        JButton last_page = new JButton(img1);
        JButton next_page = new JButton(img2);
        system_run.frame.getContentPane().add(last_page,2,0);
        system_run.frame.getContentPane().add(next_page,2,0);
        last_page.setBounds(1280,670,30,30);
        next_page.setBounds(1330,670,30,30);
        last_page.setBorder(drop_border.select_query);
        next_page.setBorder(drop_border.select_query);
        last_page.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(now_page>1){
                    now_page--;
                    set_excelmet(class_versionnum);
                    set_classinfo(class_versionnum);
                }
            }
        });
        next_page.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(now_page<all_page){
                    now_page++;
                    set_excelmet(class_versionnum);
                    set_classinfo(class_versionnum);
                }
            }
        });
    }

    //设置课程信息显示函数
    public void set_classinfo(int num){
        System.out.println(num);
        int start = (now_page - 1)*13+1;
        int end = Math.min((now_page - 1)*13+13,num);
        for (int i=1;i<=13;i++){
            if(class_name[i]!=null)class_name[i].setVisible(false);
            if(class_id[i]!=null)class_id[i].setVisible(false);
            if(class_college[i]!=null)class_college[i].setVisible(false);
            if(class_point[i]!=null)class_point[i].setVisible(false);
            if(class_teacher[i]!=null)class_teacher[i].setVisible(false);
            if(class_needtime[i]!=null)class_needtime[i].setVisible(false);
            if(class_pos[i]!=null) class_pos[i].setVisible(false);
            if(class_stu[i]!=null) class_stu[i].setVisible(false);
            if(class_loss[i]!=null) class_loss[i].setVisible(false);
            if(checkBox[i]!=null) checkBox[i].setVisible(false);
            if(class_time[i]!=null) class_time[i].setVisible(false);
        }
        int index = -40;
        for (int i=1;i<=end-start+1;i++){
            class_name[i] = new JLabel();
            class_id[i] = new JLabel();
            class_college[i] = new JLabel();
            class_point[i] = new JLabel();
            class_teacher[i] = new JLabel();
            class_needtime[i] = new JLabel();
            class_pos[i] = new JLabel();
            class_stu[i] = new JLabel();
            class_loss[i] = new JLabel();
            checkBox[i] = new JButton();
            class_time[i] = new JLabel();

            String id = student_mysql.getclass_id(account,start+i-1);//change
            String name = class_mysql.find_name(id);
            String college = class_mysql.getclass_college(id);
            String point = class_mysql.getclass_point(id);
            String teacher = class_mysql.getclass_teacher(id);
            String needtime = class_mysql.getclass_classneedtime(id);
            String postion = class_mysql.getclass_classpos(id);
            String stu_time = class_mysql.getclass_classtime(id);

            system_run.frame.getContentPane().add(class_name[i],2,0);
            class_name[i].setBounds(280,170+index,200,40);
            class_name[i].setText(name);

            system_run.frame.getContentPane().add(class_id[i],2,0);
            class_id[i].setBounds(150,170+index,200,40);
            class_id[i].setText(id);

            system_run.frame.getContentPane().add(class_college[i],2,0);
            class_college[i].setBounds(480,170+index,200,40);
            class_college[i].setText(college);

            system_run.frame.getContentPane().add(class_point[i],2,0);
            class_point[i].setBounds(680,170+index,200,40);
            class_point[i].setText(point);

            system_run.frame.getContentPane().add(class_teacher[i],2,0);
            class_teacher[i].setBounds(790,170+index,200,40);
            class_teacher[i].setText(teacher);

            system_run.frame.getContentPane().add(class_needtime[i],2,0);
            class_needtime[i].setBounds(900,170+index,200,40);
            class_needtime[i].setText(needtime);

            system_run.frame.getContentPane().add(class_pos[i],2,0);
            class_pos[i].setBounds(1150,170+index,200,40);
            class_pos[i].setText(postion);

            system_run.frame.getContentPane().add(checkBox[i],2,0);
            checkBox[i].setBounds(1280,170+index,40,40);

            system_run.frame.getContentPane().add(class_time[i],2,0);
            class_time[i].setBounds(1010,170+index,200,40);
            class_time[i].setText(gettime_string(stu_time));
            index+=40;
            checkBox[i].setText("退选");
            checkBox[i].setForeground(Color.RED);
            checkBox[i].setFont(drop_font.info_met);
            checkBox[i].setBorder(drop_border.drop_button);
            int finalI = i;
            checkBox[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String select_id = class_id[finalI].getText();
                    student_mysql.delete_class(select_id,account);
                    student_mysql.add_point(account,String.valueOf(Float.parseFloat(student_mysql.
                            find_point(account))-Float.parseFloat(class_point[finalI].getText())));
                    student_mysql.add_classnum(account,String.valueOf(student_mysql.find_classnum(account)-1));
                    class_mysql.add_stunum(class_id[finalI].getText(),String.valueOf(class_mysql.
                            getclass_classlossstu(id)-1));
                    class_mysql.delete_class(class_id[finalI].getText(),account);
                    class_versionnum = getversionclassnum();
                    set_excelmet(class_versionnum);
                    all_page = class_versionnum/13 + (class_versionnum%13!=0?1:0);
                    student_mysql.sort_class(account);
                    set_classinfo(class_versionnum);
                }
            });
        }
    }

    //时间转换函数
    public String gettime_string(String x){
        int xx = 0;
        int num = 0;
        for (int i=0;i<x.length();i++){
            if(x.charAt(i) == ',') num++;
        }
        for (int i=0;i<x.length();i++){
            if(x.charAt(i) == ',') break;
            xx = xx * 10 + (x.charAt(i)-'0');
        }
        int yx = xx;
        xx = xx/12 + ((xx%12!=0)?1:0);
        String new_x;
        if(xx == 1) {
            new_x = "周一";
        }else if(xx == 2) {
            new_x = "周二";
        }else if(xx == 3){
            new_x ="周三";
        }else if(xx == 4){
            new_x ="周四";
        }else{
            new_x ="周五";
        }
        for(int i=yx%12;i<=yx%12+num-1;i++){
            new_x += String.valueOf(i);
            new_x += ",";
        }
        new_x+=String.valueOf(yx%12+num);
        return new_x;
    }
}
