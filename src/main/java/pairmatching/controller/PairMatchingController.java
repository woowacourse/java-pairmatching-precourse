package pairmatching.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import pairmatching.constant.Course;
import pairmatching.constant.Menu;
import pairmatching.domain.Matching;
import pairmatching.domain.PairMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private static final String SPLIT_REGEX = ",";

	private final InputView inputView;
	private final OutputView outputView;
	private final PairMatching pairMatching;

	public PairMatchingController() {
		inputView = new InputView();
		outputView = new OutputView();
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
		Matching selectedMatching = pairMatching.findMatching(inputMatching);
		List<List<String>> matchingResult = pairMatching.getMatchingResult(getInputMatchingCourse(inputMatching),
			selectedMatching);
		outputView.printMatchingResult(matchingResult);
	}

	private Course getInputMatchingCourse(String inputMatching) {
		return Course.nameOf(Arrays.stream(inputMatching.split(SPLIT_REGEX))
			.map(String::trim)
			.toArray(String[]::new)[0]);
	}
}
