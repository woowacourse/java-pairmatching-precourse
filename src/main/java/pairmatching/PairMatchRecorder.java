package pairmatching;

import java.util.HashMap;
import java.util.Map;

public class PairMatchRecorder {
	private Course course;
	private Level level;
	private String mission;
	private HashMap<String, String> pairMatchMap;

	PairMatchRecorder(Course course, Level level, String mission){
		this.course=course;
		this.level = level;
		this.mission = mission;
	}

	public boolean checkDuplicatedPair(HashMap<String, String> pairMap){
		for(Map.Entry<String, String> pair : pairMap.entrySet()){
			String key = pair.getKey();

			if(this.pairMatchMap.get(key) == pair.getValue()){
				return false;
			}
		}
		return true;
	}
}
