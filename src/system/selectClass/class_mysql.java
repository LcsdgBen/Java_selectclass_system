package system.selectClass;

import java.sql.*;

public class class_mysql {
    //驱动配置
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dormitory?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "lcsdsg..123" ;

    //获取按名字和编号查询数量
    public static int find_name(String ac_id,String ac_name) {
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
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
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

    //获取按课程查询名字的课程
    public static String getclass_name(String ac_id,String ac_name,int x) {
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
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
                    check = name;
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

    //获取按编号查询名字的课程
    public static String getclass_id(String ac_id,String ac_name,int x) {
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
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
                    check = id;
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

    //获取课程院系
    public static String getclass_college(String ac_id,String ac_name,int x) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name ,class_college FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                String college = rs.getString("class_college");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
                    check = college;
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

    //获取课程学分
    public static String getclass_point(String ac_id,String ac_name,int x) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name ,class_credit FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                String point = rs.getString("class_credit");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
                    check = point;
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

    //获取任课老师
    public static String getclass_teacher(String ac_id,String ac_name,int x) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name ,class_teacher FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                String teacher = rs.getString("class_teacher");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
                    check = teacher;
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

    //获取所需时间
    public static String getclass_classneedtime(String ac_id,String ac_name,int x) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name ,class_needtime FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                String needtime = rs.getString("class_needtime");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
                    check = needtime;
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

    //获取上课地点
    public static String getclass_classpos(String ac_id,String ac_name,int x) {
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name ,class_pos FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                String pos = rs.getString("class_pos");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
                    check = pos;
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

    //获取课程上课总人数
    public static int getclass_classstu(String ac_id,String ac_name,int x) {
        int num = 0;
        int check = 0;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name ,class_stunum FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                int stunum = rs.getInt("class_stunum");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
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

    //获取已选课人数
    public static int getclass_classlossstu(String ac_id,String ac_name,int x) {
        int num = 0;
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
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
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

    //获取上课时间
    public static String getclass_classtime(String ac_id,String ac_name,int x){
        int num = 0;
        String check = null;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT class_id, class_name ,class_time FROM class_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("class_id");
                String name = rs.getString("class_name");
                String stunum = rs.getString("class_time");
                if(ac_id == null&&ac_name == null){
                    num++;
                }else if(ac_id == null&&name .equals( ac_name)){
                    num++;
                }else if(ac_name == null&&ac_id.equals(id)){
                    num++;
                }
                if(num == x){
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

    //更改上课的人数
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

    //向班级里插入学生
    public static void insert_stu(String id,String stu_id){
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "insert into id_"+id+" (stu_id) values(?)";
            PreparedStatement rs = conn.prepareStatement(sql);
            rs.setString(1,stu_id);
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

    //删除班级里学生
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
