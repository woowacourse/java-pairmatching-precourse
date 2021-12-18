package userInterafce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.Course;
import pairmatching.Crew;
import pairmatching.Crews;
import pairmatching.Level;
import pairmatching.Mission;
import pairmatching.PairStorage;

public class PairMatch {
	Crews crews = new Crews();
	PairMatch() {
		this.crews = crews;
	}

	public void run() {
		new printCourseAndMission().print();
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

	class printCourseAndMission {
		public void print() {
			String lineDistinguish = "#############################################";
			System.out.println(lineDistinguish);
			printCourse();
			printMission();
			System.out.println(lineDistinguish);
		}

		private void printCourse() {
			List<String> courseNameList = new ArrayList<>();
			for (Course course : Course.values()) {
				courseNameList.add(course.toString());
			}
			String courseListAsString = String.join(" | ", courseNameList);
			System.out.printf("과정: %s\n", courseListAsString);
		}

		private void printMission() {
			System.out.println("미션:");
			for (Level level:Level.values()) {
				printMissionByLevel(level);
			}
		}

		private void printMissionByLevel(Level level) {
			List<String> missionNameList = new ArrayList<>();
			for (Mission mission : Mission.getMissionListByLevel(level)) {
				missionNameList.add(mission.toString());
			}

			String courseListAsString = String.join(" | ", missionNameList);
			System.out.printf("  - %s: %s\n",level.toString(), courseListAsString);
		}
	}
}
