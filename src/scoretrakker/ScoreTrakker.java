package scoretrakker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> StudentList = new ArrayList<Student>();
	
	public void loadDataFile(String str) {
		try {
			FileReader reader = new FileReader(str);
			Scanner in = new Scanner(reader);
			while(in.hasNext()) {
				String first = in.next();
				String last = in.next();
				String name = first + " " + last;
				String strScore = in.next();
				int score = Integer.parseInt(strScore);
				StudentList.add(new Student(name, score));
			}	
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void printInOrder() {
		Collections.sort(StudentList);
		for(Student student : StudentList) {
			System.out.println(student);
		}
	}
	
	public void processFiles() {
		loadDataFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String[] args) {
		ScoreTrakker ScoreTrakker = new ScoreTrakker();
		ScoreTrakker.processFiles();
	}
}

