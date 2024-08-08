package menu;
import Student_manager.Student_manager;
import student.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Starts {
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("Welcome on my project !");
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println();
            System.out.println("PRESS 1 for add student ");
            System.out.println("PRESS 2 for delete student");
            System.out.println("PRESS 3  for update student");
            System.out.println("PRESS 4 for display students ");
            System.out.println("PRESS 5 for exit this app ");
            System.out.print("---------->> ");
            int n;
            try {
                n = Integer.parseInt(scan.readLine());
            }
            catch (Exception e){
                System.out.println();
                System.out.println("please enter a proper number : ");
                continue;
            }
            if(n==1){
                String sname,cname,mobile_no,email,branch;
                String section;
                int roll_no;
                try{
                    System.out.print("Enter student name : ");
                    sname = scan.readLine();
                    System.out.print("Enter student email : ");
                    email = scan.readLine();
                    System.out.print("Enter student roll number : ");
                    roll_no = Integer.parseInt(scan.readLine());
                    System.out.print("Enter student branch : ");
                    branch = scan.readLine();
                    System.out.print("Enter student section : ");
                    section = scan.readLine();
                    System.out.print("Enter student college name : ");
                    cname = scan.readLine();
                    System.out.print("Enter student mobile no : ");
                    mobile_no = scan.readLine();

                }catch (Exception e){
                    System.out.println("*** Something is wrong ! ");
                    continue;
                }
                Student student = new Student(sname,email,cname,mobile_no,roll_no,branch,section);
                Student_manager st = new Student_manager();
                boolean flag = st.addStudent(student);
                if(flag){
                    System.out.println("student added succesfully ! ");
                }else {
                    System.out.println("something is wrong ");
                }

            }
            if(n==2){
                int roll_no=0;
                String email;
                System.out.print("Enter a student roll number : ");
                try {
                    roll_no= Integer.parseInt(scan.readLine());
                }catch (Exception e){
                    System.out.println("something is wrong ! ");
                }
                System.out.println("Enter student email: ");
                email = scan.readLine();
                Student_manager st = new Student_manager();
                boolean flag = st.deleteStudent(email,roll_no);
                if(flag){
                    System.out.println("Student deleted successfully ! ");
                }else {
                    System.out.println("not ok");
                }
            }
            if(n==3){
            	int roll_no=0;
                String email;
                System.out.print("Enter a student roll number : ");
                roll_no= Integer.parseInt(scan.readLine());
                System.out.println("Enter student email: ");
                email = scan.readLine();
                Student_manager st = new Student_manager();
                st.isPresent(email, roll_no);
            }
            if(n==4){
                Student_manager st = new Student_manager();
                st.showStudent();
            }
            if(n==5){
                break;
            }

        }
    }
}
