package pairmatching.view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import pairmatching.Application;

public class InputView {
	public static List<String> getCrewNameByFile(String fileName) {
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
