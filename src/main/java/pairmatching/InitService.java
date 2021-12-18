package pairmatching;

import java.util.Arrays;
import java.util.List;

import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Missions;

public class InitService {
	private static List<String> backendCrewNames = Arrays.asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산",
		"경태", "수겸", "현준", "준섭", "한나", "소연", "호열", "대남", "용팔", "구식", "달재");
	private static List<String> frontendCrewNames = Arrays.asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라",
		"린다", "리사", "니콜", "로드", "윌터", "제키");
	private static List<String> level1Missions = Arrays.asList("자동차경주", "로또", "숫자야구게임");
	private static List<String> level2Missions = Arrays.asList("장바구니", "결제", "지하철노선도");
	private static List<String> level4Missions = Arrays.asList("성능개선", "배포");

	public static void initCrew() {
		Crews crews = new Crews();
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
