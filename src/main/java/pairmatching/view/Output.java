package pairmatching.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pairmatching.crew.Crew;
import pairmatching.edu.Course;
import pairmatching.edu.Level;
import pairmatching.maching.Pair;

public class Output {
	private final String CHOOSE_FEAT = "기능을 선택하세요.";
	private final String CHOOSE_COURSE_LEVEL_MISSION = "과정, 레벨, 미션을 선택하세요.";
	private final String FEAT_ONE = "1. 페어 매칭";
	private final String FEAT_TWO = "2. 페어 조회";
	private final String FEAT_THR = "3. 페어 초기화";
	private final String FEAT_FINISH = "Q. 종료";
	private final String MACHING_EXIST = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
	private final String LINE = "#############################################";

	public void chooseFeat() {
		System.out.println(CHOOSE_FEAT);
		System.out.println(FEAT_ONE);
		System.out.println(FEAT_TWO);
		System.out.println(FEAT_THR);
		System.out.println(FEAT_FINISH);
	}

	public void printPairMatching() {
		System.out.println("\n" + LINE);
		printCourse();
		printMission();
		System.out.println(LINE);
	}

	public void printChooseCourseLevelMission() {
		System.out.println(CHOOSE_COURSE_LEVEL_MISSION);
	}

	private void printCourse() {
		System.out.print("과정: ");
		System.out.println(Course.toStringAllNameSplit(" | "));
	}

	private void printMission() {
		System.out.println("미션:");
		Arrays.stream(Level.values())
			.forEach(level -> {
				System.out.print("  - " + level.getName() + ": ");
				System.out.println(String.join(" | ", level.getMissionList()));
			});
	}

	public void printExistMaching() {
		System.out.println(MACHING_EXIST);
		System.out.println("네 | 아니오");
	}

	public void printPairList(List<Pair> pairList) {
		System.out.println("\n페어 매칭 결과입니다.");
		pairList.forEach(s -> {
			System.out.println(
				String.join(" : ", s.getCrews().stream().map(Crew::getName).collect(Collectors.toList())));
		});
	}
}
