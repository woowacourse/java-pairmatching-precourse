package pairmatching;

import java.io.IOException;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.utils.DataInitializer;
import pairmatching.view.OutputView;

public class Controller {
	private final static String MISSION_SEPARATOR = ", ";
	private final static int INDEX_COURSE = 0;
	private final static int INDEX_LEVEL = 1;
	private final static int INDEX_MISSION = 2;

	private final OutputView outputView = new OutputView();

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
			// TODO: 페어 초기화
		}
		chooseMission();
	}

	private void chooseMission() {
		outputView.printCourseAndMission();
		String[] missionInfo = Console.readLine().split(MISSION_SEPARATOR);
		try {
			Course course = Course.findByName(missionInfo[INDEX_COURSE]);
			Level level = Level.findByName(missionInfo[INDEX_LEVEL]);
			Mission mission = Mission.findByName(missionInfo[INDEX_MISSION]);
		} catch (IllegalArgumentException e) {
			outputView.printError(e);
			chooseMission();
		}
	}
}
