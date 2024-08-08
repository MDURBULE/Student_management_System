package student;

public class Student{
private String name;
private String email;
private  String college_name;
private String mobile_no;
private int roll_no;
private String branch;
private String section;

public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public Student(String name, String email, String college_name, String mobile_no, int roll_no, String branch,
		String section) {
	super();
	this.name = name;
	this.email = email;
	this.college_name = college_name;
	this.mobile_no = mobile_no;
	this.roll_no = roll_no;
	this.branch = branch;
	this.section = section;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
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

public int getRoll_no() {
	return roll_no;
}

public void setRoll_no(int roll_no) {
	this.roll_no = roll_no;
}

public String getBranch() {
	return branch;
}

public void setBranch(String branch) {
	this.branch = branch;
}

public String getSection() {
	return section;
}

public void setSection(String section) {
	this.section = section;
}

@Override
public String toString() {
	return "Student [name=" + name + ", email=" + email + ", college_name=" + college_name + ", mobile_no=" + mobile_no
			+ ", roll_no=" + roll_no + ", branch=" + branch + ", section=" + section + "]";
}





}
