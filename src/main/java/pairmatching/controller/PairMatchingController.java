package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Missions;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	public void run() {
		// 크루 이름 획득
		List<String> backCrewNames = InputView.getCrewNameByFile("backend-crew.md");
		List<String> frontCrewNames = InputView.getCrewNameByFile("frontend-crew.md");
		Missions missions = initMissions();
		Crews crews = initCrews(backCrewNames, frontCrewNames);
		// 사전 제공 정보 출력
		OutputView.printCourseAndMissionStatus(missions);
	}

	private Crews initCrews(List<String> backCrewNames, List<String> frontCrewNames) {
		Crews crews = new Crews();
		crews.addByCrewName(backCrewNames, Course.BACKEND);
		crews.addByCrewName(frontCrewNames, Course.FRONTEND);
		return crews;
	}

	private Missions initMissions() {
		List<Mission> missionList = new ArrayList<>();
		missionList.add(new Mission(Level.LEVEL1, "자동차경주"));
		missionList.add(new Mission(Level.LEVEL1, "로또"));
		missionList.add(new Mission(Level.LEVEL1, "숫자야구게임"));
		missionList.add(new Mission(Level.LEVEL2, "장바구니"));
		missionList.add(new Mission(Level.LEVEL2, "결제"));
		missionList.add(new Mission(Level.LEVEL2, "지하철노선도"));
		missionList.add(new Mission(Level.LEVEL4, "성능개선"));
		missionList.add(new Mission(Level.LEVEL4, "배포"));
		return new Missions(missionList);
	}
}
