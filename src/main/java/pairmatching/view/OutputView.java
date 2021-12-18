package pairmatching.view;

import pairmatching.controller.MatchingController;
import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.util.HostMessage;

public class OutputView {
	public static void askFunction() {
		System.out.println(HostMessage.ASK_FUNCTION);
		System.out.println(HostMessage.FUNCTION_1);
		System.out.println(HostMessage.FUNCTION_2);
		System.out.println(HostMessage.FUNCTION_3);
		System.out.println(HostMessage.FUNCTION_Q);
	}

	public static void askMatchingInfo() {
		System.out.println("\n" + HostMessage.LINE_SEPARATOR);
		showCourse();
		showMission();
		System.out.println(HostMessage.LINE_SEPARATOR);
		System.out.println(HostMessage.ASK_MATCHING_INFO);
		System.out.println(HostMessage.SHOW_MATCHING_INFO_EX);
	}

	public static void showCourse() {
		System.out.println(HostMessage.SHOW_COURSE + Course.BACKEND.getName() + " | " + Course.FRONTEND.getName());
	}

	public static void showMission() {
		System.out.println(HostMessage.SHOW_MISSION);
		int mission_num = 0;
		for (Level level : Level.values()) {
			System.out.println("  - " + level.getName() + HostMessage.MISSION_NAMES[mission_num]);
			mission_num++;
		}
	}

	public static void showMatchingResult() {
		System.out.println("\n" + HostMessage.SHOW_MATCHING_RESULT);
		for (String pair : MatchingController.pairs) {
			System.out.println(pair);
		}
		System.out.println();
	}

	public static void alertInit() {
		System.out.println("\n" + HostMessage.ALERT_INIT);
	}
}
