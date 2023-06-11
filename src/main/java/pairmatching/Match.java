package pairmatching;

import static camp.nextstep.edu.missionutils.Console.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Randoms;

public class Match {
	private static final String MENU = "기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료";
	private static final String ERRMESSAGE= "[ERROR] 잘못 입력하셨습니다.";
	private static final String MATCHPAIRHEAD = "#############################################\n"
										+ "과정: 백엔드 | 프론트엔드\n"
										+ "미션:\n"
										+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
										+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
										+ "  - 레벨3: \n"
										+ "  - 레벨4: 성능개선 | 배포\n"
										+ "  - 레벨5: \n"
										+ "############################################\n";
	private static final String CLECTMATCHPAIR = "과정, 레벨, 미션을 선택하세요.\n"
												+ "ex) 백엔드, 레벨1, 자동차경주";
	private static final String BACKENDPATH = "./src/main/resources/backend-crew.md";
	private static final String FRONTENDPATH = "./src/main/resources/frontend-crew.md";
	private static List<String> backendCrewNames = null;
	private static List<String> frontCrewNames = null;
	private static Map<CourseLevelMission,Pairs> courseLevelMissionMap;
	private static final String[] LEVEL1MISSIONS = {"자동차경주", "로또", "숫자야구게임"};
	private static final String[] LEVEL2MISSIONS = {"장바구니", "결제", "지하철노선도"};
	private static final String[] LEVEL4MISSIONS = {"성능개선", "배포"};
	private static final String REMATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오";
	private static final String RESULTMATCH = "페어 매칭 결과입니다.";

