package pairmatching;

import java.util.HashMap;
import java.util.Map;

public class PairMatchRecorder {
	private Course course;
	private Level level;
	private String mission;
	private HashMap<String, String> pairMatchHistory;

	PairMatchRecorder(Course course, Level level, String mission){
		this.course=course;
		this.level = level;
		this.mission = mission;
	}

	private boolean checkDuplicatedPair(HashMap<String, String> recentMatchedPair){
		for(Map.Entry<String, String> entry : recentMatchedPair.entrySet()){
			String key = entry.getKey();

			if(pairMatchHistory.get(key) == entry.getValue()){
				return false;
			}
		}

		return true;
	}
}
