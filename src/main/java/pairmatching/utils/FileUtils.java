package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtils {
	private FileUtils() {
	}

	public static List<String> readList(String filePath) {
		File file = new File(filePath);
		List<String> crewList = new ArrayList<>();

		if (file.exists()) {
			BufferedReader reader = null;
			reader = fineFile(file);
			String line = null;

			extracted(crewList, reader);
		}

		return Collections.unmodifiableList(crewList);
	}

	private static BufferedReader fineFile(File file) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("[ERROR] 해당 파일을 찾을 수 없습니다.");
		}
		return reader;
	}

	private static void extracted(List<String> crewList, BufferedReader reader) {
		String line;
		while (true) {
			try {
				if ((line = reader.readLine()) == null)
					break;
			} catch (IOException e) {
				throw new IllegalArgumentException("[ERROR] 파일 읽는게 잘못되었습니다.");
			}
			crewList.add(line);
		}
	}
}
