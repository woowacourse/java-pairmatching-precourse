package pairmatching.util;

import java.util.ArrayList;
import java.util.List;

import pairmatching.type.Course;
import pairmatching.type.Crew;

public class CrewUtil {
	public static List<Crew> generateCrewList(List<String> crewNameList, Course course) {
		List<Crew> crewList = new ArrayList<Crew>();
		for(String crewName: crewNameList) {
			crewList.add(new Crew(course, crewName));
		}
		return crewList;
	}
}
