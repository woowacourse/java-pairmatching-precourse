package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.input.Course;
import pairmatching.domain.input.FunctionType;
import pairmatching.domain.input.Level;
import pairmatching.domain.input.LevelMissionInfo;

public class InputView {
	private static final String NOTICE_INPUT_FUNCTION_NUMBER = "기능을 선택하세요.";
	private static final String NOTICE_INPUT_MATCHING_TARGET = "과정, 레벨, 미션을 선택하세요.";
	private static final String DIVIDER = "#############################################";

	public static String getFunctionNumber() {
		System.out.println(NOTICE_INPUT_FUNCTION_NUMBER);
		showFunctionList();
		return Console.readLine();
	}

	private static void showFunctionList() {
		for (FunctionType function : FunctionType.values()) {
			System.out.println(function);
		}
	}

	public static String getMatchingTarget(LevelMissionInfo levelMissionInfo) {
		showMatchingTargetOption(levelMissionInfo);
		System.out.println(NOTICE_INPUT_MATCHING_TARGET);
		return Console.readLine();
	}

	private static void showMatchingTargetOption(LevelMissionInfo levelMissionInfo) {
		System.out.println(DIVIDER);
		showCourse();
		showLevelAndMission(levelMissionInfo);
		System.out.println(DIVIDER);
	}

	private static void showCourse() {
		System.out.print("과정 : ");
		List<String> nameList = Arrays.stream(Course.values())
			.map(Course::getName)
			.collect(Collectors.toList());
		showNameList(nameList);
		System.out.println();
	}

	private static void showLevelAndMission(LevelMissionInfo levelMissionInfo) {
		System.out.println("미션 : ");
		Map<Level, List<String>> levelMissionMap = levelMissionInfo.getLevelMissionMap();
		for (Level level : levelMissionMap.keySet()) {
			System.out.print("  - " + level.getName() + ": ");
			if (levelMissionMap.get(level) != null)
				showNameList(levelMissionMap.get(level));
			System.out.println();
		}

	}

	private static void showNameList(List<String> nameList) {
		System.out.print(String.join(" | ", nameList));
	}

}
