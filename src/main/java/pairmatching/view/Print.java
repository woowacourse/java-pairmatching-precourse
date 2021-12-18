package pairmatching.view;

import java.util.ArrayList;
import pairmatching.model.Missions;
import pairmatching.type.Notice;
import pairmatching.type.Course;
import pairmatching.type.Level;

public class Print {
	private static Level[] levels = Level.values();

	private static ArrayList<String> getCourseNames() {
		ArrayList<String> courses = new ArrayList<>();
		for (Course course : Course.values()) {
			courses.add(course.getName());
		}
		return courses;
	}

	public static void printSelectFunction() {
		System.out.println(Notice.SELECT_FUNCTION.getString());
	}

	public static void printWoowaCourseInfo() {
		System.out.println();
		System.out.println(Notice.WOOWACOURSE_INFO_START.getString());
		System.out.print(Notice.WOOWACOURSE_COURSE_TITLE.getString());
		System.out.println(String.join(Notice.WOOWACOURSE_INFO_SPLIT.getString(), getCourseNames()));

		System.out.println(Notice.WOOWACOURSE_MISSION_TITLE.getString());
		for (Level level : levels) {
			printWoowaCourseMission(level);
		}
		System.out.println(Notice.WOOWACOURSE_INFO_END.getString());
	}

	private static void printWoowaCourseMission(Level level) {
		System.out.print(Notice.WOOWACOURSE_INFO_LIST.getString() + level.getName() + Notice.EQUALS.getString());

		ArrayList<String> missions = Missions.missions.get(level);
		System.out.println(String.join(Notice.WOOWACOURSE_INFO_SPLIT.getString(), missions));
	}
}
