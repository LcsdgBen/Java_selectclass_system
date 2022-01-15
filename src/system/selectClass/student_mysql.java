package system.selectClass;

import java.sql.*;

public class student_mysql {
    //驱动配置
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dormitory?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "lcsdsg..123" ;

    //获取学生名字
    public static String find_name(String ac_id) {
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_account, stu_name FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("stu_account");
                String name = rs.getString("stu_name");
                if(id.equals(ac_id)){
                    check = name;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return check;
    }

    //获取学生课程数量
    public static int find_classnum(String ac_id) {
        int check =0;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_account, stu_classnum FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("stu_account");
                int name = rs.getInt("stu_classnum");
                if(id.equals(ac_id)){
                    check = name;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return check;
    }

    //获取学生学分
    public static String find_point(String ac_id) {
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_account, stu_selectclasspoint FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("stu_account");
                String point = rs.getString("stu_selectclasspoint");
                if(id.equals(ac_id)){
                    check = point;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return check;
    }

    //判断该学生是否存在课程
    public static boolean check_class(String id,String class_id){
        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id FROM id_"+id;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String idx  = rs.getString("class_id");
                if(idx.equals(class_id)){
                    flag = true;
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        if(flag) return true;
        else return false;
    }

    //将课程插入学生数据库里
    public static void insert_class(String id,String time,String stu_id){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "insert into id_"+stu_id+" (class_id,class_time) values(?,?)";
            PreparedStatement rs = conn.prepareStatement(sql);
            rs.setString(1,id);
            rs.setString(2,time);
            rs.executeUpdate();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    //将课程删除学生数据库里
    public static void delete_class(String id,String stu_id){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "delete from id_"+stu_id+" where class_id="+id;
            Statement pst = conn.createStatement();
            pst.executeUpdate(sql);
            pst.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    //改变学生的学分
    public static void add_point(String stu_id,String point){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "update stu_account set stu_selectclasspoint="+point+" where stu_account="+stu_id;
            PreparedStatement rs = conn.prepareStatement(sql);
            rs.executeUpdate();
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

    }

    //添加课程数量
    public static void add_classnum(String stu_id,String num){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "update stu_account set stu_classnum="+num+" where stu_account="+stu_id;
            PreparedStatement rs = conn.prepareStatement(sql);
            rs.executeUpdate();
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    //看是否有时间重叠
    public static boolean check_time(String s,String stu_id){
        boolean check = false;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_time FROM id_"+stu_id;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String time  = rs.getString("class_time");
                String[] sx = s.split(",");
                String[] st = time.split(",");
                for (int i=0;i<sx.length;i++){
                    for (int j=0;j<st.length;j++){
                        System.out.println(sx[i]);
                        System.out.println(st[j]);
                        if(sx[i].equals(st[j])){
                            check = true;
                        }
                    }
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return check;
    }


}
