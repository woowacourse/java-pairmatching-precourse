package pairmatching.domain;

import java.util.HashMap;

public class Crew {
    private Course course;
    private String name;
    
    private static HashMap<String, String> matchingHistory= new HashMap<>();
    
    public static boolean getHistory(String course, String combination) {
    	//이미 course리스트에 해당조합 매칭 이력 있음
    	if(matchingHistory.getOrDefault(course,"").equals(combination))
    		return true;
    	matchingHistory.put(course, combination);
    	return false;
    }
    
}

