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
		pairBackgroundInfo = InputView.getPairBackgroundInfo();
		Course course = Course.findByName(pairBackgroundInfo.get(0));
		Mission mission = Mission.findByName(pairBackgroundInfo.get(2));
		Pair<Course, Mission> info = new Pair<>(course, mission);

		if(pairs.isExist(info)){
			if(InputView.getTryMore().equals(NO)){
				return;
			}
		}

		pairs.addPair(info, backendCrewName.getShuffledCrewName());
		OutputView.printPairResult(pairs.getPair(info));
	}


	private void pairLookUp() {
		pairBackgroundInfo = InputView.getPairBackgroundInfo();

	}

	private void pairReset() {
	}

}
