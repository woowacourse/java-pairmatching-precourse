package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.utils.Constant;
import pairmatching.utils.CourseLevelMissionSpliter;
import pairmatching.utils.Function;
import pairmatching.domain.Mission;
import pairmatching.domain.MissionRepository;

public class InputView {
	public static Function getInputOfFunctionType() {
		try {
			OutputView.printFunctionType();
			Function function = Function.of(Console.readLine());
			return function;
		} catch (IllegalArgumentException e) {
			System.out.println(Constant.ERROR + e.getMessage());
			return getInputOfFunctionType();
		}
	}

	public static Mission getInputOfCourseAndLevelAndMission() {
		try {
			OutputView.printCourseAndLevelAndMission();
			String courseLevelMission = Console.readLine();
			return MissionRepository.findMissionByName(CourseLevelMissionSpliter.split(courseLevelMission));
		} catch (IllegalArgumentException e) {
			System.out.println(Constant.ERROR + e.getMessage());
			return getInputOfCourseAndLevelAndMission();
		}
	}
}
