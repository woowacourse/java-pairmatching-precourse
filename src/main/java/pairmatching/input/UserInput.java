package pairmatching.input;

import pairmatching.model.Course;
import pairmatching.model.Function;
import pairmatching.model.Level;
import pairmatching.model.Mission;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

	private static final String DELIM = ",";
	public static final int COURSE_INDEX = 0;
	public static final int LEVEL_INDEX = 1;
	public static final int MISSION_INDEX = 2;

	public Function getFunction() {
		String inputKey = readLine();
		return Function.getFunctionByKey(inputKey);
	}

	public String getCourseLevelMission() {
		String input = readLine();
		List<String> names = Arrays.asList(input.replace(" ", "").split(DELIM));
		Course.getCourseByName(names.get(COURSE_INDEX));
		Level.getLevelByName(names.get(LEVEL_INDEX));
		Mission.getMissionByName(names.get(MISSION_INDEX));
		return input;
	}
}
