package pairmatching.domain.matching;

import java.util.HashMap;
import java.util.Map;

import pairmatching.domain.Course;

public class MatchingFactory {

	private static Map<MatchingType, Matching> matchingListMap = new HashMap<>();

	public static void insertMatchingList(MatchingType type, Course course){
		matchingListMap.clear();
		Matching matching = new Matching(type);
		matching.insertMatchingList(course);
		matchingListMap.put(type, matching);
	}

	public static Matching getMatching(MatchingType type){
		return matchingListMap.get(type);

	}

}
