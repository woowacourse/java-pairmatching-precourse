package pairmatching.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import pairmatching.Application;
import pairmatching.domain.Course;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Missions;
import pairmatching.utils.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	public void run() {
		// List<String> backCrewNames = getCrewNameByFile("backend-crew.md");
		// List<String> frontCrewNames = getCrewNameByFile("frontend-crew.md");
		// Missions missions = initMissions();
		// Crews crews = initCrews(backCrewNames, frontCrewNames);
		// // 사전 제공 정보 출력
		// OutputView.printCourseAndMissionStatus(missions);

		// 기능 선택 기능
		String select = enterSelectOption();
		if (select.equals("1")) {
			System.out.println("1");
		}
		if (select.equals("2")) {
			System.out.println("2");
		}
		if (select.equals("3")) {
			System.out.println("3");
		}
		if (select.equals("Q")) {
			System.out.println("Q");
			return;
		}
	}

	private String enterSelectOption() {
		String select;
		try {
			OutputView.printSelectOption();
			select = InputView.enterString();
			Validator.validateSelection(select);
		} catch (IllegalArgumentException ex) {
			OutputView.printError(ex.getMessage());
			return enterSelectOption();
		}
		return select;
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

	private List<String> getCrewNameByFile(String fileName) {
		List<String> backCrewNames = null;
		URL resource = Application.class.getClassLoader().getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("[ERROR] 파일 경로를 잘못입력했습니다.");
		}
		Path path = new File(resource.getPath()).toPath();
		try {
			backCrewNames = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return backCrewNames;
	}
}
