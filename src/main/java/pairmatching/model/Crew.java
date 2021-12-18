package pairmatching.model;

import java.util.List;
import java.util.Map;

public class Crew {
	private Course course;
	private String name;
	private Map<Level, List<Crew>> matchedCrew;
}
