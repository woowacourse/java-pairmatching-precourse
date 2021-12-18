package pairmatching.model;

import static pairmatching.constant.constant.*;

import java.io.IOException;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.utils.PeopleReader;

public class Match {
	Course course;
	Level level;
	Mission mission;
	PeopleReader peopleReader;
	List<String> pair;

	public Match(Course course, Level level, Mission mission) throws IOException {
		this.course = course;
		this.level = level;
		this.mission = mission;
		this.peopleReader = new PeopleReader();
		this.pair = createPair(course);
	}

	public List<String> getPair() {
		return pair;
	}

	private List<String> createPair(Course course) {
		if (course.isSameName(BACKEND)) {
			return Randoms.shuffle(peopleReader.getBackEnd());
		}
		if (course.isSameName(FRONTEND)) {
			return Randoms.shuffle(peopleReader.getFrontEnd());
		}
		return null;
	}

	public boolean isSame(String courseName, String levelName, String missionName) {
		return course.isSameName(courseName) && level.isSameName(levelName) && mission.isSameName(missionName);
	}
}
