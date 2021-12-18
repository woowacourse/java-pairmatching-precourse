package pairmatching.dto;

 import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class RequestCourseAndLevelAndMissionDto {
	private Course course;
	private Level level;
	private String mission;

	public RequestCourseAndLevelAndMissionDto(Course course, Level level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}
}
