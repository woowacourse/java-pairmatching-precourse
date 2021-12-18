package userInterafce;

import java.util.ArrayList;
import java.util.List;

import pairmatching.Course;
import pairmatching.Level;
import pairmatching.Mission;

public class PrintInterface {
	public void printInputCourseLevelMission() {
		System.out.println("과정, 레벨, 미션을 선택하세요.");
		System.out.println("ex) 백엔드, 레벨1, 자동차경주");
	}

	public void printCourseAndMission() {
		new CourseAndMission().print();
	}

	private class CourseAndMission {
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
