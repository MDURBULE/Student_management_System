package Student_manager;

//imports
import Connection_cp.cp;
import student.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Student_manager {
    public Boolean addStudent(Student  st){
        boolean flag = false;
        try{
            Connection con = cp.createConnection();
            String query = "insert into students(sname,email,cname,mobile_no,roll_no,branch,section) values(?,?,?,?,?,?,?)";
            PreparedStatement pt = con.prepareStatement(query);

            pt.setString(1,st.getName());
            pt.setString(2, st.getEmail());
            pt.setString(3,st.getCollege_name());
            pt.setString(4, st.getMobile_no());
            pt.setInt(5,st.getRoll_no());
            pt.setString(6, st.getBranch());
            pt.setString(7, st.getSection());

            pt.executeUpdate();
            flag = true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public void showStudent(){
        try{
            Connection con = cp.createConnection();
            String query = "select * from students; ";
            PreparedStatement pt = con.prepareStatement(query);

            ResultSet rs = pt.executeQuery();
            while (rs.next()){
                System.out.println("full name : "+rs.getNString("sname"));
                System.out.println("email : "+rs.getNString("email"));
                System.out.println("roll no : "+rs.getInt("roll_no"));
                System.out.println("branch : "+rs.getNString("branch"));
                System.out.println("section : "+rs.getNString("section"));
                System.out.println("college name : "+rs.getNString("cname"));
                System.out.println("mobile no : "+rs.getNString("mobile_no"));
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean deleteStudent(String email,int roll_no){
        boolean flag = false;
        try {
            Connection con = cp.createConnection();
            String query = "delete from students where roll_no = ? and email = ?";
            PreparedStatement pt = con.prepareStatement(query);

            pt.setInt(1,roll_no);
            pt.setString(2, email);
            pt.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
    public int isPresent(String email,int roll_no) {
    	 int count=0;
    	try {
    		Connection con = cp.createConnection();
            String query = "select * from students where roll_no =? and email=? ";
            PreparedStatement pt = con.prepareStatement(query);
            pt.setInt(1, roll_no);
            pt.setString(2, email);

            ResultSet rs = pt.executeQuery();
            while(rs.next()) {
            	count++;
            }
            System.out.print(count);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return count;
    }
    
    public static void updateStudent(int m) {
        boolean flag = false;
        try{
            BufferedReader scan = new BufferedReader( new InputStreamReader(System.in));
            Connection con = cp.createConnection();
            String query = "update students set sname = ? ,cname = ? ,mobile_no = ? where roll_no=? ";
            PreparedStatement pt = con.prepareStatement(query);

            pt.setInt(4,m);
            System.out.print("Enter your name : ");
            String sname = scan.readLine();
            System.out.print("Enter your college name : ");
            String cname = scan.readLine();
            System.out.println("Enter your mobile no : ");
            String mo = scan.readLine();

            pt.setString(1,sname);
            pt.setString(2,cname);
            pt.setString(3,mo);

            pt.executeUpdate();
            flag = true;
        }
        catch (Exception e){
            System.out.println();
        }

        if(flag){
            System.out.println("updated successfully ! ");
        }
        else{
            System.out.println("something is wrong ! ");
        }
    }
}
