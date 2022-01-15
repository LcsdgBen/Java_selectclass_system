package system.queryInfo;

import java.sql.*;

public class class_mysql {
    //驱动的配置
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dormitory?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "lcsdsg..123" ;

    //通过课程编号来查找课程人员的数量
    public static int getstunum(String s){
        int num = 0;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id ,class_stustatnum FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("class_id");
                if(x.equals(s)){
                    num = rs.getInt("class_stustatnum");
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

    //查找学生的编号
    public static String getstuid(String s,int index){
        int num = 0;
        String x = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_id FROM id_"+s;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                num++;
                x  = rs.getString("stu_id");
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
        return x;
    }

    //查找课程的名称
    public static String getclassname(String s){
        String num = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id ,class_name FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String x  = rs.getString("class_id");
                if(x.equals(s)){
                    num = rs.getString("class_name");
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
}
