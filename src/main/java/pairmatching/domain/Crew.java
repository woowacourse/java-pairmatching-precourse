package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Crew {
	private Course course;
	private String name;
	private static List<Crew> level1Crew = new ArrayList<>();
	private static List<Crew> level2Crew = new ArrayList<>();
	private static List<Crew> level4Crew = new ArrayList<>();

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

	public void saveCrew(List<Crew> crews, Level level) {
		if (level == Level.LEVEL1) {
			level1Crew.addAll(crews);
		}
	}

}
