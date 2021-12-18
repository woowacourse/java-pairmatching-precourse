package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {
	private String name;
	private List<Crew> crewPairs = new ArrayList<>();

	public Mission(String name) {
		this.name = name;
	}

	public static Mission from(String name) {
		return new Mission(name);
	}
}
