package model;

public class Crew {
	private Course course;
	private String name;

	public Crew(String name, String process) {
		this.name = name;
		if (process.equals("백엔드")) {
			this.course = Course.BACKEND;
		}
		this.course = Course.FRONTEND;
	}
}