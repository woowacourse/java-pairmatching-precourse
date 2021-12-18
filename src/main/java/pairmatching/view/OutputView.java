package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;

import pairmatching.domain.Level;
import pairmatching.domain.Member;
import pairmatching.domain.Pair;
import pairmatching.service.MissionService;

public class OutputView {
	private static final String ERROR = "[ERROR]";

	public static void printExceptionMessage(String message) {
		System.out.println(ERROR + message);
	}

	public static void printStatus(MissionService missionService) {
		System.out.println("\n#############################################");
		System.out.println("과정: 백엔드 | 프론트엔드");
		System.out.println("미션");
		for (Level value : Level.values()) {
			System.out.print("  - " + value.getLevel() + ": ");
			System.out.println(String.join(" | ", missionService.getMissionNamesByLevel(value)));
		}
		System.out.println("#############################################");
	}

	public static void printInitializeMessage() {
		System.out.println("\n초기화 되었습니다.\n");
	}

	public static void printPairs(List<Pair> pairs) {
		System.out.println("페어 매칭 결과입니다.");
		for (Pair pair : pairs) {
			List<String> memberNames = pair.getMembers().stream()
				.map(Member::getName).collect(Collectors.toList());
			System.out.println(String.join(" : ", memberNames));
		}
		System.out.println();
	}
}
