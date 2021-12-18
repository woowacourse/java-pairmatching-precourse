package pairmatching;

import static pairmatching.Constant.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.SelectedMission;

public class Input {
	public static Function requestToSelectFunction() {
		Printer.printFunctions();
		return readFunctionSelected();
	}

	private static Function readFunctionSelected() {
		try {
			String input = Console.readLine();
			InputValidator.validateAllowedFunction(input);
			return Function.byKey(input);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readFunctionSelected();
		}
	}

	public static SelectedMission requestToSelectMission() {
		Printer.printMissionInputRequest();
		return readMissionSelected();
	}

	private static SelectedMission readMissionSelected() {
		try {
			String input = Console.readLine();
			String[] elements = input.split(COMMA);

			InputValidator.validateMissionInputContainsThreeElements(input);
			InputValidator.validateAllowedOption(elements);
			return new SelectedMission(Course.byName(elements[0]), Level.byName(elements[1]), Mission.byName(elements[2]));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readMissionSelected();
		}
	}

	public static boolean requestMatchingAgain() {
		Printer.printMatchingAgain();
		return readMatchingAgain();
	}

	private static boolean readMatchingAgain() {
		try {
			String input = Console.readLine();
			InputValidator.validateYesOrNo(input);
			return input.equals(YES);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readMatchingAgain();
		}
	}

	public static List<String> readBackendCrewName() {
		List<String> result = new ArrayList<>();

		try {
			BufferedReader bufReader = getBackendReader();
			String line;
			while ((line = bufReader.readLine()) != null) {
				result.add(line);
			}
			bufReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	public static List<String> readFrontendCrewName() {
		List<String> result = new ArrayList<>();

		try {
			BufferedReader bufReader = getFrontendReader();
			String line;
			while ((line = bufReader.readLine()) != null) {
				result.add(line);
			}
			bufReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return result;
	}

	private static BufferedReader getBackendReader() throws FileNotFoundException {
		File file = new File("src/main/resources/backend-crew.md");
		FileReader filereader = new FileReader(file);
		BufferedReader bufReader = new BufferedReader(filereader);
		return bufReader;
	}

	private static BufferedReader getFrontendReader() throws FileNotFoundException {
		File file = new File("src/main/resources/backend-crew.md");
		FileReader filereader = new FileReader(file);
		BufferedReader bufReader = new BufferedReader(filereader);
		return bufReader;
	}
}
