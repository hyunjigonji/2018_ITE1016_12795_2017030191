package assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ElectionSim {
	String inputDepPath, inputStuPath,outputPath;
	ArrayList<Department> Departments;
	ArrayList<Candidate> Candidates;
	
	public ElectionSim(String inputDep,String inputStu,String output) {
		this.inputDepPath = inputDep;
		this.inputStuPath = inputStu;
		this.outputPath = output;
		Departments = new ArrayList<Department>();
		BufferedReader reader1 = null;
		try {
			reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(inputDepPath), "UTF-8"));
			
			reader1.readLine();
			String line = reader1.readLine();
			while(line != null) {
				String[] info = line.split(",");
				int depNum = Integer.parseInt(info[0]);
				String depName = info[1];
				Department temp = new Department(depNum,depName);
				Departments.add(temp);
				line = reader1.readLine();
			}
			reader1.close();
		}
        catch(Exception e){
            System.exit(0);
        }
		
		BufferedReader reader2 = null;
		try {
			reader2 = new BufferedReader(new InputStreamReader(new FileInputStream(inputStuPath), "UTF-8"));
			
			reader2.readLine();
			String line = reader2.readLine();
			while(line != null) {
				String info[] = line.split(",");
				int stuNum = Integer.parseInt(info[0]);
				int depNum = Integer.parseInt(info[1]);
				String stuName = info[2];
				Department dep = null;
				for(int j = 0 ; j < Departments.size() ; j++) {	
					if(Departments.get(j).departNum == depNum) {
						String depname = Departments.get(j).departName;
						dep = Departments.get(j);
					}
				}
				Student temp = new Student(stuNum,dep,stuName);					
				dep.Students.add(temp);
				if(info[3].equals("TRUE")) {
					Candidate Candi = new Candidate(temp);
					dep.Candidates.add(Candi);
				}
				line = reader2.readLine();
			}
			reader2.close();
		}
        catch(Exception e){
            System.exit(0);
        }
	}
	
	public void saveData() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(outputPath));
			for(int i = 0 ; i < this.Candidates.size() ; i++) {
				writer.println("======== Elected Candidate ========");
				writer.println("Department name: " + Candidates.get(i).studentDep.departName);
				writer.println("name: " + Candidates.get(i).studentName);
				writer.println("Student_id: " + Candidates.get(i).studentNum);
				writer.println("Votes: " + Candidates.get(i).voteNum);
				writer.println("===================================");
			}
			writer.close();
		}
        catch(Exception e){
            System.exit(0);
        }
	}
	
	public void runSimulation() {
		Candidates = new ArrayList<Candidate>();
		for(int i = 0 ; i < Departments.size() ; i++) {
			Iterator<Student> it = Departments.get(i).Students.iterator();
			while(it.hasNext()) {
				it.next().vote(Departments.get(i));
			}
			Candidates.add(Departments.get(i).mostvotes());
		}
		saveData();
	}
}

