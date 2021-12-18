package pairmatching.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import pairmatching.view.OutputView;

public class IOUtils {
	private static final String BACKEND_PATH = "src/main/resources/backend-crew.md";
	private static final String FRONTEND_PATH = "src/main/resources/frontend-crew.md";

	public static List<String> readBackendCrews() {
		List<String> lines = new ArrayList<>();

		try {
			lines = Files.readAllLines(Paths.get(BACKEND_PATH));
		} catch (IOException e) {
			OutputView.printIoError();
		}

		return lines;
	}

	public static List<String> readFrontendCrews() {
		List<String> lines = new ArrayList<>();

		try {
			lines = Files.readAllLines(Paths.get(FRONTEND_PATH));
		} catch (IOException e) {
			OutputView.printIoError();
		}

		return lines;
	}
}
