package system.queryInfo;

import UI_SELF.BORDER;
import UI_SELF.font;
import system.dropClass.class_mysql;
import system.dropClass.student_mysql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class student_more {
    private String account;//账号
    private int class_versionnum;//获取课程数量
    private BORDER drop_border = new BORDER();//详细课程BORDER设置
    private font drop_font = new font();//详细课程font设置
    private Timer timer = new Timer();//定时器设置
    private JLabel drop[] = new JLabel[1010];//课程信息设置
    private JLabel exc_id[] = new JLabel[1010];//课程栏设置
    private int now_page = 1;//所在页
    private int all_page;//所有页
    private JLabel class_name[] = new JLabel[1010];//课程名字
    private JLabel class_id[] = new JLabel[1010];//课程编号
    private JLabel class_college[] = new JLabel[1010];//课程院系
    private JLabel class_point[] = new JLabel[1010];//课程学分
    private JLabel class_teacher[] = new JLabel[1010];//任课老师
    private JLabel class_needtime[] = new JLabel[1010];//课程所需时间
    private JLabel class_pos[] = new JLabel[1010];//上课地点
    private JLabel class_stu[] = new JLabel[1010];//上课总人数
    private JLabel class_loss[] = new JLabel[1010];//已有人数
    private JLabel class_time[] = new JLabel[1010];//上课时间
    private JLabel select_title = new JLabel();//标题设置
    public student_more(String naccount){
        this.account = naccount;
    }

    //主执行程序函数
    public void stu_more_run(){
        set_title();//标题设置
        class_versionnum = getversionclassnum();//获取课程数
        set_exceltitle();//标题栏设置
        set_excelmet(class_versionnum);//内容背景设置
        all_page = class_versionnum/13 + (class_versionnum%13!=0?1:0);//总页数
        student_mysql.sort_class(account);//排序
        set_pagechange();//上下页设置
        set_classinfo(class_versionnum);//课程信息设置
    }

    //标题设置函数
    public void set_title(){
        String title_info = student_mysql.find_name(account)+"的选课信息如下";
        select_title.setText(title_info);
        query_info.framex.getContentPane().add(select_title,2,0);
        select_title.setBounds(60,10,800,80);
        select_title.setFont(drop_font.select_title);
    }

    //获取课程数函数
    public int getversionclassnum(){
        return student_mysql.find_classnum(account);
    }

    //设置标题栏函数
    public void set_exceltitle(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/query_more_title.png").getImage().
                getScaledInstance(1300,45, Image.SCALE_SMOOTH));
        JLabel img_title = new JLabel(img);
        query_info.framex.getContentPane().add(img_title,2,0);
        img_title.setBounds(60,90,1300,45);
    }

    //设置内容函数
    public void set_excelmet(int num){
        int start_y = 90;
        int id = 1 + (now_page - 1)*13;
        for(int i=1;i<=13;i++){
            if(drop[i]!=null)drop[i].setVisible(false);
            if(drop[i]!=null)exc_id[i].setVisible(false);
        }
        for(int i=1;i<=Math.min(num-(now_page-1)*13,13);i++){
            Icon img = new ImageIcon(new ImageIcon("src/meterial/title_more_met.png").getImage().
                    getScaledInstance(1300,40, Image.SCALE_SMOOTH));
            drop[i] = new JLabel(img);
            query_info.framex.getContentPane().add(drop[i],2,0);
            drop[i].setBounds(60,start_y+40,1300,40);
            exc_id[i] = new JLabel(String.valueOf(id));
            query_info.framex.getContentPane().add(exc_id[i],2,0);
            exc_id[i].setBounds(85,start_y+40,1300,40);
            id ++;
            start_y+=40;
        }

    }

    //设置上下页函数
    public void set_pagechange(){
        Icon img1 = new ImageIcon(new ImageIcon("src/meterial/last_page_orange.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        Icon img2 = new ImageIcon(new ImageIcon("src/meterial/next_page_orange.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        JButton last_page = new JButton(img1);
        JButton next_page = new JButton(img2);
        query_info.framex.getContentPane().add(last_page,2,0);
        query_info.framex.getContentPane().add(next_page,2,0);
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

    //设置课程内容函数
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
            class_time[i] = new JLabel();

            String id = student_mysql.getclass_id(account,start+i-1);//change
            String name = class_mysql.find_name(id);
            String college = class_mysql.getclass_college(id);
            String point = class_mysql.getclass_point(id);
            String teacher = class_mysql.getclass_teacher(id);
            String needtime = class_mysql.getclass_classneedtime(id);
            String postion = class_mysql.getclass_classpos(id);
            String stu_time = class_mysql.getclass_classtime(id);

            query_info.framex.getContentPane().add(class_name[i],2,0);
            class_name[i].setBounds(280,170+index,200,40);
            class_name[i].setText(name);

            query_info.framex.getContentPane().add(class_id[i],2,0);
            class_id[i].setBounds(150,170+index,200,40);
            class_id[i].setText(id);

            query_info.framex.getContentPane().add(class_college[i],2,0);
            class_college[i].setBounds(530,170+index,200,40);
            class_college[i].setText(college);

            query_info.framex.getContentPane().add(class_point[i],2,0);
            class_point[i].setBounds(740,170+index,200,40);
            class_point[i].setText(point);

            query_info.framex.getContentPane().add(class_teacher[i],2,0);
            class_teacher[i].setBounds(840,170+index,200,40);
            class_teacher[i].setText(teacher);

            query_info.framex.getContentPane().add(class_needtime[i],2,0);
            class_needtime[i].setBounds(960,170+index,200,40);
            class_needtime[i].setText(needtime);

            query_info.framex.getContentPane().add(class_pos[i],2,0);
            class_pos[i].setBounds(1230,170+index,200,40);
            class_pos[i].setText(postion);


            query_info.framex.getContentPane().add(class_time[i],2,0);
            class_time[i].setBounds(1080,170+index,200,40);
            class_time[i].setText(gettime_string(stu_time));
            index+=40;
        }
    }

    //获取时间转换函数
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
