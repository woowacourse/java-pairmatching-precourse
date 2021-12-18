package pairmatching;

public class Crew {
	private final Course course;
	private final String name;

	public Crew(String name, Course course) {
		this.name = name;
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public boolean isCourse(Course query) {
		if (query == course) {
			return true;
		}
		return false;
	}
}
