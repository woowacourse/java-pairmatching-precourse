package pairmatching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataInitializer {
	private final static String FILE_PATH = "./src/main/resources";
	private final static String FILE_NAME_BACK = "/backend-crew.md";
	private final static String FILE_NAME_FRONT = "/frontend-crew.md";

	public void initializeCrew() {
		try {
			initializeBackendCrew();
			initializeFrontendCrew();
		} catch (IOException e) {
			// TODO: 에러처리
		}
	}

	private void initializeBackendCrew() throws IOException {
		BufferedReader backendReader = new BufferedReader(new FileReader(FILE_PATH + FILE_NAME_BACK));
		String name;
		while ((name = backendReader.readLine()) != null) {
			// TODO: crew 객체 생성
		}
	}

	private void initializeFrontendCrew() throws IOException {
		BufferedReader frontendReader = new BufferedReader(new FileReader(FILE_PATH + FILE_NAME_FRONT));
		String name;
		while ((name = frontendReader.readLine()) != null) {
			// TODO: crew 객체 생성
		}
	}
}
