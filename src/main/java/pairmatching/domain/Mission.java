package pairmatching.domain;

public class Mission {
	private Course course;
	private Level level;
	private String name;

	public Mission(Course course, Level level, String name){
		this.course = course;
		this.level = level;
		this.name = name;
	}
}
