package pairmatching.view;

import static pairmatching.constant.ViewMessage.*;

import pairmatching.domains.mission.Course;
import pairmatching.domains.mission.Level;
import pairmatching.domains.programfunc.ProgramSelection;

public class OutputView {

	public static void printSelection() {
		System.out.println(SELECTION_MESSAGE);
		for (ProgramSelection selection : ProgramSelection.values()) {
			String selectForm = selection.getSelectForm();
			System.out.println(selectForm);
		}
	}

	public static void printTechCourseState() {
		System.out.println(LINE_BREAK
			+ STATE_MESSAGE_WRAPPER + LINE_BREAK
			+ Course.getCourseView() + LINE_BREAK
			+ MISSION_PREFIX + LINE_BREAK
			+ Level.getLevelView()
			+ STATE_MESSAGE_WRAPPER
		);
		printInputExample();
	}

	private static void printInputExample() {
		System.out.println(MISSION_SELECT_MESSAGE);
		System.out.println(MISSION_SELECT_EXAMPLE);
	}
}
