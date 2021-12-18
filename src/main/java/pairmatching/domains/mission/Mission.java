package pairmatching.domains.mission;

import java.util.Optional;

import pairmatching.domains.crew.CrewPair;

public class Mission {
	private MissionModel missionModel;
	private Course course;
	private CrewPair crewPair;
	private boolean isShuffled = false;

	public Mission(MissionModel missionModel, Course course) {
		this.missionModel = missionModel;
		this.course = course;
	}

	public MissionModel getMissionModel() {
		return missionModel;
	}

	public Course getCourse() {
		return course;
	}

	public boolean isShuffled() {
		return isShuffled;
	}

	public void shufflePairs() {

	}

	public void clearMatching() {
		crewPair.clear();
	}
}
