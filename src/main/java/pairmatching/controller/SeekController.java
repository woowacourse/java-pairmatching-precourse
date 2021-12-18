package pairmatching.controller;

import java.util.ArrayList;

import pairmatching.model.CrewPair;
import pairmatching.model.LevelSaver;
import pairmatching.model.MissionSaver;
import pairmatching.view.MatchingInputView;
import pairmatching.view.OutputView;

public class SeekController {
	private static final int LEVEL_INDEX = 1;
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_CHAR_INDEX = 2;
	private static final int LEVEL_THREE = 3;
	private static final int LEVEL_FIVE = 5;
	private static final char CHAR_HELPER = '0';
	private static final String BASE = "백엔드";
	private static final String DELIMITER = ", ";

	public static void seek() {
		OutputView.MatchingOutput();
		String[] nowInput = MatchingInputView.getInput().split(DELIMITER);
		int level = nowInput[LEVEL_INDEX].charAt(LEVEL_CHAR_INDEX) - CHAR_HELPER;
		if (level != LEVEL_THREE && level != LEVEL_FIVE) {
			ArrayList<CrewPair> nameList = MissionSaver.getPair(String.join(DELIMITER, nowInput));
			for (CrewPair eachPair : nameList) {
				System.out.println(eachPair);
			}
			return;
		}
		String key = nowInput[COURSE_INDEX] + DELIMITER + nowInput[LEVEL_INDEX];
		ArrayList<CrewPair> nameList = MissionSaver.getPair(String.join(DELIMITER, key));
		for (CrewPair eachPair : nameList) {
			System.out.println(eachPair);
		}
	}
}
