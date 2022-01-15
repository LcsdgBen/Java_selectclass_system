package system.queryInfo;

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

public class query_info {
    public static JFrame framex = new JFrame("学生选课系统");//新窗口标题
    private BORDER query_border = new BORDER();//查询的BORDER设置
    private font query_font = new font();//查询的font的设置
    private JTextField query_input = new JTextField();//查询的输入框设置
    private JLabel choose[] = new JLabel[10];//选择的combox标签设置
    private JLabel choose_text[] = new JLabel[10];//选择的combox文字的设置
    private JLabel choose_icon[] = new JLabel[10];//选择的combox标签团的设置
    private JButton[] list_met = new JButton[10];//选择combox按钮的设置
    private JLabel[]  list_met_text = new JLabel[10];//选择的combox文字的设置
    private JLabel[]  list_met_icon = new JLabel[10];//选择的combox图标的设置
    private String[] list = {"系别","班级","学号","姓名","课程"};//combox的文字列表选择
    private JLabel metx[] = new JLabel[10];//展开后的文字列表设置
    private JButton listx = new JButton();//展开按钮
    private boolean flag = false;//是否展开
    private int index = 0;//选择第几个查询
    private String account ;//用户账号
    private Timer timer = new Timer();//定时器设置
    private int all_page = 0;//所有页

    private JLabel[] xibie = new JLabel[100];//系别栏背景设置
    private JLabel[] banji = new JLabel[100];//班级栏背景设置
    private JLabel[] xuehao = new JLabel[100];//学号栏背景设置
    private JLabel[] xingming = new JLabel[100];//姓名栏背景设置
    private JLabel[] kecheng = new JLabel[100];//课程栏背景设置
    private JButton[] more = new JButton[100];//查看更多按钮设置

    private JLabel[] labels1 = new JLabel[100];//第一栏文字填入设置
    private JLabel[] labels2 = new JLabel[100];//第二栏文字填入设置
    private JLabel[] labels3 = new JLabel[100];//第三栏文字填入设置
    private JLabel[] labels4 = new JLabel[100];//第四栏文字填入设置
    private JLabel[] labels5 = new JLabel[100];//第五栏文字填入设置

    private int now_page = 1;//所在页

    //img的图标提取
    private Icon[] img_line = {
            new ImageIcon(new ImageIcon("src/meterial/xibie2.png").getImage().
                    getScaledInstance(370,30,Image.SCALE_SMOOTH)),
            new ImageIcon(new ImageIcon("src/meterial/banji2.png").getImage().
                    getScaledInstance(370,30,Image.SCALE_SMOOTH)),
            new ImageIcon(new ImageIcon("src/meterial/xuehao2.png").getImage().
                    getScaledInstance(370,30,Image.SCALE_SMOOTH)),
            new ImageIcon(new ImageIcon("src/meterial/xingming2.png").getImage().
                    getScaledInstance(370,30,Image.SCALE_SMOOTH)),
            new ImageIcon(new ImageIcon("src/meterial/kecheng2.png").getImage().
                    getScaledInstance(370,30,Image.SCALE_SMOOTH))
    };

    private Icon img_more = new ImageIcon(new ImageIcon("src/meterial/chakan.png").getImage().
            getScaledInstance(20,20,Image.SCALE_SMOOTH));//查看更多的按钮设置

    public query_info(String id){
        this.account = id;
    }

    //查询总执行函数
    public void set_interface(){
        set_frame();//新窗体设置
        set_back();//返回按钮设置
        query_input.setText(null);//清空输入
        set_mettitle(index);//选择所在项的标题
        set_mune();//设置菜单栏
        set_input();//设置输入栏
        set_query_button();//设置查询按钮
        set_pagechange();//设置上下页转换
        init();//初始化
    }

    //新建窗体函数
    public void set_frame(){
        framex.setSize(1440,800);
        framex.setLocation(0,0);
        framex.setBackground(Color.white);
        framex.setVisible(false);
        framex.setResizable(false);
        framex.getContentPane().setBackground(new Color(255,255,255));
        framex.getContentPane().setLayout(null);
    }

