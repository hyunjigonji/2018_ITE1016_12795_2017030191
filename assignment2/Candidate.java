package assignment2;

public class Candidate extends Student {
	int voteNum;
	
	public Candidate() {
		this.voteNum = 0;
	}
	
	public Candidate(Student stu) {
		this.studentName = stu.studentName;
		this.studentNum = stu.studentNum;
		this.studentDep = stu.studentDep;
		this.voteNum = 0;
	}
	
	public void setvoteNum(int newNum) {
		this.voteNum = newNum;
	}
	
	public int getvoteNum() {
		return this.voteNum;
	}

	public int compareTo(Candidate Candi) {
		if(this.voteNum > Candi.voteNum) return 1;
		else if(this.voteNum < Candi.voteNum) return -1;
		else return 0;
	}
}
