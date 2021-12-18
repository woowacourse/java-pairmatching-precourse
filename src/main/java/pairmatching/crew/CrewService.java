package pairmatching.crew;

import static pairmatching.View.Input.*;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.edu.Course;

public class CrewService {

	public List<Crew> getSuffledCrewList(Course course) {
		if (course.equals("백엔드")) {
			return Randoms.shuffle(makeCrewList(getBackMember(), course));
		}
		return Randoms.shuffle(makeCrewList(getFrontMember(), course));
	}

	public List<Crew> makeCrewList(List<String> nameList, Course course) {
		return nameList.stream()
			.map(name -> new Crew(course, name))
			.collect(Collectors.toList());
	}

}
