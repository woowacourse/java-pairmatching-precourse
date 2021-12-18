package pairmatching.domain;

import java.util.Objects;

public class PairKey {
	private static Course course;
	private static Level level;
	private static Mission mission;

	public PairKey(Course course, Level level, Mission mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	@Override
	public boolean equals(Object o) {
		if(o==null){
			return false;
		}
		if(o==this){
			return true;
		}
		if (getClass() != o.getClass()) {
			return false;
		}

		PairKey key = (PairKey) o;
		return this.course.equals(key.course)
			&& this.level.equals(key.level)
			&& this.mission.equals(key.mission);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, level, mission);

	}
}
