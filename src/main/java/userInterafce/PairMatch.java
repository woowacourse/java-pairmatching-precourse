package userInterafce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.Course;
import pairmatching.Crew;
import pairmatching.Crews;
import pairmatching.Level;
import pairmatching.PairStorage;
import utils.WrongTwoCommaWithLetter;

public class PairMatch {
	Crews crews = new Crews();
	PairMatch() {
		this.crews = crews;
	}

	public void run() {
		new PrintInterface().printCourseAndMission();

	}

	private String getCourseAndLevelAndMission() {
		String input = "";
		try {
			input = Console.readLine();
			new WrongTwoCommaWithLetter().check(input);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
		}
		return input;
	}

	boolean isDone () {
		return true;
	}

	public void matchOneByOne(String name) {


	}

	public HashSet<Crew> getSetOfCrewLevel(Crew crew, Level level) {
		HashMap<Course, HashMap> pairMap = PairStorage.getPairMap();
		HashMap<Level, HashSet<Crew>> crewMap = pairMap.get(crew);
		HashSet<Crew> crewLevelSet = crewMap.get(level);
		return crewLevelSet;
	}

	public List<String> getShuffledCrewList(Course course) {
		List<String> crewNameList = getCrewList(course);
		crewNameList = Randoms.shuffle(crewNameList);

		return crewNameList;
	}

	public List<String> getCrewList(Course course) {
		List<String> crewNameList = new ArrayList<>();

		for (Crew crew : crews.getCrewList()) {
			if (crew.getCourse().equals(course)) {
				crewNameList.add(crew.toString());
			}
		}

		return crewNameList;
	}

}
