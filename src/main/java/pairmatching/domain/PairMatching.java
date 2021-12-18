package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.util.Constant;
import pairmatching.util.ErrorMessage;

public class PairMatching {
	private final Course course;
	private final Level level;
	private final Mission mission;
	private final List<List<Crew>> matchCrews = new ArrayList<>();

	public PairMatching(Course course, Level level, Mission mission) {
		validate(level, mission);

		this.course = course;
		this.level = level;
		this.mission = mission;
	}

	public PairMatching makePairMatching(Course course, Level level, Mission mission) {
		return new PairMatching(course, level, mission);
	}

	public List<List<Crew>> getMatchCrews() {
		return matchCrews;
	}

	public void makeMatching(Crews crews) {
		List<String> crewNames = crews.getCourseCrewsNames(course);
		List<Crew> shuffledCrew = Randoms.shuffle(crewNames)
			.stream()
			.map(crews::findCrew)
			.collect(Collectors.toList());

		for (int index = 0; index < shuffledCrew.size() / Constant.MATCHING_GROUP_NUM; index++) {
			matchCrews.add(new ArrayList<>());
			matchCrews.get(index).add(shuffledCrew.get(index * 2));
			matchCrews.get(index).add(shuffledCrew.get(index * 2 + 1));
		}

		if (shuffledCrew.size() % Constant.MATCHING_GROUP_NUM != 0) {
			matchCrews.get(matchCrews.size() - 1).add(shuffledCrew.get(shuffledCrew.size() - 1));
		}
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public Mission getMission() {
		return mission;
	}

	public void validate(Level level, Mission mission) {
		LevelGroup levelGroup = LevelGroup.findGroup(level.getName());
		if (!LevelGroup.hasMission(levelGroup, mission)) {
			throw new IllegalArgumentException(ErrorMessage.ERROR + ErrorMessage.INPUT_LEVEL_MISSION_NONE_MATCH);
		}
	}
}
