package Connection_cp;

import java.sql.Connection;
import java.sql.DriverManager;


public class cp {
    static Connection con;
    public static Connection createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_man","root","Mayur@123");
        }catch (Exception e){
            e.printStackTrace();
        }
        return  con;
    }
}
