package pairmatching.domain;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Crew {

	private List<String> backendCrew = new ArrayList<>();
	private List<String> frontendCrew = new ArrayList<>();

	private Map<String, ArrayList<String>> backendCrewMapByLevel = new LinkedHashMap<>();
	private Map<String, ArrayList<String>> frontendCrewMapByLevel = new LinkedHashMap<>();

	private BufferedReader bufferedReaderBackend = new BufferedReader(
		new FileReader("src/main/resources/backend-crew.md"), 16 * 1024
	);
	private BufferedReader bufferedReaderFrontend = new BufferedReader(
		new FileReader("src/main/resources/frontend-crew.md"), 16 * 1024
	);

	public Crew() throws IOException {
		initBackendCrew();
		initFrontendCrew();
		initCrewMapByLevel();
	}

	private void initCrewMapByLevel() {
		ArrayList<String> defaultList = new ArrayList<>();
		backendCrewMapByLevel.put("레벨1", defaultList);
		backendCrewMapByLevel.put("레벨2", defaultList);
		backendCrewMapByLevel.put("레벨3", defaultList);
		backendCrewMapByLevel.put("레벨4", defaultList);
		backendCrewMapByLevel.put("레벨5", defaultList);

		frontendCrewMapByLevel.put("레벨1", defaultList);
		frontendCrewMapByLevel.put("레벨2", defaultList);
		frontendCrewMapByLevel.put("레벨3", defaultList);
		frontendCrewMapByLevel.put("레벨4", defaultList);
		frontendCrewMapByLevel.put("레벨5", defaultList);


	}

	public void initBackendCrew() throws IOException {
		while (true) {
			String crewName = bufferedReaderBackend.readLine();
			if (crewName != null) {
				backendCrew.add(crewName);
				continue;
			}
			return;
		}
	}

	public void initFrontendCrew() throws IOException {
		while (true) {
			String crewName = bufferedReaderFrontend.readLine();
			if (crewName != null) {
				frontendCrew.add(crewName);
				continue;
			}
			return;
		}
	}

	public Map<String, ArrayList<String>> createRandomMatching(String roll) {
		if (roll == "백엔드") {
			return backendCrewMapByLevel;
		}
		return frontendCrewMapByLevel;
	}

	public void createBackendMatching(Map<String, List<String>> levelMap, String level) {
		System.out.println(level);
		List<String> shuffledCrewNames = Randoms.shuffle(backendCrew);
		List<String> newList = new ArrayList<>();
		while (shuffledCrewNames.size() > 1) {
			List<String> tempList = new ArrayList<>();
			tempList.add(shuffledCrewNames.get(0));
			tempList.add(shuffledCrewNames.get(1));
			Collections.sort(tempList);
			String joinedNames = String.join(" : ", tempList);
			// 다른 레벨에서 만났는지 체크
			if (isNotDuplicateInOtherLevel(levelMap, level, joinedNames)) {
				newList.add(joinedNames);
				shuffledCrewNames.remove(shuffledCrewNames.get(0));
				shuffledCrewNames.remove(shuffledCrewNames.get(0));
				continue;
			}
			Randoms.shuffle(shuffledCrewNames);
		}
		backendCrewMapByLevel.put(level, (ArrayList<String>)newList);
		for (String key: backendCrewMapByLevel.keySet()) {
			System.out.println(key + " 이기 " + backendCrewMapByLevel.get(key));
		}
	}

	public boolean isNotDuplicateInOtherLevel( Map<String, List<String>> levelMap, String level, String joinedNames) {

		for (String levelName : levelMap.keySet()) {
			if (levelName.equals(level)) {
				continue;
			}
			if (backendCrewMapByLevel.get(level).contains(joinedNames)) {
				return false;
			}
		}
		return true;
	}

}
