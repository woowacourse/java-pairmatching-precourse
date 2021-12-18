package pairmatching.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import pairmatching.View.InputView;
import pairmatching.domain.Crew;

public class PairMatchingController {
	private static final int ONE = 1;

	private final InputView inputView;

	public PairMatchingController() {
		inputView = new InputView(new Scanner(System.in));
	}

	public int scanFunctionNumber() {
		return inputView.scanFunctionNumber();
	}

	public void matchFunction(int functionNumber) {
		if (functionNumber == ONE) {
			inputView.scanCourseAndLevelAndMission();
		}
	}

	public void matchPair() {

	}



	public List<String> readBackendCrewNames() {
		List<String> backendCrewNames = new ArrayList<>();
		try {
			File file = new File(getClass().getResource("/backend-crew.md").toURI());
			BufferedReader br = new BufferedReader(new FileReader(file));
			String crewName;
			while ((crewName = br.readLine()) != null) {
				backendCrewNames.add(crewName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return backendCrewNames;
	}

	public List<String> readFrontendCrewNames() {
		List<String> frontendCrewNames = new ArrayList<>();
		try {
			File file = new File(getClass().getResource("/frontend-crew.md").toURI());
			BufferedReader br = new BufferedReader(new FileReader(file));
			String crewName;
			while ((crewName = br.readLine()) != null) {
				frontendCrewNames.add(crewName);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return frontendCrewNames;
	}
}
