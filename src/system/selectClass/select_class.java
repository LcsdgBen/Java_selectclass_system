package system.selectClass;

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

public class select_class {
    private String account;//账号
    private int class_versionnum;//课程数
    private BORDER select_border = new BORDER();//选课的BORDER
    private JTextField check_byid = new JTextField();//id输入框
    private JTextField check_byname = new JTextField();//课程输入框
    private font select_font = new font();//课程font
    private Timer timer = new Timer();//定时器设置
    private JLabel select[] = new JLabel[1010];//选课条
    private JLabel exc_id[] = new JLabel[1010];//选课序号
    private int now_page = 1;//所在页
    private int all_page;//所有页
    private JLabel class_name[] = new JLabel[1010];//课程名字
    private JLabel class_id[] = new JLabel[1010];//课程编号
    private JLabel class_college[] = new JLabel[1010];//课程院系
    private JLabel class_point[] = new JLabel[1010];//课程学分
    private JLabel class_teacher[] = new JLabel[1010];//任课老师
    private JLabel class_needtime[] = new JLabel[1010];//课程所需时间
    private JLabel class_pos[] = new JLabel[1010];//上课地点
    private JLabel class_stu[] = new JLabel[1010];//上课学生总数
    private JLabel class_loss[] = new JLabel[1010];//课程学生余量
    private JCheckBox checkBox[] = new JCheckBox[1010];//选课框
    private JLabel class_time[] = new JLabel[1010];//上课时间
    public select_class(String naccount){
        this.account = naccount;
    }
    private JLabel select_title = new JLabel();//标题

    private JLabel error_text1 = new JLabel("选课时间冲突");//选课失败提示1
    private JLabel error_text2 = new JLabel("该课程已满");//选课失败提示2

    //课程主执行函数
    public void select_class_run(){
        check_byid.setText(null);
        check_byname.setText(null);
        set_title();
        set_checkid();
        class_versionnum = getversionclassnum(null,null);
        set_exceltitle();
        set_excelmet(class_versionnum);
        all_page = class_versionnum/13 + (class_versionnum%13!=0?1:0);
        set_back();
        set_pagechange();
        set_classinfo(class_versionnum);
    }

    //设置标题函数
    public void set_title(){
        String title_info = student_mysql.find_name(account)+"你好，欢迎进入选课系统!          学分要求： 30分    已选学分： ";
        system_run.frame.getContentPane().add(select_title,2,0);
        select_title.setBounds(60,10,1000,80);
        select_title.setFont(select_font.select_title);
        String select_pointx = student_mysql.find_point(account) + "分";
        title_info = title_info + select_pointx;
        select_title.setText(title_info);
    }

