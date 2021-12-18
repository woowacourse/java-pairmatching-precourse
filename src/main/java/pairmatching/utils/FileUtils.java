package pairmatching.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtils {
	private FileUtils() {
	}

	public static List<String> readList(String filePath) throws IOException {
		File file = new File(filePath);
		List<String> crewList = new ArrayList<>();

		if (file.exists()) {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = reader.readLine()) != null) {
				crewList.add(line);
			}
		}

		return Collections.unmodifiableList(crewList);
	}
}
