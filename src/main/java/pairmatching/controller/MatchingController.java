package pairmatching.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.Course;
import pairmatching.model.Mission;
import pairmatching.util.Constant;
import pairmatching.util.ErrorMessage;

public class MatchingController {
	static List<String> crewNames;
	static List<String> shuffledCrew;
	public static List<String> pairs;

	public static void doMatching(String[] matchingInfo) {
		getCrew(matchingInfo[0]);
		replyMatching(matchingInfo[1]);
		for (Mission mission : ServiceController.missions) {
			String level = String.valueOf(mission.getLevel());
			String name = mission.getName();
			if (matchingInfo[0].equals(level) && matchingInfo[1].equals(name)) {
				mission.pairs = (ArrayList<String>)pairs;
			}
		}
	}

	public static void replyMatching(String level) {
		int count = 1;
		while (count < 3) {
			shuffledCrew = Randoms.shuffle(crewNames);
			generatePairs(shuffledCrew);
			if (isAllNewPair(level)) {
				break;
			}
			if (askRestart().equals("아니오")) {
				break;
			}
			count++;
		}
		if (count == 3) {
			throw new IllegalArgumentException(ErrorMessage.NO_MORE_COMBINATION);
		}
	}

	private static String askRestart() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
		System.out.println("네 | 아니오");
		return Console.readLine();
	}

	private static void generatePairs(List<String> shuffledCrew) {
		pairs = new ArrayList<>();
		for (int i = 0; i < shuffledCrew.size() - 1; i += 2) {
			pairs.add(shuffledCrew.get(i) + " : " + shuffledCrew.get(i + 1));
		}
		if (shuffledCrew.size() % 2 == 1) {
			pairs.set(pairs.size() - 1,
				pairs.get(pairs.size() - 1) + " : " + shuffledCrew.get(shuffledCrew.size() - 1));
		}
	}

	private static Boolean isAllNewPair(String level) {
		ArrayList<Boolean> booleans = new ArrayList<>();
		for (Mission mission : ServiceController.missions) {
			String compareLevel = String.valueOf(mission.getLevel());
			if (compareLevel.equals(level)) {
				booleans.add(checkExist(mission));
			}
		}
		return !(booleans.contains(false));
	}

	private static Boolean checkExist(Mission mission) {
		for (String pair : pairs) {
			if (mission.getPairs().contains(pair)) {
				return false;
			}
		}
		return true;
	}

	private static void getCrew(String course) {
		if (course.equals(Course.BACKEND.getName())) {
			readFile(Constant.BACKEND_CREW_FILE_PATH);
		} else if (course.equals(Course.FRONTEND.getName())) {
			readFile(Constant.FRONTEND_CREW_FILE_PATH);
		}
	}

	private static void readFile(String fileName) {
		try {
			File file = new File(fileName);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = "";
			crewNames = new ArrayList<>();
			while ((line = bufferedReader.readLine()) != null) {
				crewNames.add(line);
			}
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(ErrorMessage.FILE_NOT_FOUND);
		} catch (IOException e) {
			throw new IllegalArgumentException();
		}
	}
}
