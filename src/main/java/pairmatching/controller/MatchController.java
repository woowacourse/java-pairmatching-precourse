package pairmatching.controller;

import java.util.ArrayList;

import pairmatching.model.CrewPair;
import pairmatching.model.Matcher;
import pairmatching.model.LevelSaver;
import pairmatching.model.MissionSaver;
import pairmatching.utils.FilePath;
import pairmatching.view.FileInputView;
import pairmatching.view.MatchingInputView;
import pairmatching.view.OutputView;

public class MatchController {
	private static final int LEVEL_INDEX = 1;
	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_CHAR_INDEX = 2;
	private static final int LEVEL_THREE = 3;
	private static final int LEVEL_FIVE = 5;
	private static final char CHAR_HELPER = '0';
	private static final String BASE = "백엔드";
	private static final String DELIMITER = ",";

	public static void match() {
		OutputView.MatchingOutput();
		String[] nowInput = MatchingInputView.getInput().split(DELIMITER);
		int level = nowInput[LEVEL_INDEX].charAt(LEVEL_CHAR_INDEX) - CHAR_HELPER;
		int count = 0;
		while (count < 3) {
			ArrayList<CrewPair> nowMatchResult = Matcher.match(FileInputView.readFile(getFileAddressByName(nowInput[COURSE_INDEX])));
			if (LevelSaver.LEVEL_SAVER.isValidMatch(nowMatchResult, level)) {
				System.out.println(generateKey(String.join(DELIMITER, nowInput)));
				MissionSaver.setPair(generateKey(String.join(DELIMITER, nowInput)), nowMatchResult);
				break;
			}
			count += 1;
		}
		show(generateKey(String.join(DELIMITER, nowInput)));
	}

	private static String getFileAddressByName (String input) {
		if (input.equals(BASE)) {
			return FilePath.BACK_END_FILE_ADDRESS.getAddress();
		}
		return FilePath.FRONT_END_FILE_ADDRESS.getAddress();
	}

	private static String generateKey(String input) {
		int level = input.split(DELIMITER)[LEVEL_INDEX].charAt(LEVEL_CHAR_INDEX) - CHAR_HELPER;
		if (level != LEVEL_THREE && level != LEVEL_FIVE) {
			return input;
		}
		return input.split(DELIMITER)[COURSE_INDEX] + DELIMITER + input.split(DELIMITER)[LEVEL_INDEX];
	}

	private static void show(String input) {
		OutputView.ResultOutput();
		for (CrewPair pair : MissionSaver.getPair(generateKey(input))) {
			System.out.println(pair);
		}
	}
}