	public static void run() {
		String menu;

		backendCrewNames = getCrews(BACKENDPATH);
		frontCrewNames = getCrews(FRONTENDPATH);

		courseLevelMissionMap = new HashMap<>();

		initailizeCourse();

		while(true) {
			boolean exit;
			printMenu();
			try {
				menu = getMenuInput();
				exit = runMenu(menu);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				continue;
			}
			if (exit) {
				break;
			}
		}
	}
	private static void initailizeCourse() {
		for (Course course: Course.values()) {
			initailizeLevel(course);
		}
	}
	private static void initailizeLevel(Course course) {
		for (Level level: Level.values()) {
			initailizeMission(course, level);
		}
	}
	private static void initailizeMission(Course course, Level level) {
		if (level == Level.LEVEL1) {
			for (String mission : LEVEL1MISSIONS) {
				courseLevelMissionMap.put(new CourseLevelMission(course, level, mission),new Pairs());
			}
			return;
		}
		if (level == Level.LEVEL2) {
			for (String mission : LEVEL2MISSIONS) {
				courseLevelMissionMap.put(new CourseLevelMission(course, level, mission),new Pairs());
			}
			return;
		}
		if (level == Level.LEVEL4) {
			for (String mission : LEVEL4MISSIONS) {
				courseLevelMissionMap.put(new CourseLevelMission(course, level, mission),new Pairs());
			}
		}
	}
	private static List<String> getCrews(String path) {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(path));
		} catch (IOException i) {
			System.out.println(i.getMessage());
		}
		return lines;
	}

	private static void printMenu() {
		System.out.println(MENU);
	}

	private static String getMenuInput() {
		return readLine();
	}

	private static boolean runMenu(String menu) {
		if (menu.equals("1")) {
			matchPair();
			return false;
		}
		if (menu.equals("2")) {
			inqueryPair();
			return false;
		}
		if (menu.equals("3")) {
			resetPair();
			return false;
		}
		if (menu.equals("Q")) {
			return true;
		}
		throw new IllegalArgumentException(ERRMESSAGE);
	}
	private static void matchPair() {
		printMatchPairHead();
		while(true) {
			try {
				printSelectMatchPair();
				CourseLevelMission courseLevelMission = getCourseLevelMission();
				if (checkCourseLevelMission(courseLevelMission)) {
					continue;
				}
				makePair(courseLevelMission);
				printResult(courseLevelMission);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static void printResult(CourseLevelMission courseLevelMission) {
		Pairs pairs = courseLevelMissionMap.get(courseLevelMission);

		System.out.println(pairs.toString());
	}
	private static boolean checkCourseLevelMission(CourseLevelMission courseLevelMission) {
		//System.out.println("now :" + courseLevelMission.toString());
		Pairs pairs = courseLevelMissionMap.get(courseLevelMission);
		if (!pairs.isn) {
			while (true) {
				try {
					printRematch();
					if (!getRematch()) {
						return false;
					}
					return true;
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		return false;
	}
	private static void makePair(CourseLevelMission courseLevelMission) {
		List<String> shuffledCrew;
		List<String[]> pairs;
		if (courseLevelMission.course == Course.BACKEND) {
			int count = 0;
			while (count<3) {
				shuffledCrew = Randoms.shuffle(backendCrewNames);
				pairs = new ArrayList<>();
				if (shuffledCrew.size()%2==0) {
					for (int i = 0; i < shuffledCrew.size(); i += 2) {
						String[] pair = new String[2];
						pair[0] = shuffledCrew.get(i);
						pair[1] = shuffledCrew.get(i+1);
						pairs.add(pair);
					}
				} else {
					for (int i = 0; i < shuffledCrew.size()-3; i += 2) {
						String[] pair = new String[2];
						pair[0] = shuffledCrew.get(i);
						pair[1] = shuffledCrew.get(i+1);
						pairs.add(pair);
					}
					String[] pair = new String[3];
					pair[0] = shuffledCrew.get(shuffledCrew.size()-3);
					pair[1] = shuffledCrew.get(shuffledCrew.size()-2);
					pair[2] = shuffledCrew.get(shuffledCrew.size()-1);
					pairs.add(pair);
				}

				if (checkLevelPair(courseLevelMission.course, courseLevelMission.level, pairs)) {
					count += 1;
					continue;
				}
				courseLevelMissionMap.put(courseLevelMission,new Pairs(pairs));
				break;
			}
			if (count == 3) {
				throw new IllegalArgumentException(ERRMESSAGE);
			}
		}
	}

	private static boolean checkLevelPair(Course course, Level level, List<String[]> pairs) {
		for (Map.Entry entry: courseLevelMissionMap.entrySet()) {
			CourseLevelMission courseLevelMission = (CourseLevelMission)entry.getKey();
			if (courseLevelMission.course == course && courseLevelMission.level == level) {
				if (((Pairs)entry.getValue()).checkPair(pairs)) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean getRematch() {
		String rematch = readLine();
		if (rematch.equals("네")) {
			return true;
		}
		if (rematch.equals("아니요")) {
			return false;
		}
		throw new IllegalArgumentException(ERRMESSAGE);
	}
	private static void printRematch() {
		System.out.println(REMATCH);
	}
	private static void printMatchPairHead() {
		System.out.println(MATCHPAIRHEAD);
	}
	private static void printSelectMatchPair() {
		System.out.println(CLECTMATCHPAIR);
	}
	private static CourseLevelMission getCourseLevelMission() {
		String input = readLine();

		validateCourseLevelMission(input);

		String[] st = input.split(", ");
		Course course = Course.toEnum(st[0]);
		Level level = Level.toEnum(st[1]);
		String mission = st[2];


		return new CourseLevelMission(course, level, mission);
	}
	private static void validateCourseLevelMission(String input) {
		String[] inputArray = input.split(", ");
		if (inputArray.length != 3) {
			throw new IllegalArgumentException(ERRMESSAGE);
		}
		String course = inputArray[0];
		String level = inputArray[1];
		String mission = inputArray[2];

		if (!Course.toArrayname().contains(course)) {
			throw new IllegalArgumentException(ERRMESSAGE);
		}

		if (!Level.toArrayname().contains(level)) {
			throw new IllegalArgumentException(ERRMESSAGE);
		}

		if (!isMissionInCourseLevel(course, level, mission)) {
			throw new IllegalArgumentException(ERRMESSAGE);
		}
	}
	private static boolean isMissionInCourseLevel(String course, String level, String mission) {
		if (level.equals("레벨1") && Arrays.asList(LEVEL1MISSIONS).contains(mission)) {
			return true;
		}
		if (level.equals("레벨2") && Arrays.asList(LEVEL2MISSIONS).contains(mission)) {
			return true;
		}
		if (level.equals("레벨4") && Arrays.asList(LEVEL4MISSIONS).contains(mission)) {
			return true;
		}
		return false;
	}
	private static void inqueryPair() {
		printMatchPairHead();
		while(true) {
			try {
				printSelectMatchPair();
				CourseLevelMission courseLevelMission = getCourseLevelMission();
				if (checkinquery(courseLevelMission)) {
					printResult(courseLevelMission);
					break;
				}
				throw new IllegalArgumentException("[ERROR]No Pairs");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private static boolean checkinquery(CourseLevelMission courseLevelMission) {
		Pairs pairs = courseLevelMissionMap.get(courseLevelMission);
		return !pairs.isn;
	}
	private static void resetPair() {
		initailizeCourse();
		System.out.println("초기화 되었습니다.");
	}
}
