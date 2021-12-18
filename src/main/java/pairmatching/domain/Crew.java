package pairmatching.domain;

import java.util.Objects;

public class Crew {
	private Course course;
	private String name;

	private Crew(String name, Course course) {
		this.name = name;
		this.course = course;
	}

	public static Crew of(String name, Course course) {
		return new Crew(name, course);
	}

	public Course getCourse() {
		return this.course;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Crew crew = (Crew)o;
		return course == crew.course && Objects.equals(name, crew.name);
	}
}
