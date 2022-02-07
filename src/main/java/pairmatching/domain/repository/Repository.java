package pairmatching.domain.repository;

import static pairmatching.utils.Converter.*;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Level;
import pairmatching.service.ResourseReader;
import pairmatching.utils.Constants;

public class Repository {
	public static List<String> backendList = ResourseReader.getBackendList();
	public static List<String> frontendList = ResourseReader.getFrontendList();

	public static ArrayList<Level> levels = new ArrayList<>();

	public static String[] levelStrings = {"레벨1", "레벨2", "레벨3", "레벨4", "레벨5"};

	static {
		levels.add(new Level(1, new String[] {"자동차경주", "로또", "숫자야구게임"}));
		levels.add(new Level(2, new String[] {"장바구니", "결제", "지하철노선도"}));
		levels.add(new Level(3, new String[0]));
		levels.add(new Level(4, new String[] {"성능개선", "결제", "배포"}));
		levels.add(new Level(5, new String[0]));
	}

	public static List<String> getBranchList(String end) {
		if (end.equals(Constants.BACKEND)) {
			return backendList;
		}
		if (end.equals(Constants.FRONTEND)) {
			return frontendList;
		}
		throw new IllegalArgumentException(Constants.ERROR_MISSION_PATTERN);
	}

	public static Level levelsFind(int num) {
		return levels.get(num);
	}

	public static Level levelsFind(String input) {
		return levels.get(getInt(Character.toString(input.charAt(2))) - 1);
	}

	public static String levelFind(String name) {
		for (String obj : levelStrings) {
			if (obj.equals(name)) {
				return obj;
			}
		}
		// 결과가 없으면 예외처리
		throw new IllegalArgumentException(Constants.ERROR_MISSION_PATTERN);
	}
}
