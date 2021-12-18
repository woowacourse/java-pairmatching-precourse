package pairmatching.service;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.exception.ToCourseException;
import pairmatching.exception.ToLevelException;
import pairmatching.exception.ToMissionException;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.validator.InputValidator;

public class PairMatchingService {
	private static final String PAIRMATCHING_INPUT_DELIMITER = ",";
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	private final CrewRepository crewRepository = CrewRepository.getInstance();
	private final PairMatchingRepository pairMatchingRepository = PairMatchingRepository.getInstance();

	public PairMatchingService() {
	}

	public void pairMatching(String input) throws IllegalArgumentException {
		String[] splitInput = input.split(PAIRMATCHING_INPUT_DELIMITER);
		InputValidator.isSizeThree(splitInput);
		Course course = toCourse(splitInput[COURSE_INDEX].trim());
		Level level = toLevel(splitInput[LEVEL_INDEX].trim());
		Mission mission = toMission(level, splitInput[MISSION_INDEX].trim());

	}

	public void pairMatch(Course course, Level level, Mission mission) {
		List<Crew> crewsShuffle = Randoms.shuffle(crewRepository.getCrews(course));


	}

	private Course toCourse(String input) throws IllegalArgumentException {
		Course course = Course.findForName(input);
		if (course == null) {
			throw new ToCourseException();
		}
		return course;
	}

	private Level toLevel(String input) throws IllegalArgumentException {
		Level level = Level.findForName(input);
		if (level == null) {
			throw new ToLevelException();
		}
		return level;
	}

	private Mission toMission(Level level, String input) throws IllegalArgumentException {
		Mission mission = Mission.findForName(input);
		if (mission == null) {
			throw new ToMissionException();
		}
		if (!level.getMissions().contains(mission)) {
			throw new ToMissionException();
		}
		return mission;
	}
}
