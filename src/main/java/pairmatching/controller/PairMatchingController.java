package pairmatching.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pairmatching.constant.Course;
import pairmatching.constant.Menu;
import pairmatching.domain.Matching;
import pairmatching.domain.PairMatching;
import pairmatching.view.InputView;

public class PairMatchingController {
	private final InputView inputView;
	private final PairMatching pairMatching;

	public PairMatchingController() {
		inputView = new InputView();
		pairMatching = new PairMatching();
	}

	public void start() {
		ready();
		selectFunction();
	}

	private void ready() {
		pairMatching.setCrews(Course.BACKEND, readBackEndCrewFile());
		pairMatching.setCrews(Course.FRONTEND, readFrontEndCrewFile());
		pairMatching.setMatchings();
	}

	private List<String> readBackEndCrewFile() {
		List<String> crewNames = new ArrayList<>();
		try {
			Path path = Paths.get(
				"D:\\woowacourse\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
			Stream<String> lines = Files.lines(path);
			crewNames = lines.collect(Collectors.toList());
			lines.close();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일을 읽는데 실패하였습니다.");
		}
		return crewNames;
	}

	private List<String> readFrontEndCrewFile() {
		List<String> crewNames = new ArrayList<>();
		try {
			Path path = Paths.get(
				"D:\\woowacourse\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md");
			Stream<String> lines = Files.lines(path);
			crewNames = lines.collect(Collectors.toList());
			lines.close();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일을 읽는데 실패하였습니다.");
		}
		return crewNames;
	}

	private void selectFunction() {
		String functionNumber = inputView.getInputFunction();
		if (functionNumber.equals(Menu.MATCHING.getFunctionNumber())) {
			matching();
		}
	}

	private void matching() {
		String inputMatching = inputView.getInputMatching();
		Matching selectedMatching = findMatching(inputMatching);

	}

	private Matching findMatching(String inputMatching) {
		for (Matching matching : pairMatching.getMatchings()) {
			if (matching.isRight(inputMatching)) {
				return matching;
			}
		}
		return null;
	}

}
