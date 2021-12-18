package pairmatching.domains.mission;

import pairmatching.domains.crew.CrewPair;

public class Mission {
	private MissionModel missionModel;
	private Course course;
	private CrewPair crewPair;

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
}
