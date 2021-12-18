package pairmatching;

import java.io.IOException;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.MatchedPairs;
import pairmatching.domain.MatchedPairsRepository;
import pairmatching.domain.Mission;
import pairmatching.domain.PairManager;
import pairmatching.utils.DataInitializer;
import pairmatching.view.OutputView;

public class Controller {
	private final static String MISSION_SEPARATOR = ", ";
	private final static int INDEX_COURSE = 0;
	private final static int INDEX_LEVEL = 1;
	private final static int INDEX_MISSION = 2;

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
		}
		runInquiryFunction(course, level, mission);
	}

	private void runMatchingFunction(Course course, Level level, Mission mission) {
		MatchedPairs matchedPairs = pairManager.matchPair(course, level, mission);
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
}
