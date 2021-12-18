package pairmatching.domain.repository;

import static pairmatching.domain.repository.CrewRepository.*;

import java.util.ArrayList;
import java.util.List;

import com.sun.glass.ui.Window;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingCrew;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMatching;

public class PairMatchingRepository {
	List<PairMatching> pairMatchingList;

	public void add(String course, String level, String mission) {
		List<MatchingCrew> crewList = createMatchingCrews(course);
		pairMatchingList.add(new PairMatching(Course.find(course), new Mission(Level.find(level), mission), crewList));
	}

	public List<MatchingCrew> createMatchingCrews(String course) {
		List<MatchingCrew> matchingCrewList =  new ArrayList<>();
		List<Crew> crewList = Randoms.shuffle(getCrewList(course));
		if ((crewList.size() % 2) == 0) {
			for (int i = 0; i < crewList.size()-1; i++) {
				matchingCrewList.add(new MatchingCrew(crewList.get(i), crewList.get(i+1)));
			}
			return matchingCrewList;
		}
		for (int i = 0; i < crewList.size() - 3; i++) {
			matchingCrewList.add(new MatchingCrew(crewList.get(i), crewList.get(i+1)));
		}
		int crewListSize = crewList.size();
		matchingCrewList.add(new MatchingCrew(crewList.get(crewListSize - 3), crewList.get(crewListSize - 2), crewList.get(crewListSize - 1)));
		return matchingCrewList;
	}


	private List<Crew> getCrewList(String course) {
		if (course.equals("백엔드")) {
			return getBackEndCrewList();
		}
		if (course.equals("프론트엔드")) {
			return getFrontEndCrewList();
		}
		throw new IllegalArgumentException("올바르지 않은 과정 입력 값 입니다.");
	}

}
