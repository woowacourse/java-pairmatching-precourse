package pairmatching.domain;

import java.util.List;

public class Pair {
	private List<Member> members;
	private Mission mission;
	private Course course;

	public Pair(List<Member> members, Mission mission, Course course) {
		this.members = members;
		this.mission = mission;
		this.course = course;
	}

	public void addMember(Member member) {
		members.add(member);
	}

	public List<Member> getMembers() {
		return members;
	}

	public Mission getMission() {
		return mission;
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return mission.getLevel();
	}

	public Boolean isContainMembers(List<Member> members) {
		return this.members.containsAll(members);
	}
}
