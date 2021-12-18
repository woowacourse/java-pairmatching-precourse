package pairmatching.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MissionReader {
	public static final String ERROR_MESSAGE_FOR_FILE_NOT_FOUND = "[ERROR] 파일이 없습니다";
	public static final String ERROR_MESSAGE_FOR_IO_EXCEPTION = "[ERROR] 입출력 과정에서 오류가 발생했습니다.";
	public static final String FILE_PATH_FOR_MISSION_INFO = "src/main/resources/missions.md";

	public static List<String> readMissionString() {
		File file = new File(FILE_PATH_FOR_MISSION_INFO);
		return getMissionNames(file);
	}

	private static List<String> getMissionNames(File file) {
		List<String> missionNameList = new ArrayList<>();

		try {
			readMissionNames(file, missionNameList);
		} catch (FileNotFoundException e) {
			System.out.println(ERROR_MESSAGE_FOR_FILE_NOT_FOUND);
		} catch (IOException e) {
			System.out.println(ERROR_MESSAGE_FOR_IO_EXCEPTION);
		}

		return missionNameList;
	}

	private static void readMissionNames(File file, List<String> missionNameList) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = "";
		while ((line = bufferedReader.readLine()) != null) {
			missionNameList.add(line);
		}
		bufferedReader.close();
	}
}
