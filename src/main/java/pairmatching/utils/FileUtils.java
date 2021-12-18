package pairmatching.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
	private static final String NO_SUCH_FILE_EXCEPTION = "[ERROR] 잘못된 파일이 입력되었습니다.";
	private static final String NO_SUCH_COURSE_EXCEPTION = "[ERROR] 잘못된 코스 이름이 입력되었습니다.";
	private static final String BACKEND = "백엔드";
	private static final String BACKEND_FILE = "backend-crew.md";
	private static final String FRONTEND = "프론트엔드";
	private static final String FRONTEND_FILE = "frontend-crew.md";

	private FileUtils() {
	}

	public static List<String> readFile(String courseName) {
		String path = FileUtils.class.getClassLoader().getResource(toFileName(courseName)).getPath();
		List<String> crews;
		try {
			crews = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			throw new IllegalArgumentException(NO_SUCH_FILE_EXCEPTION);
		}
		return crews;
	}

	private static String toFileName(String courseName) {
		if (courseName.equals(BACKEND)) {
			return BACKEND_FILE;
		}
		if (courseName.equals(FRONTEND))
			return FRONTEND_FILE;
		throw new IllegalArgumentException(NO_SUCH_COURSE_EXCEPTION);
	}
}
