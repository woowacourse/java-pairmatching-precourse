package pairmatching.controller;

import static constants.PairMatchingConstants.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.BackendCrewName;
import pairmatching.domain.FrontendCrewName;
import pairmatching.view.OutputView;

public class PairMatchingController {
	private BackendCrewName backendCrewName;
	private FrontendCrewName frontendCrewName;

	public void start() {
		getCrewName();
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
}
