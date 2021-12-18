package pairmatching.domain;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crews {
	public List<String> backEndCrewNames = Arrays.asList("백호", "태웅", "치수", "태섭", "대만", "준호", "대협", "덕규", "태산", "경태",
		"수겸", "현준", "준섭",
		"한나", "소연", "호열", "대남", "용팔", "구식", "달재");
	public List<String> frontEndCrewNames = Arrays.asList("보노", "시저", "쉐리", "신디", "다비", "덴버", "이브", "제시", "라라", "린다",
		"리사", "리콜", "로드",
		"윌터", "제키");
	public List<String> backEndShuffledCrew;
	public List<String> frontEndShuffledCrew;

	public Pairs shuffleBackEndCrew() {
		backEndShuffledCrew = Randoms.shuffle(backEndCrewNames);
		Pairs pairs = new Pairs();
		for (int i = 0; i < backEndShuffledCrew.size(); i += 2) {
			System.out.println(backEndShuffledCrew.get(i));
			Crew crew1 = new Crew(Course.BACKEND, backEndShuffledCrew.get(i));
			Crew crew2 = new Crew(Course.BACKEND, backEndShuffledCrew.get(i + 1));
			Pair pair = new Pair(crew1, crew2);
			pairs.addPairList(pair);
		}
		return pairs;
	}

	public Pairs shuffleFrontEndCrew() {
		frontEndShuffledCrew = Randoms.shuffle(frontEndCrewNames);
		Pairs pairs = new Pairs();
		for (int i = 0; i < frontEndShuffledCrew.size(); i += 2) {
			Crew crew1 = new Crew(Course.FRONTEND, frontEndShuffledCrew.get(i));
			Crew crew2 = new Crew(Course.FRONTEND, frontEndShuffledCrew.get(i + 1));
			if (i == frontEndShuffledCrew.size() - 3) {
				Crew crew3 = new Crew(Course.FRONTEND, frontEndShuffledCrew.get(i + 2));
				Pair pair = new Pair(crew1, crew2, crew3);
				pairs.addPairList(pair);
				return pairs;
			}
			Pair pair = new Pair(crew1, crew2);
			pairs.addPairList(pair);
		}
		return pairs;
	}
}
