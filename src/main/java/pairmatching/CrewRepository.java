package pairmatching;

import java.util.ArrayList;
import java.util.List;

public class CrewRepository {
	private static final List<Crew> crews = new ArrayList<>();

	public static void addCrews(Crew crew) {
		crews.add(crew);
	}
}
