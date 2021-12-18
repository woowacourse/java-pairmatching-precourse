package pairmatching.controller;

import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Missions;
import pairmatching.view.InputView;

public class PairMatchingController {
	public void run() {
		// 크루 이름 획득
		List<String> backCrewNames = InputView.getCrewNameByFile("backend-crew.md");
		List<String> frontCrewNames = InputView.getCrewNameByFile("frontend-crew.md");

		// 미션 등록
		Missions missions = new Missions();
		missions.add(new Mission(Level.LEVEL1, "자동차경주"));
		missions.add(new Mission(Level.LEVEL1, "로또"));
		missions.add(new Mission(Level.LEVEL1, "숫자야구게임"));
		missions.add(new Mission(Level.LEVEL2, "장바구니"));
		missions.add(new Mission(Level.LEVEL2, "결제"));
		missions.add(new Mission(Level.LEVEL2, "지하철노선도"));
		missions.add(new Mission(Level.LEVEL4, "성능개선"));
		missions.add(new Mission(Level.LEVEL4, "배포"));

		// 크루 등록
		Crews crews = new Crews();
		crews.addByCrewName(backCrewNames, Course.BACKEND);
		crews.addByCrewName(frontCrewNames, Course.FRONTEND);
	}
}
