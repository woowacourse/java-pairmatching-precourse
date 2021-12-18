package pairmatching.model;

import java.util.ArrayList;
import java.util.HashMap;

public class MissionSaver {

	private static HashMap<String, ArrayList<CrewPair>> totalResult = new HashMap<>();

	public static void setPair(String key, ArrayList<CrewPair> pairResult) {
		totalResult.put(key, pairResult);
	}

	public static ArrayList<CrewPair> getPair(String key) {
		if (totalResult.containsKey(key)) {
			return totalResult.get(key);
		}
		return new ArrayList<>();
	}
}
