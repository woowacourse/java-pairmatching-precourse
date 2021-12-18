package pairmatching;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		// 백엔드 크루 획득
		List<String> backCrewNames = getCrewName("backend-crew.md");
		List<String> frontCrewNames = getCrewName("frontend-crew.md");

	}

	private static List<String> getCrewName(String fileName) {
		List<String> backCrewNames = null;
		URL resource = Application.class.getClassLoader().getResource(fileName);
		Path path = new File(resource.getPath()).toPath();
		try {
			backCrewNames = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return backCrewNames;
	}
}
