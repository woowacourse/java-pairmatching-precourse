package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Crews;
import pairmatching.domain.Menu;
import pairmatching.domain.PairMatching;

public class InputView {

	private static final String FILE_BACKEND = "backend-crew.md";
	private static final String FILE_FRONTEND = "frontend-crew.md";
	private static final ClassLoader CLASS_LOADER = InputView.class.getClassLoader();
	private static final String ERROR_MESSAGE_INVALID_REMATCHING_OR_PRINT = "네, 아니오 로 입력해주세요";
	private static final String NO = "아니오";
	private static final String YES = "네";

	public static Crews generateCrews() throws IOException {
		String backendPath  = CLASS_LOADER.getResource(FILE_BACKEND).getPath();
		String frontendPath  = CLASS_LOADER.getResource(FILE_FRONTEND).getPath();
		BufferedReader backendCrewData = new BufferedReader(new FileReader(backendPath));
		BufferedReader frontendCrewData = new BufferedReader(new FileReader(frontendPath));
		return new Crews(backendCrewData, frontendCrewData);
	}

	public static Menu inputMenu() {
		return new Menu(input());
	}

	private static String input() {
		return Console.readLine();
	}

	public static PairMatching inputInformation() {
		return new PairMatching(input());
	}

	public static String inputSelectReMatchingOrPrint() {
		String reMatchingOrPrint = input();
		if (!isValidReMatchingOrPrint(reMatchingOrPrint)) {
			throw new IllegalArgumentException(ERROR_MESSAGE_INVALID_REMATCHING_OR_PRINT);
		}
		return reMatchingOrPrint;
	}

	private static boolean isValidReMatchingOrPrint(String reMatchingOrPrint) {
		return reMatchingOrPrint.equals(YES) || reMatchingOrPrint.equals(NO);
	}
}
