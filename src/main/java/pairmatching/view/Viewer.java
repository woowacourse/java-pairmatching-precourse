package pairmatching.view;

import pairmatching.model.Course;
import pairmatching.model.Function;
import pairmatching.model.Level;
import pairmatching.model.LevelMissionsMap;

import java.util.List;

public class Viewer {

	public void showFunctions() {
		System.out.println("기능을 선택하세요.");
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
}
