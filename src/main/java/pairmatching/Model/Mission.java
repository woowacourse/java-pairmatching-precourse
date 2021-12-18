package pairmatching.Model;

import java.util.Objects;

public class Mission {
	private Course course;
	private Level level;
	private String name;

	public Mission(Course course, Level level, String name) {
		this.course = course;
		this.level = level;
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Mission){
			return equals((Mission) obj);
		}
		return false;
	}

	public boolean equals(Mission mission){
		return this.course == mission.course && this.level == mission.level && this.name.equals(mission.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this);
	}
}
