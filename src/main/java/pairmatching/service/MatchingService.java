package pairmatching.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MatchingService {

	private static final int COURSE_INDEX = 0;
	private static final int LEVEL_INDEX = 1;
	private static final int MISSION_INDEX = 2;

	public void split(String input) {
		String[] split = input.trim().split(",");
		//TODO: 각각에 대한 정보 얻기
	}

	public void generateRandomMatching() {
		List<String> crewNames = readFileNames();
		List<String> shuffledCrew = Randoms.shuffle(crewNames); // 섞인 크루 이름 목록

	}

	private List<String> readFileNames() {
		List<String> crewNames = new ArrayList<>(); // 파일에서 로드한 크루 이름 목록
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/backend-crew.md"),
				StandardCharsets.UTF_8));
			String name;
			while ((name = reader.readLine()) != null) {
				crewNames.add(name);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crewNames;
	}

}
