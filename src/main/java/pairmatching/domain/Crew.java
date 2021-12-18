package pairmatching.domain;

import java.util.Objects;

public class Crew {
	private Course course;
	private String name;

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Crew))
			return false;
		Crew crew = (Crew)o;
		return course == crew.course && Objects.equals(name, crew.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, name);
	}

	public String getName() {
		return name;
	}
}
