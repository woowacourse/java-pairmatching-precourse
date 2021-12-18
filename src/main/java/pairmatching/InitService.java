package pairmatching;

import java.util.Arrays;
import java.util.List;

import pairmatching.domain.Crews;

public class InitService {
	private static List<String> backendCrewNames = Arrays.asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산",
		"경태", "수겸", "현준", "준섭", "한나", "소연", "호열", "대남", "용팔", "구식", "달재");
	private static List<String> frontendCrewNames = Arrays.asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라",
		"린다", "리사", "니콜", "로드", "윌터", "제키");

	public static void initCrew() {
		Crews crews = new Crews();
		crews.addBackEndCrews(backendCrewNames);
		crews.addFrontEndCrews(frontendCrewNames);
	}
}
