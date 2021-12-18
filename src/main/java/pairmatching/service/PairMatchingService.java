package pairmatching.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.constant.OutputConstant;
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
			return;
		}

		if (courseInfo[0].equals("백엔드")) {
			matchBackEnd(courseInfo);
			return;
		}

	}

	// public String[] save() {
	//
	// }

	public void matchFrontEnd(String[] courseInfo) {

		// List<String> crewNames; // 파일에서 로드한 크루 이름 목록
		// List<String> shuffledCrew = Randoms.shuffle(crewNames); // 섞인 크루 이름 목록
		// if
		System.out.println("프론트엔드 매칭");

	}

	public void matchBackEnd(String[] courseInfo) {
		List<String> crewNames = getFileItem();
		for (String crew: crewNames){
			System.out.println(crew);
		}
		System.out.println("백엔드 매칭");
		return;
	}

	// public List<String> shuffleFrontEnd() {
	// 	List<String> crewNames; // 파일에서 로드한 크루 이름 목록
	//
	// 	//List<String> shuffledCrew = Randoms.shuffle(crewNames);
	//
	// 	/return shuffledCrew;
	// }

	public List<String> getFileItem(){
		ArrayList<String> crewNames = new ArrayList<>();
		Path path = Paths.get("src/main/resources/frontend-crew.md");
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

}
