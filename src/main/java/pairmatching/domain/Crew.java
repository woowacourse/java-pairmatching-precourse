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
	public Map<String, ArrayList<String>> frontendCrewMapByLevel = new LinkedHashMap<>();

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

	public Map<String, ArrayList<String>> getBackendCrewMapByLevel() {
		return backendCrewMapByLevel;
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

	public void createRandomMatching(String roll, Map<String, List<String>> levelMap,
		String level) {
		if (roll.equals("백엔드")) {
			createMatching(backendCrew, levelMap, level, roll);
			return;
		}
		createMatching(frontendCrew, levelMap, level, roll);
	}

	public void createMatching( List<String> crewList, Map<String, List<String>> levelMap, String level, String roll) {
		List<String> shuffledCrewNames = Randoms.shuffle(crewList);
		List<String> newList = new ArrayList<>();

		while (shuffledCrewNames.size() > 1) {
			List<String> tempList = new ArrayList<>();
			tempList.add(shuffledCrewNames.get(0));
			tempList.add(shuffledCrewNames.get(1));
			Collections.sort(tempList);
			String joinedNames = String.join(" : ", tempList);

			if (isNotDuplicateInOtherLevel(levelMap, level, joinedNames)) {
				newList.add(joinedNames);
				shuffledCrewNames.remove(shuffledCrewNames.get(0));
				shuffledCrewNames.remove(shuffledCrewNames.get(0));
				continue;
			}
			Randoms.shuffle(shuffledCrewNames);
		}
		if (roll.equals("백엔드")) {
			backendCrewMapByLevel.put(level, (ArrayList<String>)newList);
			return;
		}
		frontendCrewMapByLevel.put(level, (ArrayList<String>)newList);
	}

	public boolean isNotDuplicateInOtherLevel(Map<String, List<String>> levelMap, String level, String joinedNames) {

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

	public void printCrews(String roll, String level) {
		if (roll.equals("백엔드")) {
			for (String pair : backendCrewMapByLevel.get(level)) {
				System.out.println(pair);
			}
		}
		if (roll.equals("프론트엔드")) {
			for (String pair : frontendCrewMapByLevel.get(level)) {
				System.out.println(pair);
			}
		}
	}

}