    //初始化函数
    public void init(){
        int starty = 110;
        for (int i=0;i<11;i++){
            if(more[i]!=null) more[i].setVisible(false);
        }
        for(int i=0;i<11;i++){
            if(xibie[i] == null)xibie[i] = new JLabel(img_line[0]);
            if(banji[i] == null)banji[i] = new JLabel(img_line[1]);
            if(xuehao[i] == null)xuehao[i] = new JLabel(img_line[2]);
            if(xingming[i] == null)xingming[i] = new JLabel(img_line[3]);
            if(kecheng[i] == null)kecheng[i] = new JLabel(img_line[4]);
            more[i] = new JButton(img_more);

            if(labels1[i] == null)labels1[i] = new JLabel();
            if(labels2[i] == null)labels2[i] = new JLabel();
            if(labels3[i] == null)labels3[i] = new JLabel();
            if(labels4[i] == null)labels4[i] = new JLabel();
            if(labels5[i] == null)labels5[i] = new JLabel();

            system_run.frame.getContentPane().add(xibie[i],2,0);
            system_run.frame.getContentPane().add(banji[i],2,0);
            system_run.frame.getContentPane().add(xuehao[i],2,0);
            system_run.frame.getContentPane().add(xingming[i],2,0);
            system_run.frame.getContentPane().add(kecheng[i],2,0);
            system_run.frame.getContentPane().add(labels1[i],2,0);
            system_run.frame.getContentPane().add(labels2[i],2,0);
            system_run.frame.getContentPane().add(labels3[i],2,0);
            system_run.frame.getContentPane().add(labels4[i],2,0);
            system_run.frame.getContentPane().add(labels5[i],2,0);
            system_run.frame.getContentPane().add(more[i],2,0);
            xibie[i].setBounds(15,starty,370,30);
            banji[i].setBounds(15,starty,370,30);
            xuehao[i].setBounds(15,starty,370,30);
            xingming[i].setBounds(15,starty,370,30);
            kecheng[i].setBounds(15,starty,370,30);
            xibie[i].setVisible(false);
            banji[i].setVisible(false);
            xuehao[i].setVisible(false);
            xingming[i].setVisible(false);
            kecheng[i].setVisible(false);
            labels1[i].setText(null);
            labels2[i].setText(null);
            labels3[i].setText(null);
            labels4[i].setText(null);
            labels5[i].setText(null);
            more[i].setBorder(query_border.query_listx);
            more[i].setVisible(false);
            starty+=35;
        }
    }

