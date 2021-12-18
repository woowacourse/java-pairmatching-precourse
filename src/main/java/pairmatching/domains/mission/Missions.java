package pairmatching.domains.mission;

import static pairmatching.constant.NumberConstant.*;
import static pairmatching.constant.ViewMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Missions {
	List<Mission> missions = new ArrayList<>();
	public void loadMission() {
		MissionModel[] missionModels = MissionModel.values();
		for (MissionModel missionModel : missionModels) {
			Mission missionFrontend = new Mission(missionModel, Course.FRONTEND);
			Mission missionBackend = new Mission(missionModel, Course.BACKEND);
			missions.add(missionFrontend);
			missions.add(missionBackend);
		}
	}

	public Mission findMissionByInput(String userInput) {
		String[] missionDetails = userInput.split(MISSION_DETAIL_DIVIDER);
		Course course = Course.findByString(missionDetails[DETAIL_COURSE_INDEX]);
		MissionModel missionModel = MissionModel.findByString(
			missionDetails[DETAIL_LEVEL_INDEX], missionDetails[
				DETAIL_NAME_INDEX]);
		return missions.stream()
			.filter(s -> s.getCourse() == course)
			.filter(s -> s.getMissionModel() == missionModel)
			.findAny()
			.get();
	}

	public void clearAllMatching() {
		for (Mission mission : missions) {
			mission.clearMatching();
		}
	}
}
