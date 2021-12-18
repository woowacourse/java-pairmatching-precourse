package pairmatching.model;

import java.util.ArrayList;

public class PairMatching {

	private Course course;
	private Level level;
	private String mission;

	private ArrayList<String> result = new ArrayList<>();

	public PairMatching(Course course, Level level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public void setResult(ArrayList<String> result) {
		this.result = result;
	}
}
