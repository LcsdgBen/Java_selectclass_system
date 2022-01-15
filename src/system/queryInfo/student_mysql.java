package system.queryInfo;

import java.sql.*;

public class student_mysql {
    //驱动配置
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dormitory?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "lcsdsg..123" ;

    //按院系查询个数
    public static int get_stubycollege(String s) {
        int num = 0;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_major FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_major");
                if(x.equals(s)){
                    num++;
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
        return num;
    }

    //查询学生院系返回学生编号
    public static String  get_stuidbycollege(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_major ,stu_account FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_major");
                check = rs.getString("stu_account");
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //查询学生院系返回学生名字
    public static String  get_stunamebycollege(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_major ,stu_name FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_major");
                check = rs.getString("stu_name");
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //查询学生院系返回学生班级
    public static String  get_stuclassbycollege(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_major ,stu_classnum FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_major");
                check = String.valueOf(rs.getInt("stu_classnum"));
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //按id查询个数
    public static int get_stubyid(String s) {
        int num = 0;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_account FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_account");
                if(x.equals(s)){
                    num++;
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
        return num;
    }

    //按班级查询个数
    public static int get_stubyclass(String s) {
        int num = 0;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_class FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_class");
                if(x.equals(s)){
                    num++;
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
        return num;
    }

    //查询学生id按班级
    public static String  get_stuidbyclass(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_class ,stu_account FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_class");
                check = rs.getString("stu_account");
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //查询学生姓名按班级
    public static String  get_stunamebyclass(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_class ,stu_name FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_class");
                check = rs.getString("stu_name");
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //查询学生课程按班级
    public static String  get_stuclassbyclass(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_class ,stu_classnum FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_class");
                check = String.valueOf(rs.getInt("stu_classnum"));
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //查询学生姓名按编号
    public static String  get_stunamebyid(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_account ,stu_name FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_account");
                check = rs.getString("stu_name");
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //查询学生班级按编号
    public static String  get_stuclassbyid(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_account ,stu_classnum FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_account");
                check = String.valueOf(rs.getInt("stu_classnum"));
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //获取按名字查询个数
    public static int get_stubyname(String s) {
        int num = 0;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_name FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_name");
                if(x.equals(s)){
                    num++;
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
        return num;
    }

    //获取id按名字查询
    public static String  get_stuidbyname(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_name ,stu_account FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_name");
                check = rs.getString("stu_account");
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //或学生班级按名字
    public static String  get_stuclassbyname(String s,int index) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_name ,stu_classnum FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_name");
                check = String.valueOf(rs.getInt("stu_classnum"));
                if(x.equals(s)){
                    num++;
                }
                if(num == index){
                    break;
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

    //获取学生姓名按id
    public static String  get_stunamebyaccount(String s) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_account ,stu_name FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("stu_account");
                check = rs.getString("stu_name");
                if(x.equals(s)){
                    break;
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
