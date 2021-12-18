package pairmatching;

import java.util.ArrayList;
import java.util.List;


public class ValidCheck {
		
		static Course matchCourse;
		static Level matchLevel;
		static String matchMission;
		static List<Crew> CrewMatching;
		// 입력받은값 3개로 분류하기
		public static Pair Stringdivide(String input) {
			
			String[] threeSelct = input.split(",");
			checkPart(threeSelct[0]);
			checkLevel(threeSelct[1]);
			checkMission(matchLevel, threeSelct[2]);
			Pair validList= new Pair(matchCourse, matchLevel, matchMission);
			return validList;
		}

		// 프론트/백 체크
		private static void checkPart(String course) {
			String part = course.trim();
			if (part.equals(Course.BACKEND.getCourse())) {
				matchCourse = Course.BACKEND;
			}
			if (part.equals(Course.FRONTEND.getCourse())) {
				matchCourse = Course.FRONTEND;
			}
			// 에러메시지
			throw new IllegalArgumentException();
		}

		// 레벨체크
		private static void checkLevel(String level) {
			String Lv= level.trim();
			for (Level stage : Level.values()) {
				if (stage.getLevel().equals(Lv)) {
					matchLevel = stage;
				}
			}
			// 에러메시지
			throw new IllegalArgumentException();
		}

		
		// 미션 체크
		private static void checkMission(Level level, String mission) {
			ArrayList<String> missionList = level.getMission();
			for (String m : missionList) {
				if (m.equals(mission)) {
					matchMission = mission;
				}
			}
			// 에러메시지
			throw new IllegalArgumentException();
		}
}
