package pairmatching.domain.repository;

import static pairmatching.utils.Constants.*;
import static pairmatching.utils.ExceptionMessage.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingCrew;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatching;

public class PairMatchingRepository {
	public static List<PairMatching> pairMatchingList = new LinkedList<>();

	public static void add(String course, String level, String mission) {
		List<MatchingCrew> crewList = createMatchingCrews(course);
		pairMatchingList.add(new PairMatching(Course.find(course), new Mission(mission), Level.find(level), crewList));
	}

	public static void rematching(String course, String level, String mission) {
		pairMatchingList.remove(PairMatchingRepository.find(course, level, mission));
		List<MatchingCrew> crewList = createMatchingCrews(course);
		pairMatchingList.add(new PairMatching(Course.find(course), new Mission(mission), Level.find(level), crewList));
	}

	public static PairMatching find(String course, String level, String mission) {
		return pairMatchingList.stream()
			.filter(pairMatching -> pairMatching.isSame(course, level, mission))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(EXCEPTION_INPUT_PAIR_MATCHING));
	}

	public static boolean isExistPairMatching(String course, String level, String mission) {
		for (PairMatching pairMatching : pairMatchingList) {
			if (pairMatching.isSame(course, level, mission)) {
				return true;
			}
		}
		return false;
	}

	public static List<MatchingCrew> createMatchingCrews(String course) {
		List<MatchingCrew> matchingCrewList = new ArrayList<>();
		List<Crew> crewList = getCrewList(course);
		if ((crewList.size() % 2) == 0) {
			for (int i = 0; i < crewList.size() - 1; i += 2) {
				matchingCrewList.add(new MatchingCrew(crewList.get(i), crewList.get(i + 1)));
			}
			return matchingCrewList;
		}
		for (int i = 0; i < crewList.size() - 3; i += 2) {
			matchingCrewList.add(new MatchingCrew(crewList.get(i), crewList.get(i + 1)));
		}
		int crewListSize = crewList.size();
		matchingCrewList.add(new MatchingCrew(crewList.get(crewListSize - 3), crewList.get(crewListSize - 2),
			crewList.get(crewListSize - 1)));
		return matchingCrewList;
	}

	public static List<Crew> getCrewList(String course) {
		if (course.equals(BACK_END)) {
			return createCrewListForBackEnd(CrewRepository.getBackEndCrewList());
		}
		if (course.equals(FRONT_END)) {
			return createCrewListForFrontEnd(CrewRepository.getFrontEndCrewList());
		}
		throw new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 과정 입력 값 입니다.");
	}

	public static List<Crew> createCrewListForBackEnd(List<String> crewNameList) {
		List<Crew> crewList = new ArrayList<>();
		for (String crewName: Randoms.shuffle(crewNameList)) {
			crewList.add(new Crew(Course.BACKEND, crewName));
		}
		return crewList;
	}

	public static List<Crew> createCrewListForFrontEnd(List<String> crewNameList) {
		List<Crew> crewList = new ArrayList<>();
		for (String crewName: Randoms.shuffle(crewNameList)) {
			crewList.add(new Crew(Course.FRONTEND, crewName));
		}
		return crewList;
	}

	public static void reset() {
		pairMatchingList.clear();
	}
}
