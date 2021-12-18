package userInterafce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
	private Crews crews = new Crews();
	private PrintInterface printer = new PrintInterface();
	PairStorage pairs;
	private HashMap<Crew,Crew> missionMap;
	private Course course;
	private Level level;
	private Mission mission;

	public PairMatch(PairStorage pairs) {
		this.pairs = pairs;
	}

	public void run() {
		printer.printCourseAndMission();
		printer.printInputCourseLevelMission();
		boolean passed = false;
		while (!passed) {
			getArrWithSplitCommaBlank(getCourseAndLevelAndMission());
			passed = true;
		}
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
		try {
			checkEachOfCourseLevelMission(stringArrOfCourseLevelMission);
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
		}
		return stringArrOfCourseLevelMission;
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
				this.course = course;
				return true;
			}
		}
		throw new IllegalArgumentException("[ERROR] 과정 이름이 잘못되었습니다.");
	}

	private boolean isLevelName(String levelName) {
		for (Level level : Level.values()) {
			if (level.toString().equals(levelName)) {
				this.level = level;
				return true;
			}
		}
		throw new IllegalArgumentException("[ERROR] 레벨 이름이 잘못되었습니다.");
	}

	private boolean isMissionName(String missionName, String levelName) {
		for (Mission mission : Mission.values()) {
			if (mission.toString().equals(missionName)
				&& matchesMissionAndLevel(mission, levelName)) {
				this.mission = mission;
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

	public void makeNewPairs() {
		if (isNotExist(course,mission)) {
			List<String> crewArr = getShuffledCrewList(course);
			Iterator<String> crewNameIterator = crewArr.iterator();
			matchOneByOne(crewNameIterator);
		}
		printPairList();
	}

	private boolean isNotExist(Course course, Mission mission) {
		HashMap<Course, HashMap> pairMap = PairStorage.getPairMap();
		HashMap<Mission, HashMap> pairMapWithCourse = pairMap.get(course);
		missionMap = pairMapWithCourse.get(mission);

		return missionMap.isEmpty();
	}

	private  boolean isDone () {
		return true;
	}


	Crew crew1;
	Crew crew2;
	Crew crew3;

	private void printPairList() {
		HashSet<String> nameSet = new HashSet<>();
		for (Crew crew : missionMap.keySet()) {
			String name1 = crew.toString();
			Crew otherCrew = missionMap.get(name1);
			String name2 = otherCrew.toString();
			if (nameSet.contains(name1) || nameSet.contains(name2)){
				continue;
			}
			nameSet.add(name1);
			nameSet.add(name2);

			System.out.printf("%s : %s\n" , name1, name2);
		}
	}

	private void matchOneByOne(Iterator<String> crewNameIterator) {
		while(crewNameIterator.hasNext()) {
			String name1 = crewNameIterator.next();
			crew1 =  crews.getCrewByCourseAndName(course, name1);
			if ((crewNameIterator.hasNext())) {
				String name2 = crewNameIterator.next();
				crew2 =  crews.getCrewByCourseAndName(course, name1);
				missionMap.put(crew1,crew2);
				missionMap.put(crew2,crew1);
				crew3 = crew1;
				return;
			} else if (!crewNameIterator.hasNext()) {
				setOddCrew();
			}
		}
	}

	private void setOddCrew() {
		missionMap.put(crew1,crew3);
		missionMap.put(crew3,crew1);
		missionMap.put(crew2,crew3);
		missionMap.put(crew3,crew2);
	}

	private HashSet<Crew> getSetOfCrewLevel(Crew crew, Level level) {
		HashMap<Course, HashMap> pairMap = PairStorage.getPairMap();
		HashMap<Level, HashSet<Crew>> crewMap = pairMap.get(crew);
		HashSet<Crew> crewLevelSet = crewMap.get(level);
		return crewLevelSet;
	}

	private List<String> getShuffledCrewList(Course course) {
		List<String> crewNameList = getCrewList(course);
		crewNameList = Randoms.shuffle(crewNameList);

		return crewNameList;
	}

	private List<String> getCrewList(Course course) {
		List<String> crewNameList = new ArrayList<>();

		for (Crew crew : crews.getCrewList()) {
			if (crew.getCourse().equals(course)) {
				crewNameList.add(crew.toString());
			}
		}
		return crewNameList;
	}
}
