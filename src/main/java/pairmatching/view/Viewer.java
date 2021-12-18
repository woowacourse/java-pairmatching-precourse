package pairmatching.view;

import pairmatching.model.*;

import java.util.List;
import java.util.stream.Collectors;

public class Viewer {

	public void showFunctions() {
		System.out.println("\n기능을 선택하세요.");
		List<Function> functions = Function.getFunctions();
		for (Function function : functions) {
			System.out.println(function.toString());
		}
	}

	public void showCourseAndMissions(LevelMissionsMap levelMissionsMap) {
		System.out.println("\n############################################");
		System.out.println("과정: " + Course.courseNamesToString());
		System.out.println("미션: ");
		List<Level> levels = Level.getLevels();
		for (Level level : levels) {
			System.out.println("  - " + level.getName() + ": " + levelMissionsMap.missionsToString(level));
		}
		System.out.println("############################################");
		System.out.println("과정, 레벨, 미션을 선택하세요.");
	}

	public void showCrewPairs(List<String> crewPairs) {
		System.out.println("\n페어 매칭 결과입니다.");
		String result = crewPairs.stream().collect(Collectors.joining("\n"));
		System.out.println(result);
	}
}
