package pairmatching.maching;

import static pairmatching.maching.MachingRepository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.crew.Crew;
import pairmatching.crew.CrewService;
import pairmatching.edu.Course;
import pairmatching.edu.Level;

public class MachingService {
	private final CrewService crewService = new CrewService();

	public List<Pair> makeMaching(Course course, Level level, String mission) {
		List<Crew> suffledMemberList = crewService.getSuffledCrewList(course);
		int size = suffledMemberList.size();
		List<Pair> pairList = addPairList(suffledMemberList, size);
		addMathing(new Maching(course, level, mission, pairList));
		return pairList;
	}

	private List<Pair> addPairList(List<Crew> suffledMemberList, int size) {
		int lastIdx = size - 2;
		List<Pair> pairList = new ArrayList<>();
		for (int i = 0; i < size - 3; i += 2) {
			pairList.add(new Pair(suffledMemberList.subList(i, i + 2)));
		}
		if (size % 2 == 1) {
			lastIdx = size - 3;
		}
		pairList.add(new Pair(suffledMemberList.subList(lastIdx, size)));
		return pairList;
	}

	public List<String> splitCourseLevelMission(String input) {
		return Arrays.asList(input.split(", "));
	}

	public boolean isExist(Course course, Level level, String mission) {

		return existByCourseLevelMission(course, level, mission);
	}

	public void initMaching() {
		deleteAll();
	}
}
