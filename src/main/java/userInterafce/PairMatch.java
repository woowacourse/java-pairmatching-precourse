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
import pairmatching.Mission;
import pairmatching.PairStorage;
import utils.WrongTwoCommaWithLetter;

public class PairMatch {
	Crews crews = new Crews();
	PrintInterface printer = new PrintInterface();

	public PairMatch() {
	}

	public void run() {
		printer.printCourseAndMission();
		printer.printInputCourseLevelMission();
		getArrWithSplitCommaBlank(getCourseAndLevelAndMission());
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

	private String[] getArrWithSplitCommaBlank(String input) {
		String[] stringArrOfCourseLevelMission = input.split(", ");
		if (checkEachOfCourseLevelMission(stringArrOfCourseLevelMission)) {
			return stringArrOfCourseLevelMission;
		}
		throw new IllegalArgumentException("[ERROR] 올바른 과정,레벨,미션 입력이 아닙니다.");
	}

	private boolean checkEachOfCourseLevelMission(String[] stringArrOfCourseLevelMission) {
		String courseName = stringArrOfCourseLevelMission[0];
		String levelName = stringArrOfCourseLevelMission[1];
		String MissionName = stringArrOfCourseLevelMission[2];

		return isCourseName(courseName)
			&& isLevelName(levelName)
			&& isMissionName(MissionName, levelName);
	}

	private boolean isCourseName(String courseName) {
		for (Course course : Course.values()) {
			if (course.toString().equals(courseName)) {
				return true;
			}
		}
		throw new IllegalArgumentException("[ERROR] 과정 이름이 잘못되었습니다.");
	}

	private boolean isLevelName(String levelName) {
		for (Level level : Level.values()) {
			if (level.toString().equals(levelName)) {
				return true;
			}
		}
		throw new IllegalArgumentException("[ERROR] 레벨 이름이 잘못되었습니다.");
	}

	private boolean isMissionName(String missionName, String levelName) {
		for (Mission mission : Mission.values()) {
			if (mission.toString().equals(missionName)
				&& matchesMissionAndLevel(mission, levelName)) {
				return true;
			}
		}
		throw new IllegalArgumentException("[ERROR] 미션 이름이 잘못되었습니다.");
	}

	private boolean matchesMissionAndLevel(Mission mission, String levelName) {
		if (mission.getLevel().toString().equals(levelName)) {
			return true;
		}
		throw new IllegalArgumentException("[ERROR] 미션과 레벨이 잘못 매치되었습니다.");
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
