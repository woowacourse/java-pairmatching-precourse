package pairmatching.domain.crew;

import java.util.Objects;

public class Crew {
	private String name;

	private Crew(String name) {
		this.name = name;
	}

	public static Crew from(String name) {
		return new Crew(name);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		Crew crew = (Crew)object;
		return name.equals(crew.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