    //设置返回按钮
    public void set_back(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/query_back.png").getImage().
                getScaledInstance(23,23,Image.SCALE_SMOOTH));
        JButton query_back = new JButton(img);
        system_run.frame.getContentPane().add(query_back,2,0);
        query_back.setBounds(10,30,23,23);
        query_back.setBorder(query_border.query_input);
        query_back.addActionListener(new ActionListener() {
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
    }

    //设置自制菜单栏combox
    public void set_mune(){
        //选择好的
        Icon[] imgx = {new ImageIcon(new ImageIcon("src/meterial/relation-analysis-full-2.png").getImage().
                getScaledInstance(15,15,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/banjichengyuan-2.png").getImage().
                        getScaledInstance(18,13,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/w_xueshengzheng-2.png").getImage().
                        getScaledInstance(18,18,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/xingming-2.png").getImage().
                        getScaledInstance(17,17,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/kechengguanli-2.png").getImage().
                        getScaledInstance(15,15,Image.SCALE_SMOOTH))};

        for(int i=0;i<5;i++){
            Icon img = new ImageIcon(new ImageIcon("src/meterial/list_back.png").getImage().
                    getScaledInstance(90,35,Image.SCALE_SMOOTH));
            if(choose[i] == null)choose[i] = new JLabel(img);
            choose[i].setSize(90,35);
            system_run.frame.getContentPane().add(choose[i],2,0);
            choose[i].setBounds(35,25,choose[i].getWidth(),choose[i].getHeight());
            choose[i].setBorder(query_border.query_borderx);

            if(choose_text[i] == null)choose_text[i] = new JLabel(list[i]);
            choose_text[i].setForeground(Color.white);
            system_run.frame.getContentPane().add(choose_text[i],2,0);
            choose_text[i].setSize(80,35);
            choose_text[i].setBounds(65,26,choose_text[i].getWidth(),choose_text[i].getHeight());
            choose_text[i].setFont(query_font.query_list);

            if(choose_icon[i] == null)choose_icon[i] = new JLabel(imgx[i]);
            system_run.frame.getContentPane().add(choose_icon[i],2,0);
            choose_icon[i].setSize(20,20);
            choose_icon[i].setBounds(45,32,choose_icon[i].getWidth(),choose_icon[i].getHeight());

            choose[i].setVisible(false);
            choose_icon[i].setVisible(false);
            choose_text[i].setVisible(false);
        }

        choose[index].setVisible(true);
        choose_icon[index].setVisible(true);
        choose_text[index].setVisible(true);

        Icon[] img_box = {new ImageIcon(new ImageIcon("src/meterial/list_box1.png").getImage().
                getScaledInstance(90,35,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/list_box2.png").getImage().
                        getScaledInstance(90,35,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/list_box2.png").getImage().
                        getScaledInstance(90,35,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/list_box2.png").getImage().
                        getScaledInstance(90,35,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/list_box3.png").getImage().
                        getScaledInstance(90,35,Image.SCALE_SMOOTH))};
        int starty = 25;
        for (int i=0;i<5;i++){
            if(list_met[i] == null)list_met[i] = new JButton(img_box[i]);
            if(list_met_text[i] == null)list_met_text[i] = new JLabel(list[i]);
            if(list_met_icon[i] == null)list_met_icon[i] = new JLabel(imgx[i]);
            list_met[i].setBorder(query_border.query_borderx);
            list_met_text[i].setFont(query_font.query_list);
            list_met_text[i].setForeground(Color.white);

            system_run.frame.getContentPane().add(list_met[i],3,0);
            system_run.frame.getContentPane().add(list_met_text[i],3,0);
            system_run.frame.getContentPane().add(list_met_icon[i],3,0);

            list_met[i].setBounds(35,starty,90,35);
            list_met_text[i].setBounds(65,starty+1,80, 35);
            list_met_icon[i].setBounds(45,starty+7,20,20);
            starty+=35;

            int finalI = i;
            list_met[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    index = finalI;
                    for(int j=0;j<5;j++){
                        list_met[j].setVisible(false);
                        list_met_icon[j].setVisible(false);
                        list_met_text[j].setVisible(false);
                        choose[j].setVisible(false);
                        choose_icon[j].setVisible(false);
                        choose_text[j].setVisible(false);
                        metx[j].setVisible(false);
                    }
                    choose[index].setVisible(true);
                    choose_icon[index].setVisible(true);
                    choose_text[index].setVisible(true);
                    metx[index].setVisible(true);
                    now_page = 1;
                    flag = false;
                    query_input.setText(null);
                    init();
                }
            });
            query_input.setText(null);
            list_met[i].setVisible(false);
            list_met_icon[i].setVisible(false);
            list_met_text[i].setVisible(false);

        }
        Icon img = new ImageIcon(new ImageIcon("src/meterial/list.png").getImage().
                getScaledInstance(20,20,Image.SCALE_SMOOTH));
        listx.setIcon(img);
        system_run.frame.getContentPane().add(listx,4,0);
        listx.setBounds(98,32,20,20);
        listx.setBorder(query_border.query_listx);

        listx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag == false){
                    for (int j=0;j<5;j++){
                        choose[j].setVisible(false);
                        choose_icon[j].setVisible(false);
                        choose_text[j].setVisible(false);
                        list_met[j].setVisible(true);
                        list_met_icon[j].setVisible(true);
                        list_met_text[j].setVisible(true);
                    }
                    flag = true;
                }else{
                    for (int j=0;j<5;j++){
                        list_met[j].setVisible(false);
                        list_met_icon[j].setVisible(false);
                        list_met_text[j].setVisible(false);
                    }
                    choose[index].setVisible(true);
                    choose_icon[index].setVisible(true);
                    choose_text[index].setVisible(true);
                    flag = false;
                }
            }
        });
    }

    //设置查询输入框按钮
    public void set_input(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/query_input.png").getImage().
                getScaledInstance(180,35,Image.SCALE_SMOOTH));
        JLabel query_input_background = new JLabel(img);
        system_run.frame.getContentPane().add(query_input_background,2,0);
        query_input_background.setBounds(132,25,180,35);
        system_run.frame.getContentPane().add(query_input,2,0);
        query_input.setBackground(new Color(196,221,247));
        query_input.setBorder(query_border.query_input);
        query_input.setBounds(162,25,130,35);
        Icon img2 = new ImageIcon(new ImageIcon("src/meterial/sousuoxiao.png").getImage().
                getScaledInstance(17,17,Image.SCALE_SMOOTH));
        JLabel search = new JLabel(img2);
        system_run.frame.getContentPane().add(search,2,0);
        search.setBounds(137,29,25,25);
    }

    //设置查询按钮
    public void set_query_button(){
        Icon img = new ImageIcon(new ImageIcon("src/meterial/query_button.png").getImage().
                getScaledInstance(60,35,Image.SCALE_SMOOTH));
        JButton query_button = new JButton(img);
        system_run.frame.getContentPane().add(query_button,2,1);
        query_button.setBounds(320,25,60,35);
        query_button.setBorder(query_border.query_button);
        JLabel button_text = new JLabel("查询");
        system_run.frame.getContentPane().add(button_text,1,0);
        button_text.setBounds(335,26,60,35);
        button_text.setForeground(Color.white);
        button_text.setFont(query_font.query_list);
        query_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init();
                if(index == 0){
                    String s = query_input.getText();
                    int num = student_mysql.get_stubycollege(s);
                    all_page = num/11 + (num%11==0?0:1);
                    set_checkbycollege(num,s);
                }else if(index == 1){
                    String s = query_input.getText();
                    int num = student_mysql.get_stubyclass(s);
                    System.out.println("banji");
                    System.out.println(num);
                    all_page = num/11 + (num%11==0?0:1);
                    set_checkbyclass(num,s);
                }else if(index == 2){
                    String s = query_input.getText();
                    int num = student_mysql.get_stubyid(s);
                    all_page = num/11 + (num%11==0?0:1);
                    set_checkbyid(num,s);
                }else if(index == 3){
                    String s = query_input.getText();
                    int num = student_mysql.get_stubyname(s);
                    all_page = num/11 + (num%11==0?0:1);
                    set_checkbyname(num,s);
                }else{
                    String s = query_input.getText();
                    int num = class_mysql.getstunum(s);
                    all_page = num/11 + (num%11==0?0:1);
                    System.out.println(num);
                    set_checkbyclass_id(num,s);
                }
            }
        });
    }

    //设置标题栏
    public void set_mettitle(int id){
        Icon[] imgx = {new ImageIcon(new ImageIcon("src/meterial/xibie1.png").getImage().
                getScaledInstance(370,30,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/banji1.png").getImage().
                        getScaledInstance(370,30,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/xuehao1.png").getImage().
                        getScaledInstance(370,30,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/xingming1.png").getImage().
                        getScaledInstance(370,30,Image.SCALE_SMOOTH)),
                new ImageIcon(new ImageIcon("src/meterial/kecheng1.png").getImage().
                        getScaledInstance(370,30,Image.SCALE_SMOOTH))};
        for (int i=0;i<5;i++){
            metx[i] = new JLabel(imgx[i]);
            system_run.frame.getContentPane().add(metx[i],2,0);
            metx[i].setBounds(15,70,370,40);
            metx[i].setVisible(false);
        }
        metx[index].setVisible(true);
    }

    //设置按系别查询
    public void set_checkbycollege(int num,String s){
        int start = (now_page - 1)*11 + 1;
        int y = 110;
        for (int i=0;i<Math.min(11,num-(start-1));i++){
            xibie[i].setVisible(true);
            more[i].setVisible(true);
            labels1[i].setText(String.valueOf(start+i));
            labels1[i].setBounds(35,y,100,30);
            labels2[i].setText(s);
            labels2[i].setBounds(90,y,150,30);
            labels3[i].setText(student_mysql.get_stuidbycollege(s,start+i));
            labels3[i].setBounds(165,y,150,30);
            labels3[i].setFont(query_font.query_info_major);
            labels4[i].setText(student_mysql.get_stunamebycollege(s,start+i));
            labels4[i].setBounds(255,y,150,30);
            labels5[i].setText(student_mysql.get_stuclassbycollege(s,start+i));
            labels5[i].setBounds(320,y,150,30);
            more[i].setBounds(350,y,30,30);
            int finalI = i;
            more[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("xxxx");
                    framex.setVisible(true);
                    framex.getContentPane().removeAll();
                    framex.repaint();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            student_more newx = new student_more(labels3[finalI].getText());
                            newx.stu_more_run();
                        }
                    };
                    timer.schedule(task,300);
                }
            });
            y+=35;
        }
        for (int i=0;i<5;i++){
            system_run.frame.getContentPane().add(list_met[i],3,0);
            system_run.frame.getContentPane().add(list_met_text[i],3,0);
            system_run.frame.getContentPane().add(list_met_icon[i],3,0);
        }
        system_run.frame.getContentPane().add(listx,4,0);
    }

    //设置按班级查询
    public void set_checkbyclass(int num,String s){
        int start = (now_page - 1)*11 + 1;
        int y = 110;
        for (int i=0;i<Math.min(11,num-(start-1));i++){
            banji[i].setVisible(true);
            more[i].setVisible(true);
            labels1[i].setText(String.valueOf(start+i));
            labels1[i].setBounds(35,y,100,30);
            labels2[i].setText(s);
            labels2[i].setBounds(80,y,150,30);
            labels3[i].setText(student_mysql.get_stuidbyclass(s,start+i));
            labels3[i].setBounds(165,y,150,30);
            labels3[i].setFont(query_font.query_info_major);
            labels4[i].setText(student_mysql.get_stunamebyclass(s,start+i));
            labels4[i].setBounds(255,y,150,30);
            labels5[i].setText(student_mysql.get_stuclassbyclass(s,start+i));
            labels5[i].setBounds(320,y,150,30);
            more[i].setBounds(350,y,30,30);
            y+=35;
            int finalI = i;
            more[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("xxx");
                    framex.setVisible(true);
                    framex.getContentPane().removeAll();
                    framex.repaint();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            student_more newx = new student_more(labels3[finalI].getText());
                            newx.stu_more_run();
                        }
                    };
                    timer.schedule(task,300);
                }
            });
        }
        for (int i=0;i<5;i++){
            system_run.frame.getContentPane().add(list_met[i],3,0);
            system_run.frame.getContentPane().add(list_met_text[i],3,0);
            system_run.frame.getContentPane().add(list_met_icon[i],3,0);
        }
        system_run.frame.getContentPane().add(listx,4,0);
    }

    //设置按学号查询
    public void set_checkbyid(int num,String s){
        int start = (now_page - 1)*11 + 1;
        int y = 110;
        for (int i=0;i<Math.min(11,num-(start-1));i++){
            xuehao[i].setVisible(true);
            more[i].setVisible(true);
            labels1[i].setText(String.valueOf(start+i));
            labels1[i].setBounds(35,y,100,30);
            labels2[i].setText(s);
            labels2[i].setBounds(80,y,150,30);
            labels5[i].setText(student_mysql.get_stunamebyid(s,start+i));
            labels5[i].setBounds(225,y,150,30);
            labels4[i].setText(student_mysql.get_stuclassbyid(s,start+i));
            labels4[i].setBounds(320,y,150,30);
            more[i].setBounds(350,y,30,30);
            y+=35;
            more[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    framex.setVisible(true);
                    framex.getContentPane().removeAll();
                    framex.repaint();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            student_more newx = new student_more(s);
                            newx.stu_more_run();
                        }
                    };
                    timer.schedule(task,300);
                }
            });
        }
        for (int i=0;i<5;i++){
            system_run.frame.getContentPane().add(list_met[i],3,0);
            system_run.frame.getContentPane().add(list_met_text[i],3,0);
            system_run.frame.getContentPane().add(list_met_icon[i],3,0);
        }
        system_run.frame.getContentPane().add(listx,4,0);
    }

    //设置按姓名查询
    public void set_checkbyname(int num,String s){
        int start = (now_page - 1)*11 + 1;
        int y = 110;
        for (int i=0;i<Math.min(11,num-(start-1));i++){
            xuehao[i].setVisible(true);
            more[i].setVisible(true);
            labels1[i].setText(String.valueOf(start+i));
            labels1[i].setBounds(35,y,100,30);
            labels2[i].setText(student_mysql.get_stuidbyname(s,start+i));
            labels2[i].setBounds(80,y,150,30);
            labels5[i].setText(s);
            labels5[i].setBounds(225,y,150,30);
            labels4[i].setText(student_mysql.get_stuclassbyname(s,start+i));
            labels4[i].setBounds(320,y,150,30);
            more[i].setBounds(350,y,30,30);
            y+=35;
            int finalI = i;
            more[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    framex.setVisible(true);
                    framex.getContentPane().removeAll();
                    framex.repaint();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            student_more newx = new student_more(labels2[finalI].getText());
                            newx.stu_more_run();
                        }
                    };
                    timer.schedule(task,300);
                }
            });
        }
        for (int i=0;i<5;i++){
            system_run.frame.getContentPane().add(list_met[i],3,0);
            system_run.frame.getContentPane().add(list_met_text[i],3,0);
            system_run.frame.getContentPane().add(list_met_icon[i],3,0);
        }
        system_run.frame.getContentPane().add(listx,4,0);
    }

    //设置按课程ID查询
    public void set_checkbyclass_id(int num,String s){
        int start = (now_page - 1)*11 + 1;
        int y = 110;
        for (int i=0;i<Math.min(11,num-(start-1));i++){
            kecheng[i].setVisible(true);
            labels1[i].setText(String.valueOf(start+i));
            labels1[i].setBounds(35,y,100,30);
            labels2[i].setText(s);
            labels2[i].setBounds(80,y,150,30);
            labels3[i].setText(class_mysql.getstuid(s,start+i));
            labels3[i].setBounds(165,y,150,30);
            labels3[i].setFont(query_font.query_info_major);
            labels4[i].setText(student_mysql.get_stunamebyaccount(class_mysql.getstuid(s,start+i)));
            labels4[i].setBounds(260,y,150,30);
            labels5[i].setText(class_mysql.getclassname(s));
            labels5[i].setBounds(310,y,50,30);
            y+=35;
        }
        for (int i=0;i<5;i++){
            system_run.frame.getContentPane().add(list_met[i],3,0);
            system_run.frame.getContentPane().add(list_met_text[i],3,0);
            system_run.frame.getContentPane().add(list_met_icon[i],3,0);
        }
        system_run.frame.getContentPane().add(listx,4,0);
    }

    //设置上下页
    public void set_pagechange(){
        Icon img1 = new ImageIcon(new ImageIcon("src/meterial/last_page_b.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        Icon img2 = new ImageIcon(new ImageIcon("src/meterial/next_page_b.png").getImage().
                getScaledInstance(30,30, Image.SCALE_SMOOTH));
        JButton last_page = new JButton(img1);
        JButton next_page = new JButton(img2);
        system_run.frame.getContentPane().add(last_page,2,0);
        system_run.frame.getContentPane().add(next_page,2,0);
        last_page.setBounds(300,500,30,30);
        next_page.setBounds(350,500,30,30);
        last_page.setBorder(query_border.select_query);
        next_page.setBorder(query_border.select_query);
        last_page.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(now_page>1){
                    now_page--;
                    init();
                    if(index == 0){
                        String s = query_input.getText();
                        int num = student_mysql.get_stubycollege(s);
                        set_checkbycollege(num,s);
                    }else if(index == 1){
                        String s = query_input.getText();
                        int num = student_mysql.get_stubyclass(s);
                        set_checkbyclass(num,s);
                    }else if(index == 2){
                        String s = query_input.getText();
                        int num = student_mysql.get_stubyid(s);
                        set_checkbyid(num,s);
                    }else if(index == 3){
                        String s = query_input.getText();
                        int num = student_mysql.get_stubyname(s);
                        set_checkbyname(num,s);
                    }else{
                        String s = query_input.getText();
                        int num = class_mysql.getstunum(s);
                        System.out.println(num);
                        set_checkbyclass_id(num,s);
                    }
                }
            }
        });
        next_page.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(now_page<all_page){
                    init();
                    now_page++;
                    if(index == 0){
                        String s = query_input.getText();
                        int num = student_mysql.get_stubycollege(s);
                        all_page = num/11 + (num%11==0?0:1);
                        set_checkbycollege(num,s);
                    }else if(index == 1){
                        String s = query_input.getText();
                        int num = student_mysql.get_stubyclass(s);
                        all_page = num/11 + (num%11==0?0:1);
                        set_checkbyclass(num,s);
                    }else if(index == 2){
                        String s = query_input.getText();
                        int num = student_mysql.get_stubyid(s);
                        all_page = num/11 + (num%11==0?0:1);
                        set_checkbyid(num,s);
                    }else if(index == 3){
                        String s = query_input.getText();
                        int num = student_mysql.get_stubyname(s);
                        all_page = num/11 + (num%11==0?0:1);
                        set_checkbyname(num,s);
                    }else{
                        String s = query_input.getText();
                        int num = class_mysql.getstunum(s);
                        all_page = num/11 + (num%11==0?0:1);
                        System.out.println(num);
                        set_checkbyclass_id(num,s);
                    }
                }
            }
        });
    }
}




