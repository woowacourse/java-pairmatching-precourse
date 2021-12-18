package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchResult {
	private Course course;
	private Level level;
	private Mission mission;
	private String owner;
	private List<String> pairMembers = new ArrayList<>();

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Level getLevel() {
		return level;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public List<String> getPairMembers() {
		return pairMembers;
	}

	public String getPairMemberNames() {
		StringBuilder stringBuilder = new StringBuilder(owner + " : ");
		String collect = pairMembers.stream().collect(Collectors.joining(" : "));
		stringBuilder.append(collect + "\n");
		return stringBuilder.toString();
	}
}
