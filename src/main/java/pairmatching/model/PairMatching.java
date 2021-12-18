package pairmatching.model;

import java.util.ArrayList;

public class PairMatching {

	private String course;
	private String level;
	private String mission = null;

	private ArrayList<String> pairList = new ArrayList<>();

	public PairMatching(String course, String level, String mission) {
		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public PairMatching(String course, String level) {
		this.course = course;
		this.level = level;
	}

	public String getCourse() {
		return course;
	}

	public String getLevel() {
		return level;
	}

	public String getMission() {
		return mission;
	}

	public ArrayList<String> getPairList() {
		return pairList;
	}

	public void setPairList(ArrayList<String> pairList) {
		this.pairList = pairList;
	}
}
