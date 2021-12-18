package pairmatching.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crew {
	private Course course;
	private String name;

	private Crew(Course course, String name) {
		this.course = course;
		this.name = name;
	}

	public static void addToList(String name, List<String> crews) {
		crews.add(name);
	}

	public static void shuffle(List<String> crews) {
		Randoms.shuffle(crews);
	}

	public Course getCourse() {
		return course;
	}

	public String getName() {
		return name;
	}
}
