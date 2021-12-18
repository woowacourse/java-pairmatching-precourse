package pairmatching.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
	private static final String NO_SUCH_FILE_EXCEPTION = "[ERROR] 잘못된 파일이 입력되었습니다.";

	private FileUtils() {
	}

	public static List<String> readFile(String fileName) {
		String path = FileUtils.class.getClassLoader().getResource(fileName).getPath();
		List<String> crews;
		try {
			crews = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_SUCH_FILE_EXCEPTION);
		}
		return crews;
	}
}
