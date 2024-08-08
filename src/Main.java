import javax.imageio.IIOException;
import  java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import  java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

class Student{
    private int id;
    private String name;
    private  String college_name;
    private String mobile_no;

    public Student(String name, String college_name, String mobile_no) {
        this.name = name;
        this.college_name = college_name;
        this.mobile_no = mobile_no;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", college_name='" + college_name + '\'' +
                ", mobile_no=" + mobile_no +
                '}';
    }
}

class Cp{
    static Connection con ;
    public static Connection createCp(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_man","root","Mayur@123");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
class student_manager{
    public static boolean insertStudent(Student st){
        boolean flag = false;
        Connection con = null;
        try{
            con = Cp.createCp();
            String query = "insert into students(sname,cname,mobile_no) values(?,?,?)";
            PreparedStatement pt = con.prepareStatement(query);

            pt.setString(1,st.getName());
            pt.setString(2,st.getCollege_name());
            pt.setString(3,st.getMobile_no());

            pt.executeUpdate();
            flag = true;
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  flag;
    }

    public static boolean delete_student(int m) {
        boolean flag = false;
        try{
            Connection con = Cp.createCp();
            String query = "delete from students where sid =?";
            PreparedStatement pt = con.prepareStatement(query);
            pt.setInt(1,m);
//            pt.setString(2,"manish");

            pt.executeUpdate();

            flag = true;
            con.close();
        }
        catch (Exception e){
            System.out.println();
        }
        return flag;
    }

    public static void display() {
        try {
            Connection con = Cp.createCp();
            String query = "select *from students;";
            PreparedStatement pt = con.prepareStatement(query);
            ResultSet rs = pt.executeQuery();

            while (rs.next()){

                System.out.println("id "+rs.getInt(1)+"\nname : "+rs.getNString(2)+"\ncollege name is : "+rs.getNString(3)+"\nmobile no : "+rs.getNString(4));
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
            System.out.println();

        }catch (Exception e){
            System.out.println();
        }
    }

    public static void update_Student(int m) {
        boolean flag = false;
        try{
            BufferedReader scan = new BufferedReader( new InputStreamReader(System.in));
            Connection con = Cp.createCp();
            String query = "update students set sname = ? ,cname = ? ,mobile_no = ? where sid=?";
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
public class Main{
    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("welcome on my project ! ");
        System.out.println();
        while (true){
            System.out.println("PRESS 1 for add student ");
            System.out.println("PRESS 2 for delete student");
            System.out.println("PRESS 3  for update student");
            System.out.println("PRESS 4 for display students ");
            System.out.println("PRESS 5 for exit this app ");
            int n = scanner.nextInt();

            if(n==1){
                System.out.print("Enter a name : ");
                String name = scan.readLine();
                System.out.print("Enter a college name :");
                String cname =  scan.readLine();
                System.out.print("Enter a mobile no. : ");
                String no =  scan.readLine();

                Student student = new Student(name,cname,no);
                boolean flag = student_manager.insertStudent(student);
                if(flag){
                    System.out.println("Student added successfully !");
                }
                else {
                    System.out.println("Something went wrong !");
                }
                System.out.println();
            }
            else if(n==2){
                System.out.println("Enter your id : ");
                int m = Integer.parseInt(scan.readLine());
                boolean flag = student_manager.delete_student(m);
                if(flag){
                    System.out.println("Student deleted successfully !");
                }
                else {
                    System.out.println("Something went wrong !");
                }
                System.out.println();
            }
            else if(n==3){
                System.out.println("Enter your id : ");
                int m = Integer.parseInt(scan.readLine());
                student_manager.update_Student(m);
            }
            else if(n==4){

                student_manager.display();
                System.out.println();
            }
            else if(n==5){
                System.out.println("thanks for using this project !");
                exit(0);
            }
            else {
                System.out.println("PRESS A PROPER VALUE :");
            }
        }
    }
}
