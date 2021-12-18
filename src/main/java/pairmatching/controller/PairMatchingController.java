package pairmatching.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.Application;
import pairmatching.constant.PairMatchingConst;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Level;
import pairmatching.domain.MatchingOption;
import pairmatching.domain.Mission;
import pairmatching.domain.Missions;
import pairmatching.domain.Pair;
import pairmatching.utils.Converter;
import pairmatching.utils.Validator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	public void run() {
		List<String> backCrewNames = getCrewNameByFile("backend-crew.md");
		List<String> frontCrewNames = getCrewNameByFile("frontend-crew.md");
		Missions missions = initMissions();
		Crews crews = initCrews(backCrewNames, frontCrewNames);

		// 기능 선택 기능
		String select = enterSelectOption();
		if (select.equals(PairMatchingConst.SELECT_PAIR_MATCHING)) { // 페어 매칭
			List<Pair> pairs = matchingPair(missions, crews);
			// pairs 검증
		}
		if (select.equals(PairMatchingConst.SELECT_PAIR_READ)) { // 페어 조회
		}
		if (select.equals(PairMatchingConst.SELECT_PAIR_RESET)) { // 페어 초기화
		}
		if (select.equals(PairMatchingConst.SELECT_EXIT)) { // 종료
			return;
		}
	}

	private List<Pair> matchingPair(Missions missions, Crews crews) {
		try {
			OutputView.printCourseAndMissionStatus(missions);
			String matchingOptionInput = InputView.enterString();
			MatchingOption matchingOption = Converter.toMatchingOption(matchingOptionInput, missions);

			// 페어 매칭 구현
			Course nowCourse = matchingOption.getCourse();
			List<Crew> crewsByCourse = crews.getCrewsByCourse(nowCourse);

			List<Crew> shuffledCrew = Randoms.shuffle(crewsByCourse);
			List<Pair> pairs = new ArrayList<>();
			for (int i = 0; i < shuffledCrew.size() / 2; i += 2) {
				Pair pair = new Pair(crewsByCourse.get(i), crewsByCourse.get(i + 1));
				pairs.add(pair);
			}
			if (shuffledCrew.size() % 2 == 1) { // 홀수인 경우 마지막 페어에 삽입
				pairs.get(pairs.size() - 1).add(shuffledCrew.get(shuffledCrew.size() - 1));
			}
			return pairs;
		} catch (IllegalArgumentException ex) {
			OutputView.printError(ex.getMessage());
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
