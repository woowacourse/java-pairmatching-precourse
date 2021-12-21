package pairmatching;

import java.util.ArrayList;
import java.util.List;


public class ValidCheck {
		
		static Course matchCourse;
		static Level matchLevel;
		static String matchMission;
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
		private static boolean checkPart(String course) {
			String part = course.trim();
			if (part.equals(Course.BACKEND.getCourse())) {
				matchCourse = Course.BACKEND;
				return true;
			}
			if (part.equals(Course.FRONTEND.getCourse())) {
				matchCourse = Course.FRONTEND;
				return true;
			}
			// 에러메시지
			throw new IllegalArgumentException("[ERROR]");
		}

		// 레벨체크
		private static boolean checkLevel(String level) {
			String Lv= level.trim();
			for (Level stage : Level.values()) {
				if (stage.getLevel().equals(Lv)) {
					matchLevel = stage;
					return true;
				}
			}
			// 에러메시지
			throw new IllegalArgumentException("[ERROR]");
		}

		
		// 미션 체크
		private static boolean checkMission(Level level, String mission) {
			ArrayList<String> missionList = level.getMission();
			for (String m : missionList) {
				if (m.equals(mission.trim())) {
					matchMission = mission;
					return true;
				}
			}
			// 에러메시지

			throw new IllegalArgumentException("[ERROR]");
		}
}
