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

	public static List<List<Crew>> generatePairList(List<Crew> crewList) {
		List<List<Crew>> pairList = new ArrayList<List<Crew>>();
		for(int i=0;i<crewList.size();i = i+2) {
			List<Crew> pair = new ArrayList<>();
			pair.add(crewList.get(i));
			try {
				pair.add(crewList.get(i+1));
				pairList.add(pair);
			} catch (IndexOutOfBoundsException exception) {
				pairList.get(pairList.size()-1).addAll(pair);
			}
		}
		return pairList;
	}
}
