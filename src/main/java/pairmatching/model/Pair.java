package pairmatching.model;

import java.util.List;

import pairmatching.service.MakingShuffleList;

public class Pair {
	public String course;
	public String level;
	public String mission;
	public List<String> pairList;

	public Pair(String course, String level, String mission, List<String> memberList) {
		this.course = course;
		this.level = level;
		this.mission = mission;
		pairList = MakingShuffleList.shuffle(memberList);
	}
}
