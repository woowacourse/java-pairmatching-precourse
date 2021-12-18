package pairmatching.domain;

import java.util.Objects;

public class Crew {
	private Course course;
	private String name;

	public String getName() {
		return name;
	}

	public Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Crew crew = (Crew)o;
		return Objects.equals(name, crew.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
