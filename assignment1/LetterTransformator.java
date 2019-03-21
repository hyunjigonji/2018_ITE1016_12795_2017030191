package assignment1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LetterTransformator {
	public static void main(String[] args) {
		ArrayList<KeyValue> list= new ArrayList<KeyValue>();
		Scanner properties = null;
		try {
			properties = new Scanner(new FileInputStream("properties.txt"));
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		try {
			while(properties.hasNextLine()) {
				String line = properties.nextLine();
				KeyValue keyvalue = new KeyValue(line);
				list.add(keyvalue);
			}
		}
		catch(Exception e) {
			
		}
		Scanner template = null;
		PrintWriter output = null;
		try {
			template = new Scanner(new FileInputStream("template_file.txt"));
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(0);
		}
		try {
			output = new PrintWriter("ouptut_file.txt");
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(0);
		}
		while(template.hasNextLine()) {
			String line = template.nextLine();
			String writeline = "";
			while(line.contains("{")) {
				int leftindex = line.indexOf("{");
				String leftstring = line.substring(0,leftindex);
				if(leftindex != 0) writeline += leftstring;
				int rightindex = line.indexOf("}");
				String word = line.substring(leftindex+1,rightindex);
				for(int i = 0 ; i < list.size(); i++) {
					if(list.get(i).getKey().equals(word)) {
						writeline += list.get(i).getValue();
					}
				}
				line = line.substring(rightindex+1,line.length());
			}
			if(!line.equals("")) writeline += line;
			output.println(writeline);
			//System.out.println(writeline);
		}
		properties.close();
		template.close();
		output.close();
	}
}
