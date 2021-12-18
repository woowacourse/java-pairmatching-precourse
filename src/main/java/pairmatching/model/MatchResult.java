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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
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

	public void setPairMembers(List<String> pairMembers) {
		this.pairMembers = pairMembers;
	}

	public String getPairMemberNames() {
		StringBuilder stringBuilder = new StringBuilder(owner + " : ");
		String collect = pairMembers.stream().collect(Collectors.joining(" : "));
		stringBuilder.append(collect + "\n");
		return stringBuilder.toString();
	}
}


