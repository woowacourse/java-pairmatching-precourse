package pairmatching.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewNameReader {
	public static final String ERROR_MESSAGE_FOR_FILE_NOT_FOUND = "[ERROR] 파일이 없습니다";
	public static final String ERROR_MESSAGE_FOR_IO_EXCEPTION = "[ERROR] 입출력 과정에서 오류가 발생했습니다.";
	public static final String FILE_PATH_FOR_BACKEND_CREW_NAME = "src/main/resources/backend-crew.md";
	public static final String FILE_PATH_FOR_FRONTEND_CREW_NAME = "src/main/resources/frontend-crew.md";

	public static List<String> getFrontendCrewNameList() {
		File file = new File(FILE_PATH_FOR_FRONTEND_CREW_NAME);
		return getCrewNames(file);
	}

	public static List<String> getBackendCrewNameList() {
		File file = new File(FILE_PATH_FOR_BACKEND_CREW_NAME);
		return getCrewNames(file);
	}

	private static List<String> getCrewNames(File file) {
		List<String> crewNameList = new ArrayList<>();

		try {
			readCrewNames(file, crewNameList);
		} catch (FileNotFoundException e) {
			System.out.println(ERROR_MESSAGE_FOR_FILE_NOT_FOUND);
		} catch (IOException e) {
			System.out.println(ERROR_MESSAGE_FOR_IO_EXCEPTION);
		}

		return crewNameList;
	}

	private static void readCrewNames(File file, List<String> crewNameList) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			crewNameList.add(line);
		}
		bufferedReader.close();
	}
}
