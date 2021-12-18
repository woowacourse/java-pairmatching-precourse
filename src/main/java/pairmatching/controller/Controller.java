package pairmatching.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Member;
import pairmatching.domain.Mission;
import pairmatching.service.MemberService;
import pairmatching.service.MissionService;
import pairmatching.util.MenuValidator;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
	private final MemberService memberService = new MemberService();
	private final MissionService missionService = new MissionService();
	private final MenuController menuController = new MenuController();

	public void run() {
		try {
			initializeApplication();
		} catch (IOException e) {
			OutputView.printExceptionMessage("파일 경로가 잘못되었습니다.");
			return;
		}
		inputMenuAndRun();
	}

	private void inputMenuAndRun() {
		try {
			String input = InputView.inputMenu();
			MenuValidator.isRightMenu(input);
			menuController.run(input, missionService);
		} catch (IllegalArgumentException e) {
			OutputView.printExceptionMessage(e.getMessage());
			inputMenuAndRun();
		}
	}

	private void initializeApplication() throws IOException {
		saveMembers("backend");
		saveMembers("frontend");
		saveMissions();
	}

	private void saveMissions() {
		missionService.save(new Mission(Level.level1, "자동차경주"));
		missionService.save(new Mission(Level.level1, "로또"));
		missionService.save(new Mission(Level.level1, "숫자야구게임"));
		missionService.save(new Mission(Level.level2, "장바구니"));
		missionService.save(new Mission(Level.level2, "결제"));
		missionService.save(new Mission(Level.level4, "성능개선"));
		missionService.save(new Mission(Level.level4, "배포"));
	}

	private void saveMembers(String course) throws IOException {
		List<String> memberNames = getMemberNames(course);
		for (String memberName : memberNames) {
			if (course.equals("백엔드")) {
				memberService.save(new Member(memberName, Course.Backend));
			}
			if (course.equals("프론트엔드")) {
				memberService.save(new Member(memberName, Course.FrontEnd));
			}
		}
	}

	private List<String> getMemberNames(String course) throws IOException {
		List<String> names = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("src/main/resources/" + course + "-crew.md"));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			names.add(line);
		}
		br.close();
		return names;
	}
}
