package pairmatching.model;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.utils.PeopleReader;

public class Match {
	Course course;
	Level level;
	Mission mission;
	List<String> pair;

	public Match(Course course, Level level, Mission mission) throws IOException {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.pair = createPair(course);
	}



	public boolean isSame(String courseName, String levelName, String missionName) {
		return course.isSameName(courseName) && level.isSameName(levelName) && mission.isSameName(missionName);
	}
}
