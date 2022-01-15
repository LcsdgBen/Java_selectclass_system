package system.login;

import java.sql.*;

public class login_mysql {

    //驱动配置
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dormitory?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "lcsdsg..123" ;

    //在数据库里寻找账号，密码
    public static boolean find_id(String ac_id,String ac_password) {
        boolean flag = false;
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT stu_account, stu_password FROM stu_account";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("stu_account");
                String id_password = rs.getString("stu_password");
                if(id.equals(ac_id)&&id_password.equals(ac_password)){
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
        if(flag == true){
            return true;
        }else{
            return false;
        }
    }

}
