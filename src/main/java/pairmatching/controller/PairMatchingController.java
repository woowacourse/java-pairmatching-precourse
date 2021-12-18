package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
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

		// 미션 등록
		List<Mission> missionList = new ArrayList<>();
		missionList.add(new Mission(Level.LEVEL1, "자동차경주"));
		missionList.add(new Mission(Level.LEVEL1, "로또"));
		missionList.add(new Mission(Level.LEVEL1, "숫자야구게임"));
		missionList.add(new Mission(Level.LEVEL2, "장바구니"));
		missionList.add(new Mission(Level.LEVEL2, "결제"));
		missionList.add(new Mission(Level.LEVEL2, "지하철노선도"));
		missionList.add(new Mission(Level.LEVEL4, "성능개선"));
		missionList.add(new Mission(Level.LEVEL4, "배포"));
		Missions missions = new Missions(missionList);

		// 크루 등록
		Crews crews = new Crews();
		crews.addByCrewName(backCrewNames, Course.BACKEND);
		crews.addByCrewName(frontCrewNames, Course.FRONTEND);

		// 사전 제공 정보 출력
		System.out.println("#############################################");
		System.out.print("과정: ");
		StringBuilder sb = new StringBuilder();
		for (Course course : Course.values()) {
			sb.append(course.getName());
			sb.append(" | ");
		}
		String s = sb.toString();
		String substring = s.substring(0, s.length() - 3);
		System.out.println(substring);
		sb.setLength(0);

		System.out.println("미션: ");
		for (Level level : Level.values()) {
			sb.append("  - ");
			sb.append(level.getName());
			sb.append(": ");
			Missions nowLevelMissions = missions.getByLevel(level);
			if (nowLevelMissions.isEmpty()) {
				System.out.println(sb.toString());
				sb.setLength(0);
				continue;
			}
			List<String> missionsNames = nowLevelMissions.getNames();
			for (String missionName : missionsNames) {
				sb.append(missionName);
				sb.append(" | ");
			}
			String s2 = sb.toString();
			String substring1 = sb.substring(0, s2.length() - 3);
			System.out.println(substring1);
			sb.setLength(0);
		}
		System.out.println("과정, 레벨, 미션을 선택하세요.");
		System.out.println("ex) 백엔드, 레벨1, 자동차경주");
		System.out.println("#############################################");
	}
}
