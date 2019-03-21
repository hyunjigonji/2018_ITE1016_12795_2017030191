package assignment2;

import java.util.ArrayList;

public class Department {
	String departName;
	int departNum;

    	ArrayList<Candidate> Candidates;
    	ArrayList<Student> Students;
	
	public Department() {
		
	}
	
	public Department(int newNum, String newName) {
		Candidates = new ArrayList<Candidate>();
		Students = new ArrayList<Student>();
		this.departNum = newNum;
		this.departName = newName;
	}
	
	public Candidate mostvotes() {
		int n = Candidates.size();
		Candidate max = new Candidate();
		for(int i = 0 ; i < n ; i++) {
			if(max.compareTo(Candidates.get(i)) == -1) {
				max = Candidates.get(i);
			}
		}
		return max;
	}
}

