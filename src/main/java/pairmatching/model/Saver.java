package pairmatching.model;

import java.util.ArrayList;

public class Saver {

	private static final int SIZE = 5;
	private static ArrayList<CrewPair>[] savedResult = new ArrayList[SIZE];

	public static boolean isValidMatch(ArrayList<CrewPair> matchResult, int levelIndex) {
		for (CrewPair eachPair : matchResult) {
			int duplicateCount = (int)savedResult[levelIndex].stream()
				.filter(nowPair -> nowPair.isSame(eachPair.getJoinedName()))
				.count();
			if (duplicateCount > 0) {
				return false;
			}
		}
		return true;
	}

	public static void setMatch(ArrayList<CrewPair> matchResult, int levelIndex) {
		savedResult[levelIndex] = matchResult;
	}
}
