package pairmatching.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constants.ExceptionMessages;

public class InputView {
	private List<String> backEndCrewNames = new ArrayList<>();
	private List<String> frontEndCrewNames = new ArrayList<>();
	public static final String BACKEND_FILE_LOCATION = "src/main/resources/backend-crew.md";
	public static final String FRONTEND_FILE_LOCATION = "src/main/resources/frontend-crew.md";

	public InputView() {

	}

	public String inputMatchingInfo() {
		return Console.readLine();
	}

	public String inputChoosingFeature() {
		String regex = "[1-3Q]{1}";
		String input = Console.readLine();
		if (!input.matches(regex)) {
			throw new IllegalArgumentException(ExceptionMessages.ERROR_PREFIX + "잘못된 기능 입력입니다.");
		}
		return input;
	}

	public List<String> getBackEndCrewNames() {
		return readCrewNamesFile(backEndCrewNames, BACKEND_FILE_LOCATION);
	}

	public List<String> getFrontEndCrewNames() {
		return readCrewNamesFile(frontEndCrewNames, FRONTEND_FILE_LOCATION);
	}

	private List<String> readCrewNamesFile(List<String> crewNames, String location) {
		try {
			File file = new File(location);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				crewNames.add(line);
			}
		} catch (FileNotFoundException exception) {
			System.out.println(exception.getMessage());
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
		return crewNames;
	}
}
