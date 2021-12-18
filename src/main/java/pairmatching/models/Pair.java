package pairmatching.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pair {
	private final String level;

	private final String course;

	private List<String> currentPairs;

	private HashMap<String, String> exPair;

	public Pair(final String level, final String course) {
		this.level = level;
		this.course = course;
		this.currentPairs = new ArrayList<>();
		this.exPair = new HashMap<>();
	}

	public List<String> getCurrentPairs() {
		return currentPairs;
	}

	public HashMap<String, String> getExPair() {
		return exPair;
	}

	public String getLevel() {
		return level;
	}

	public String getCourse() {
		return course;
	}

	public void setCurrentPairs(List<String> currentPairs) {
		this.currentPairs = currentPairs;
	}

	public void setExPair(HashMap<String, String> exPair) {
		this.exPair = exPair;
	}

	public boolean existPair(final String crow1, final String crow2) {
		final String exTeamMember = exPair.get(crow1);
		return exTeamMember != null && exTeamMember.contains(crow2);
	}

	public void addPair(final String crow1, final String crow2) {
		final String members1 = exPair.get(crow1) + " " + crow2;
		final String members2 = exPair.get(crow2) + " " + crow1;
		exPair.put(crow1, members1);
		exPair.put(crow2, members2);
	}

	public void clearPair() {
		currentPairs.clear();
		exPair.clear();
	}
}
