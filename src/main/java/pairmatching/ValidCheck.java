package pairmatching;

import java.util.ArrayList;
import java.util.List;


public class ValidCheck {
		
		static Course matchCourse;
		static Level matchLevel;
		static String matchMission;
		
		// 입력받은값 3개로 분류하기
		public static Pair stringDivide() {
			while(true) {
				try {
					String inputString = Input.pairMatching();
					String[] threeSelct = inputString.split(",");
					threeStringCheck(threeSelct);
					checkPart(threeSelct[0]);
					checkLevel(threeSelct[1]);
					checkMission(matchLevel, threeSelct[2]);
					break;
				}catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());		
				}
			}
			Pair validList= new Pair(matchCourse, matchLevel, matchMission);
			
			return validList;
		}
		
		private static boolean threeStringCheck(String[] threeSelct) {
			if(threeSelct.length != 3) {
				throw new IllegalArgumentException("[ERROR]정확히 3가지를 선택하여 입력해주세요.");
			}
			return true;
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
			throw new IllegalArgumentException("[ERROR]백엔드 혹은 프론트엔드 과정만 입력가능합니다. ");
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
			throw new IllegalArgumentException("[ERROR]레벨1~레벨5 까지 올바른 레벨을 입력하세요.");
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
			throw new IllegalArgumentException("[ERROR]해당레벨에 없는 미션입니다");
		}
}
