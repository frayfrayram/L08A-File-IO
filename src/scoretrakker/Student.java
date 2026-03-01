package scoretrakker;

/**
 * Holds on to the information about each student (name and score)
 */
public class Student implements Comparable<Student> {
    private final String name;
    private final int score;

    /**
     * Make a new student to hold information about that student
     *
     * @param name  Name of the student.
     * @param score Current score of the student.
     */
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        String str;
        str = name + " " + score;
        return str;

    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.score);
    }
}
