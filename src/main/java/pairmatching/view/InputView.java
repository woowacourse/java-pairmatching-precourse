package pairmatching.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Crews;
import pairmatching.domain.Menu;

public class InputView {

	private static final String FILE_BACKEND = "backend-crew.md";
	private static final String FILE_FRONTEND = "frontend-crew.md";
	private static final ClassLoader CLASS_LOADER = InputView.class.getClassLoader();

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
}
