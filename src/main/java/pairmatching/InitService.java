package pairmatching;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pairmatching.domain.Crews;
import pairmatching.domain.Missions;

public class InitService {
	static BufferedReader backendReader;
	static BufferedReader frontReader;


	static {
		try {
			backendReader = new BufferedReader(new FileReader("src/main/resources/backend-crew.md"));
			frontReader = new BufferedReader(new FileReader("src/main/resources/frontend-crew.md"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static List<String> backendCrewNames = new ArrayList<>();
	private static List<String> frontendCrewNames = new ArrayList<>();
	private static List<String> level1Missions = Arrays.asList("자동차경주", "로또", "숫자야구게임");
	private static List<String> level2Missions = Arrays.asList("장바구니", "결제", "지하철노선도");
	private static List<String> level4Missions = Arrays.asList("성능개선", "배포");

	public InitService() throws FileNotFoundException {
	}


	public static void initCrew() throws IOException {
		Crews crews = new Crews();
		String backNames;
		while ((backNames = backendReader.readLine()) != null) {
			backendCrewNames.add(backNames);
		}
		String frontNames;
		while ((frontNames = frontReader.readLine()) != null) {
			frontendCrewNames.add(frontNames);
		}
		crews.addBackEndCrews(backendCrewNames);
		crews.addFrontEndCrews(frontendCrewNames);
		crews.addMapCrewList();
	}

	public static void initMission() {
		Missions missions = new Missions();
		missions.addLevel1Mission(level1Missions);
		missions.addLevel2Mission(level2Missions);
		missions.addLevel4Mission(level4Missions);
		missions.addMapCrewList();
	}
}
