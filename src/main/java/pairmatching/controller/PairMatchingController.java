package pairmatching.controller;

import static constants.PairMatchingConstants.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;
import pairmatching.domain.BackendCrewName;
import pairmatching.domain.Course;
import pairmatching.domain.CrewPair;
import pairmatching.domain.FrontendCrewName;
import pairmatching.domain.Mission;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private BackendCrewName backendCrewName;
	private FrontendCrewName frontendCrewName;
	private String selectedFeature;
	private List<String> pairBackgroundInfo;
	private CrewPair pairs = new CrewPair();

	public void start() {
		getCrewName();
		while (true) {
			selectFeature();
			if (selectedFeature.equals(QUIT)) {
				break;
			}
			if (selectedFeature.equals(PAIR_MATCHING)) {
				pairMatching();
			}
			if (selectedFeature.equals(PAIR_LOOKUP)) {
				pairLookUp();
			}
			if (selectedFeature.equals(PAIR_RESET)) {
				pairReset();
			}
		}
	}

	private void getCrewName() {
		backendCrewName = new BackendCrewName(readCrewName("src/main/resources/backend-crew.md"));
		frontendCrewName = new FrontendCrewName(readCrewName("src/main/resources/frontend-crew.md"));
	}

	private List<String> readCrewName(String fileName) {
		List<String> names = new ArrayList<>();
		while (true) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				String name;
				while ((name = reader.readLine()) != null) {
					names.add(name);
				}
				return names;
			} catch (Exception e) {
				OutputView.printError(FILE_READ_ERROR);
			}
		}
	}

	private void selectFeature() {
		selectedFeature = InputView.getFeature();
	}

	private void pairMatching() {
		Pair<Course, Mission> info = getPairInfo();
		if (pairs.isExist(info) && InputView.getTryMore().equals(NO)) {
			return;
		}
		try {
			addNewPair(info, 0);
			OutputView.printPairResult(pairs.getPair(info));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			pairMatching();
		}
	}

	private void addNewPair(Pair<Course, Mission> info, int count) {
		if (count == 3) {
			throw new IllegalArgumentException(TRIPLE_MATCHING_ERROR);
		}
		try {
			if (info.getKey() == Course.BACKEND) {
				pairs.addPair(info, backendCrewName.getShuffledCrewName());
			}
			if (info.getKey() == Course.FRONTEND) {
				pairs.addPair(info, frontendCrewName.getShuffledCrewName());
			}
		} catch (IllegalArgumentException e) {
			addNewPair(info, count + 1);
		}
	}

	private Pair<Course, Mission> getPairInfo() {
		pairBackgroundInfo = InputView.getPairBackgroundInfo();
		Course course = Course.findByName(pairBackgroundInfo.get(0));
		Mission mission = Mission.findByName(pairBackgroundInfo.get(2));
		return new Pair<>(course, mission);
	}

	private void pairLookUp() {
		Pair<Course, Mission> info = getPairInfo();
		try {
			OutputView.printPairResult(pairs.getPair(info));
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			pairLookUp();
		}
	}

	private void pairReset() {
		pairs.resetPair();
		OutputView.printResetMessage();
	}

}
