package pairmatching.processor;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class OutputProcessor {
	private static final String CROSS_HATCH_CONTINUOUS = "#############################################";
	private static final String COURSE_MESSAGE = "과정: ";
	private static final String MISSION_MESSAGE = "미션:\n";
	private static final String PAIR_INTERFACE_SELECT_MESSAGE = "과정, 레벨, 미션을 선택하세요.";
	private static final String PAIR_INTERFACE_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";


	public void printPairInterface() {
		System.out.println(CROSS_HATCH_CONTINUOUS);
		System.out.println(getCourses());
		System.out.println(getMissions());
		System.out.println(CROSS_HATCH_CONTINUOUS);
		System.out.println(PAIR_INTERFACE_SELECT_MESSAGE);
		System.out.println(PAIR_INTERFACE_EXAMPLE);
	}

	private String getMissions() {
		StringBuilder sb = new StringBuilder(MISSION_MESSAGE);
		Level[] levels = Level.values();
		for(int iterator = 0; iterator < levels.length ; iterator++) {
			Level level = levels[iterator];
			sb.append(getMission(level)).append(getLine(iterator, levels.length));
		}
		return sb.toString();
	}

	private String getMission(Level level) {
		StringBuilder sb = new StringBuilder("- "+level.getTitle()+": ");
		List<Mission> missionByLevel = Mission.getMissionByLevel(level);
		for(int iterator = 0; iterator < missionByLevel.size(); iterator++) {
			String missionTitle = missionByLevel.get(iterator).getTitle();
			sb.append(missionTitle).append(getSeparator(iterator, missionByLevel.size()));
		}
		return sb.toString();
	}

	private String getCourses() {
		StringBuilder sb = new StringBuilder(COURSE_MESSAGE);
		Course[] courses = Course.values();
		for(int iterator = 0; iterator<courses.length; iterator++) {
			String courseTitle = courses[iterator].getTitle();
			sb.append(courseTitle).append(getSeparator(iterator, courses.length));
		}
		return sb.toString();
	}

	private String getSeparator(int iterator, int length) {
		if(iterator != length-1) {
			return " | ";
		}
		return "";
	}

	private String getLine(int iterator, int length) {
		if(iterator != length-1) {
			return "\n";
		}
		return "";
	}
}