    //id搜索框函数
    public void set_checkid(){
        JLabel check_id = new JLabel("课程编号：");
        system_run.frame.getContentPane().add(check_id,2,0);
        check_id.setBounds(60,60,800,80);
        check_id.setFont(select_font.select_title);
        system_run.frame.getContentPane().add(check_byid,2,0);
        check_byid.setBounds(160,87,150,25);
        check_byid.setBorder(select_border.select_input);

        JLabel check_name = new JLabel("课程名字：");
        system_run.frame.getContentPane().add(check_name,2,0);
        check_name.setBounds(320,60,800,80);
        check_name.setFont(select_font.select_title);
        system_run.frame.getContentPane().add(check_byname,2,0);
        check_byname.setBounds(415,87,150,25);
        check_byname.setBorder(select_border.select_input);

        JButton query = new JButton();
        Icon img = new ImageIcon(new ImageIcon("src/meterial/query_select.png").getImage().
                getScaledInstance(60,30, Image.SCALE_SMOOTH));
        query.setIcon(img);
        system_run.frame.getContentPane().add(query,2,0);
        query.setBounds(580,84,60,30);
        JLabel query_info = new JLabel("查找");
        system_run.frame.getContentPane().add(query_info,2,0);
        query_info.setBounds(595,83,60,30);
        query_info.setForeground(Color.white);
        query_info.setFont(select_font.select_query);

        query.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x1 = (check_byid.getText().replace(" ","").length() == 0)?
                        null:check_byid.getText().replace(" ","");
                String x2 = (check_byname.getText().replace(" ","").length() == 0)?
                        null:check_byname.getText().replace(" ","");
                class_versionnum = getversionclassnum(x1,x2);
                all_page = class_versionnum/13 + (class_versionnum%13!=0?1:0);
                now_page = 1;
                System.out.println(class_versionnum);
                set_excelmet(class_versionnum);
                set_classinfo(class_versionnum);
            }
        });
    }

    //获取课程总数函数
    public int getversionclassnum(String id,String name){
        return class_mysql.find_name(id,name);
    }

    //设置标题栏
    public void set_exceltitle(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/class_select_mune.png").getImage().
                getScaledInstance(1300,40, Image.SCALE_SMOOTH));
        JLabel img_title = new JLabel(img);
        system_run.frame.getContentPane().add(img_title,2,0);
        img_title.setBounds(60,130,1300,40);
    }

    //设置标题背景栏
    public void set_excelmet(int num){
        int start_y = 130;
        int id = 1 + (now_page - 1)*13;
        for(int i=1;i<=13;i++){
            if(select[i]!=null)select[i].setVisible(false);
            if(select[i]!=null)exc_id[i].setVisible(false);
        }
        for(int i=1;i<=Math.min(num-(now_page-1)*13,13);i++){
            Icon img = new ImageIcon(new ImageIcon("src/meterial/yuliang.png").getImage().
                    getScaledInstance(1300,40, Image.SCALE_SMOOTH));
            select[i] = new JLabel(img);
            system_run.frame.getContentPane().add(select[i],2,0);
            select[i].setBounds(60,start_y+40,1300,40);
            exc_id[i] = new JLabel(String.valueOf(id));
            system_run.frame.getContentPane().add(exc_id[i],2,0);
            exc_id[i].setBounds(85,start_y+40,1300,40);
            id ++;
            start_y+=40;
        }

    }

    //设置返回按钮函数
    public void set_back(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/select_back.png").getImage().
                getScaledInstance(30,40, Image.SCALE_SMOOTH));
        JButton back = new JButton(img);
        system_run.frame.getContentPane().add(back,2,0);
        back.setBounds(1250,30,30,40);
        back.setBorder(select_border.select_query);
        JLabel back_info = new JLabel("返回首页");
        system_run.frame.getContentPane().add(back_info,2,0);
        back_info.setBounds(1295,30,100,40);
        back_info.setFont(select_font.select_query);
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

    //设置上下页函数
    public void set_pagechange(){
        Icon img1 = new ImageIcon(new ImageIcon("src/meterial/last_page.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        Icon img2 = new ImageIcon(new ImageIcon("src/meterial/next_page.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        JButton last_page = new JButton(img1);
        JButton next_page = new JButton(img2);
        system_run.frame.getContentPane().add(last_page,2,0);
        system_run.frame.getContentPane().add(next_page,2,0);
        last_page.setBounds(1280,700,30,30);
        next_page.setBounds(1330,700,30,30);
        last_page.setBorder(select_border.select_query);
        next_page.setBorder(select_border.select_query);
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

    //设置内容函数
    public void set_classinfo(int num){
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
        int index = 0;
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
            checkBox[i] = new JCheckBox();
            class_time[i] = new JLabel();
            String x1 = (check_byid.getText().replace(" ","").length() == 0)?
                    null:check_byid.getText().replace(" ","");
            String x2 = (check_byname.getText().replace(" ","").length() == 0)?
                    null:check_byname.getText().replace(" ","");

            String name = class_mysql.getclass_name(x1, x2,start+i-1);
            String id = class_mysql.getclass_id(x1,x2,start+i-1);
            String college = class_mysql.getclass_college(x1,x2,start+i-1);
            String point = class_mysql.getclass_point(x1,x2,start+i-1);
            String teacher = class_mysql.getclass_teacher(x1,x2,start+i-1);
            String needtime = class_mysql.getclass_classneedtime(x1,x2,start+i-1);
            String postion = class_mysql.getclass_classpos(x1,x2,start+i-1);
            String stu_num = String.valueOf(class_mysql.getclass_classstu(x1,x2,start+i-1));
            String stu_loss = String.valueOf(class_mysql.getclass_classstu(x1,x2,start+i-1)-class_mysql.
                    getclass_classlossstu(x1,x2,start+i-1));
            String stu_time = class_mysql.getclass_classtime(x1,x2,start+i-1);

            system_run.frame.getContentPane().add(class_name[i],2,0);
            class_name[i].setBounds(230,170+index,200,40);
            class_name[i].setText(name);

            system_run.frame.getContentPane().add(class_id[i],2,0);
            class_id[i].setBounds(130,170+index,200,40);
            class_id[i].setText(id);

            system_run.frame.getContentPane().add(class_college[i],2,0);
            class_college[i].setBounds(390,170+index,200,40);
            class_college[i].setText(college);

            system_run.frame.getContentPane().add(class_point[i],2,0);
            class_point[i].setBounds(600,170+index,200,40);
            class_point[i].setText(point);

            system_run.frame.getContentPane().add(class_teacher[i],2,0);
            class_teacher[i].setBounds(670,170+index,200,40);
            class_teacher[i].setText(teacher);

            system_run.frame.getContentPane().add(class_needtime[i],2,0);
            class_needtime[i].setBounds(790,170+index,200,40);
            class_needtime[i].setText(needtime);

            system_run.frame.getContentPane().add(class_pos[i],2,0);
            class_pos[i].setBounds(1010,170+index,200,40);
            class_pos[i].setText(postion);

            system_run.frame.getContentPane().add(class_stu[i],2,0);
            class_stu[i].setBounds(1195,170+index,200,40);
            class_stu[i].setText(stu_num);

            system_run.frame.getContentPane().add(class_loss[i],2,0);
            class_loss[i].setBounds(1125,170+index,200,40);
            class_loss[i].setText(stu_loss);

            system_run.frame.getContentPane().add(checkBox[i],2,0);
            checkBox[i].setBounds(1280,170+index,40,40);

            system_run.frame.getContentPane().add(class_time[i],2,0);
            class_time[i].setBounds(885,170+index,200,40);
            class_time[i].setText(gettime_string(stu_time));
            index+=40;
            checkBox[i].setSelected(false);
            if(student_mysql.check_class(account,id)){
                checkBox[i].setSelected(true);
            }
            int finalI = i;
            checkBox[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(checkBox[finalI].isSelected()){
                        if(class_mysql.getclass_classstu(x1,x2,start+finalI-1) - class_mysql.getclass_classlossstu(x1,x2,start+finalI-1) - 1<0){
                            checkBox[finalI].setSelected(false);
                            system_run.frame.getContentPane().add(error_text2,2,0);
                            error_text2.setBounds(1260,80,150,40);
                            error_text2.setForeground(Color.RED);
                            error_text2.setFont(select_font.select_title);
                            error_text2.setVisible(true);
                            TimerTask task = new TimerTask() {
                                @Override
                                public void run() {
                                    error_text2.setVisible(false);
                                }
                            };
                            timer.schedule(task,1500);
                        }else{
                            boolean flag = false;
                            System.out.println(class_mysql.getclass_classtime(x1,x2,start+finalI-1));
                            System.out.println(account);
                            if(student_mysql.check_time(class_mysql.getclass_classtime(x1,x2,start+finalI-1),account)){
                                checkBox[finalI].setSelected(false);
                                system_run.frame.getContentPane().add(error_text1,2,0);
                                error_text1.setBounds(1250,80,150,40);
                                error_text1.setForeground(Color.RED);
                                error_text1.setFont(select_font.select_title);
                                error_text1.setVisible(true);
                                TimerTask task = new TimerTask() {
                                    @Override
                                    public void run() {
                                        error_text1.setVisible(false);
                                    }
                                };
                                timer.schedule(task,1500);
                            }else{
                                String select_id = class_id[finalI].getText();
                                student_mysql.insert_class(select_id,stu_time,account);
                                student_mysql.add_point(account,String.valueOf(Float.parseFloat(student_mysql.
                                        find_point(account))+Float.parseFloat(class_point[finalI].getText())));
                                student_mysql.add_classnum(account,String.valueOf(student_mysql.find_classnum(account)+1));
                                class_mysql.add_stunum(class_id[finalI].getText(),String.valueOf(class_mysql.
                                        getclass_classlossstu(x1,x2,start+finalI-1)+1));
                                String stu_lossx = String.valueOf(class_mysql.getclass_classstu(x1,x2,start+finalI-1)-class_mysql.
                                        getclass_classlossstu(x1,x2,start+finalI-1));
                                class_loss[finalI].setText(stu_lossx);
                                class_mysql.insert_stu(class_id[finalI].getText(),account);
                                set_title();
                            }
                        }
                    }else{
                        String select_id = class_id[finalI].getText();
                        student_mysql.delete_class(select_id,account);
                        student_mysql.add_point(account,String.valueOf(Float.parseFloat(student_mysql.
                                find_point(account))-Float.parseFloat(class_point[finalI].getText())));
                        student_mysql.add_classnum(account,String.valueOf(student_mysql.find_classnum(account)-1));
                        class_mysql.add_stunum(class_id[finalI].getText(),String.valueOf(class_mysql.
                                getclass_classlossstu(x1,x2,start+finalI-1)-1));
                        String stu_lossx = String.valueOf(class_mysql.getclass_classstu(x1,x2,start+finalI-1)-class_mysql.
                                getclass_classlossstu(x1,x2,start+finalI-1));
                        class_loss[finalI].setText(stu_lossx);
                        class_mysql.delete_class(class_id[finalI].getText(),account);
                        set_title();
                    }
                }
            });
        }
    }

    //获取转换时间
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
        //System.out.println(yx);
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
