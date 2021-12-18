package pairmatching.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.matchingrecord.BackendRecord;
import pairmatching.matchingrecord.FrontendRecord;
import pairmatching.validator.PairMatchingValidator;
import pairmatching.view.OutputView;

public class PairMatchingService {
	PairMatchingValidator pairMatchingValidator = new PairMatchingValidator();
	OutputView outputView = new OutputView();
	BackendRecord backendRecord = new BackendRecord();
	FrontendRecord frontendRecord = new FrontendRecord();

	public void start(String rawInfo) {

		ArrayList<ArrayList<String>> matchResult;
		pairMatchingValidator.isValidInput(rawInfo);
		String[] userInput = splitCourseInfo(rawInfo);
		while (true) {
			try {
				match(userInput);
				break;
			} catch (IllegalArgumentException e) {

			}
		}
	}

	public void play(String[] userInput) {
		int duplicateNum = 0;
		ArrayList<ArrayList<String>> matchReuslt;

		while (duplicateNum != 3) {
			matchReuslt = match(userInput);
			if (!checkDuplicate(userInput, matchReuslt)) {
				//saveReuslt(userInput, matchResult);
				return;
			}
		}
		throw new IllegalArgumentException("[ERROR] 같은 레벨에서 이미 페어로 만난적이 있는 크루끼리 다시 페어로 매칭 되었습니다.");

	}

	public String[] splitCourseInfo(String rawInfo) {
		String[] cleanInfo = rawInfo.split(", ");
		pairMatchingValidator.isValidInfo(cleanInfo);
		return cleanInfo;
	}

	public ArrayList<ArrayList<String>> match(String[] courseInfo) {
		ArrayList<ArrayList<String>> matchResult;
		List<String> crewNames = getFileItem(courseInfo[0]);
		crewNames = shuffleCrews(crewNames);
		if (crewNames.size() % 2 == 0) {
			matchResult = matchEven(crewNames);
			outputView.printPair(matchResult);
			return matchResult;
		}
		matchResult = matchOdd(crewNames);
		outputView.printPair(matchResult);
		return matchResult;
	}

	public ArrayList<ArrayList<String>> matchEven(List<String> crewNames) {
		ArrayList<ArrayList<String>> matchingInfo = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < crewNames.size(); i += 2) {
			ArrayList<String> rowItems = new ArrayList<>();
			for (int j = 0; j < 2; j++) {
				rowItems.add(crewNames.get(i + j));
			}
			matchingInfo.add(rowItems);
		}
		return matchingInfo;
	}

	public ArrayList<ArrayList<String>> matchOdd(List<String> crewNames) {
		ArrayList<ArrayList<String>> matchingInfo = new ArrayList<>();
		for (int i = 0; i < crewNames.size() - 3; i += 2) {
			ArrayList<String> rowItems = new ArrayList<>();
			for (int j = 0; j < 2; j++) {
				rowItems.add(crewNames.get(i + j));
			}
			matchingInfo.add(rowItems);
		}
		ArrayList<String> rowItems = new ArrayList<>();
		for (int i = crewNames.size() - 3; i < crewNames.size(); i++) {
			rowItems.add(crewNames.get(i));
		}
		matchingInfo.add(rowItems);
		return matchingInfo;
	}

	public List<String> shuffleCrews(List<String> crewNames) {
		return Randoms.shuffle(crewNames);
	}

	public List<String> getFileItem(String courseName) {
		String pathString = getPathString(courseName);
		ArrayList<String> crewNames = new ArrayList<>();
		Path path = Paths.get(pathString);
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				crewNames.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crewNames;
	}

	public String getPathString(String courseName) {
		if (courseName.equals("백엔드")) {
			return "src/main/resources/backend-crew.md";
		}
		return "src/main/resources/frontend-crew.md";
	}

	public void isDuplicate(String[] courseInfo, ArrayList<ArrayList<String>> matchResult) {
		if (courseInfo[0].equals("백엔드")) {

		}

	}

	public boolean checkDuplicate(String[] userInput, ArrayList<ArrayList<String>> matchResult) {

		return false;

	}

}
