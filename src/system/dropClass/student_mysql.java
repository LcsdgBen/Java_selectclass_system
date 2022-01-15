package system.dropClass;

import java.sql.*;

public class student_mysql {

    //驱动配置
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dormitory?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "lcsdsg..123" ;

    //用学生编号查找学生姓名
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

    //用学生编号查找学生选课数
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

    //用学生编号查找学生获取学分
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

    //学生个人数据库删除课程
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

    //学生总数据库里修改所获学分
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

    //学生总数据库里修改所选课程数目
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

    //学生个人数据里按课程排序
    public static void sort_class(String stu_id){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "ALTER TABLE id_"+stu_id+" ORDER BY class_id ASC";
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

    //学生个人数据库里获取课程编号
    public static String getclass_id(String account,int num){
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        int x = 0;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id FROM id_"+account;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                x++;
                if(x == num){
                    check = id;
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
