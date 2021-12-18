package pairmatching.domain;

public class MatchParams {
	private Course course;
	private Level level;
	private Mission mission;

	public MatchParams(Course course, Level level, Mission mission) {
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

	public Mission getMission() {
		return mission;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		MatchParams other = (MatchParams)o;

		return other.getCourse().equals(this.getCourse())
			&& other.getLevel().equals(this.getLevel())
			&& other.getMission().equals(this.getMission());
	}
}
