package pairmatching.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.Domain.Course;
import pairmatching.Domain.Level;
import pairmatching.Domain.Mission;

public class OutputView {
	private static final String DIVIDE_LINE = "#############################################";

	public static void printProgramInfo(List<Mission> missionList) {
		System.out.println(DIVIDE_LINE);
		System.out.print("과정: ");
		System.out.println(Arrays.stream(Course.values()).map(Course::getName).collect(Collectors.joining(" | ")));
		System.out.println("미션:");
		for (Level level : Arrays.stream(Level.values()).collect(Collectors.toList())) {
			System.out.print(level.toString());
			System.out.println(missionList.stream()
				.filter(mission -> mission.levelCheck(level))
				.map(Mission::getName)
				.collect(Collectors.joining(" | ")));
		}
		System.out.println(DIVIDE_LINE);
	}

	public static void printExistPair() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
	}
	public static void printPairResult(List<String> nameList) {
		if (nameList.size() % 2 == 0) {
			for (int i = 0; i < nameList.size(); i += 2) {
				System.out.println(nameList.get(i) + " : " + nameList.get(i + 1));
			}
			return;
		}
		for (int i = 0; i < nameList.size() - 3; i += 2) {
			System.out.println(nameList.get(i) + " : " + nameList.get(i + 1));
		}
		System.out.println(nameList.get(nameList.size() - 3) + " : " + nameList.get(nameList.size() - 2) + " : " + nameList.get(nameList.size() - 1));
	}
}
