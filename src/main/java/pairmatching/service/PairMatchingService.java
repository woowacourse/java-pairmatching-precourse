package pairmatching.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.validator.PairMatchingValidator;

public class PairMatchingService {
	PairMatchingValidator pairMatchingValidator = new PairMatchingValidator();

	public void start(String rawInfo) {
		pairMatchingValidator.isValidInput(rawInfo);
		String[] userInput = splitCourseInfo(rawInfo);
		match(userInput);
	}

	public String[] splitCourseInfo(String rawInfo) {
		String[] cleanInfo = rawInfo.split(", ");
		pairMatchingValidator.isValidInfo(cleanInfo);
		return cleanInfo;
	}

	public void match(String[] courseInfo) {
		if (courseInfo[0].equals("프론트엔드")) {
			matchFrontEnd(courseInfo);

		}

		if (courseInfo[0].equals("백엔드")) {
			matchBackEnd(courseInfo);

		}

	}

	// public String[] save() {
	//
	// }

	public void matchFrontEnd(String[] courseInfo) {
		List<String> crewNames = getFileItem(courseInfo[0]);
		crewNames = shuffleCrews(crewNames);
		System.out.println("프론트엔드 매칭");

	}

	public void matchBackEnd(String[] courseInfo) {
		List<String> crewNames = getFileItem(courseInfo[0]);
		crewNames = shuffleCrews(crewNames);
		System.out.println("백엔드 매칭");
	}

	// public List<String> shuffleFrontEnd(String[] courseInfo) {
	// 	List<String> crewNames = getFileItem(courseInfo[0]); // 파일에서 로드한 크루 이름 목록
	// 	List<String> shuffledCrew = Randoms.shuffle(crewNames);
	// 	return shuffledCrew;
	//}

	public List<String> shuffleCrews(List<String> crewNames){
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
				System.out.println(line);
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


}
