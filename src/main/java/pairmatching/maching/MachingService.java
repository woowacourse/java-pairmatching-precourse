package pairmatching.maching;

import static pairmatching.maching.MachingRepository.*;

import java.util.ArrayList;
import java.util.List;

import pairmatching.crew.Crew;
import pairmatching.crew.CrewService;
import pairmatching.edu.Course;
import pairmatching.edu.Level;

public class MachingService {
	private final CrewService crewService = new CrewService();

	public void makeMaching(Course course, Level level) {
		List<Crew> suffledMemberList = crewService.getSuffledCrewList(course);
		List<Pair> pairList = new ArrayList<>();
		int size = suffledMemberList.size();
		int lastIdx = size - 2;

		for (int i = 0; i < size - 3; i += 2) {
			pairList.add(new Pair(suffledMemberList.subList(i, i + 2)));
		}
		if (size % 2 == 1) {
			lastIdx = size - 3;
		}
		pairList.add(new Pair(suffledMemberList.subList(lastIdx, size)));
		addMathing(new Maching(course, level, pairList));
	}
}
