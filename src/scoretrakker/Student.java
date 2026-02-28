package scoretrakker;

public class Student implements Comparable<Object> {
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Object o) {
		return Integer.compare(this.score, score);
	}
	
	@Override
	public String toString() {
		String str;
		str = name + " " + score;
		return str;
		
	}
	
}
