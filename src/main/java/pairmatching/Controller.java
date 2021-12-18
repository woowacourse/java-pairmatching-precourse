package pairmatching;

import java.io.IOException;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.MatchedPairs;
import pairmatching.domain.MatchedPairsRepository;
import pairmatching.domain.Mission;
import pairmatching.service.PairManager;
import pairmatching.utils.DataInitializer;
import pairmatching.view.OutputView;

public class Controller {
	private static final String MISSION_SEPARATOR = ", ";
	private static final int INDEX_COURSE = 0;
	private static final int INDEX_LEVEL = 1;
	private static final int INDEX_MISSION = 2;

	private static final String ANSWER_YES = "네";
	private static final String ANSWER_NO = "아니오";
	private static final String ERROR_ANSWER = "네 또는 아니오만 입력하세요.";

	private final OutputView outputView = new OutputView();
	private final PairManager pairManager = new PairManager();

	private boolean running = true;

	public void initData() {
		DataInitializer dataInitializer = new DataInitializer();
		try {
			dataInitializer.initializeCrew();
		} catch (IOException e) {
			outputView.printError(e);
		}
	}

	public void run() {
		runFunction(chooseFunction());
	}

	public boolean isRunning() {
		return running;
	}

	private Function chooseFunction() {
		outputView.printMain();
		try {
			return Function.findByCode(Console.readLine());
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return chooseFunction();
		}
	}

	private void runFunction(Function function) {
		if (function == Function.QUIT) {
			running = false;
			return;
		}
		if (function == Function.INIT) {
			runInitFunction();
			return;
		}
		chooseMission(function);
	}

	private void chooseMission(Function function) {
		outputView.printCourseAndMission();
		String[] missionInfo = Console.readLine().split(MISSION_SEPARATOR);
		try {
			runPairFunction(
				Course.findByName(missionInfo[INDEX_COURSE]),
				Level.findByName(missionInfo[INDEX_LEVEL]),
				Mission.findByName(missionInfo[INDEX_MISSION]),
				function);
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			chooseMission(function);
		}
	}

	private void runPairFunction(Course course, Level level, Mission mission, Function function) {
		if (function == Function.MATCHING) {
			runMatchingFunction(course, level, mission);
			return;
		}
		runInquiryFunction(course, level, mission);
	}

	private void runMatchingFunction(Course course, Level level, Mission mission) {
		MatchedPairs matchedPairs = pairManager.matchPair(course, level, mission);
		if (matchedPairs == null) {
			String rematchAnswer = askRematch();
			if (rematchAnswer.equals(ANSWER_NO)) {
				chooseMission(Function.MATCHING);
				return;
			}
			matchedPairs = pairManager.rematchPair(course, level, mission);
		}
		MatchedPairsRepository.add(matchedPairs);
		outputView.printMatchedPairs(matchedPairs);
	}

	private void runInquiryFunction(Course course, Level level, Mission mission) {
		outputView.printInquiryResult(pairManager.inquiryPair(course, level, mission));
	}

	private void runInitFunction() {
		MatchedPairsRepository.init();
		outputView.printInitResult();
	}

	private String askRematch() {
		outputView.printRematch();
		String answer = Console.readLine();
		try {
			validateRematchInput(answer);
			return answer;
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			return askRematch();
		}
	}

	private void validateRematchInput(String input) {
		if (input.equals(ANSWER_YES) || input.equals(ANSWER_NO)) {
			return;
		}
		throw new IllegalArgumentException(ERROR_ANSWER);
	}
}
