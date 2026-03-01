package scoretrakker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
    private final ArrayList<Student> studentList = new ArrayList<Student>();
    private final String[] files = {"scores.txt", "badscore.txt", "nofile.txt"};

    /**
     * Reads the file and parses the file, putting students into the array.
     *
     * @param str File to read.
     * @throws FileNotFoundException Thrown if the fil is not found.
     */
    public void loadDataFile(String str) throws FileNotFoundException {
        FileReader reader = new FileReader(str);
        Scanner in = new Scanner(reader);
        while (in.hasNext()) {
            String first = in.next();
            String last = in.next();
            String name = first + " " + last;
            String strScore = in.next();
            try {
                int score = Integer.parseInt(strScore);
                studentList.add(new Student(name, score));
            } catch (NumberFormatException e) {
                System.out.println("Incorrect format for " + name + " not a valid score: " + strScore);
            }

        }
        in.close();
    }

    /**
     * Prints out the student list sorted by score
     */
    public void printInOrder() {
        Collections.sort(studentList);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    /**
     * Go through and read each file in the files list.
     */
    public void processFiles() {
        for (String file : files) {
            studentList.clear();
            try {
                loadDataFile(file);
                printInOrder();
            } catch (FileNotFoundException e) {
                System.out.println("Can't open file: " + file);
            }
        }
    }

    static void main() {
        ScoreTrakker ScoreTrakker = new ScoreTrakker();
        ScoreTrakker.processFiles();
    }
}

