package pairmatching.model;

import java.util.ArrayList;

import static pairmatching.view.Print.*;

public class Matching {
	private String course;
	private String level;
	private String mission;
	private ArrayList<ArrayList<String>> crews;

	public Matching(String course, String level, String mission, ArrayList<ArrayList<String>> crews) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.crews = crews;
	}

	private boolean isSameCourse(String course) {
		return this.course.equals(course);
	}

	private boolean isSameLevel(String level) {
		return this.level.equals(level);
	}

	private boolean isSameMission(String mission) {
		return this.mission.equals(mission);
	}

	public boolean isSameMatching(String course, String level, String mission) {
		if (isSameCourse(course)) {
			return true;
		}
		if (isSameLevel(level)) {
			return true;
		}
		if (isSameMission(mission)) {
			return true;
		}
		return false;
	}

	public void showCrews() {
		printPairMatching(this.crews);
	}
}
