package assignment2;

import java.util.Random;

public class Student implements Voter{
	String studentName;
	int studentNum;
	Department studentDep;
	
	public Student() {
		this.studentName = "";
		this.studentNum = 0;
		this.studentDep = null;
	}
	
	public Student(int newstuNum, Department newdepNum, String newName) {
		this.studentNum = newstuNum;
		this.studentDep = newdepNum;
		this.studentName = newName;
	}
	
	public void setName(String newName) {
		this.studentName = newName;
	}
	
	public String getName() {
		return this.studentName;
	}
	
	public void setNum(int newNum) {
		this.studentNum = newNum;
	}
	
	public int getNum() {
		return this.studentNum;
	}
	
	public void setDep(Department newDep) {
		this.studentDep = newDep;
	}
	
	public Department getDep() {
		return this.studentDep;
	}
	
	public void vote(Department department) {
		Random rnd = new Random();
		int candiNum = department.Candidates.size();
		int index = rnd.nextInt(candiNum);
		
		Candidate tmp = department.Candidates.get(index);
		tmp.setvoteNum(tmp.getvoteNum()+1);
		department.Candidates.set(index, tmp);
	}
	
	public int compareTo(Candidate candi) {
		return 0;
	}
}

