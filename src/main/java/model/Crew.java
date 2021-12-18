package model;

import java.util.List;

public class Crew {
	private String name;
	private String process;
	private List<String> matchedLevel;

	public Crew(String name, String process) {
		this.name = name;
		this.process = process;
	}

	public String getName() {
		return name;
	}
}
