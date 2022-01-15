package system.dropClass;

import java.sql.*;

public class class_mysql {

    //驱动配置
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dormitory?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "lcsdsg..123" ;

    //依据课程编号获取课程名称
    public static String find_name(String ac_id) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("class_id");
                String name = rs.getString("class_name");
                if(ac_id.equals(id)){
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
        return  check;
    }

    //依据课程编号获取开课学院
    public static String getclass_college(String ac_id) {
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_college FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("class_id");
                String x = rs.getString("class_college");
                if(ac_id.equals(id)){
                    check = x;
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
        return  check;
    }

    //依据课程编号获取课程学分
    public static String getclass_point(String ac_id) {
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_credit FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("class_id");
                String x = rs.getString("class_credit");
                if(ac_id.equals(id)){
                    check = x;
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
        return  check;
    }

    //依据课程编号获取任课老师
    public static String getclass_teacher(String ac_id) {
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_teacher FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("class_id");
                String x = rs.getString("class_teacher");
                if(ac_id.equals(id)){
                    check = x;
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
        return  check;
    }

    //依据课程编号获取课程所需时间
    public static String getclass_classneedtime(String ac_id) {
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_needtime FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("class_id");
                String x = rs.getString("class_needtime");
                if(ac_id.equals(id)){
                    check = x;
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
        return  check;
    }

    //依据课程编号获取上课地点
    public static String getclass_classpos(String ac_id) {
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_pos FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("class_id");
                String x = rs.getString("class_pos");
                if(ac_id.equals(id)){
                    check = x;
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
        return  check;
    }

    //依据课程编号获取该课程选课人数
    public static int getclass_classlossstu(String ac_id) {
        int check = 0;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name ,class_stustatnum FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                int stunum = rs.getInt("class_stustatnum");
                if(id.equals(ac_id)){
                    check = stunum;
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

    //依据课程编号获取上课时间
    public static String getclass_classtime(String ac_id){
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_time FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id = rs.getString("class_id");
                String x = rs.getString("class_time");
                if(ac_id.equals(id)){
                    check = x;
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
        return  check;
    }

    //该课程对于对于课程数据库中的所选人数进行修改
    public static void add_stunum(String id,String num){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "update class_account set class_stustatnum="+num+" where class_id="+id;
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

    //对于课程单独数据库里删除退课学生信息
    public static void delete_class(String id,String stu_id){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "delete from id_"+id+" where stu_id="+stu_id;
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

}
