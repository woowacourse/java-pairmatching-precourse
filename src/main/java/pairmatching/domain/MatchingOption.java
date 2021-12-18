package pairmatching.domain;

public class MatchingOption {
	private Course course;
	private Mission mission;

	public MatchingOption(Course course, Mission mission) {
		this.course = course;
		this.mission = mission;
	}

	public Course getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "MatchingOption{" +
			"course=" + course +
			", mission=" + mission +
			'}';
	}
}
