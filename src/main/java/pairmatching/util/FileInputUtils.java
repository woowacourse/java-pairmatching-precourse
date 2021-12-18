package pairmatching.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileInputUtils {

	public static final String MD_RESOURCES_PATH = Paths.get("").toAbsolutePath() + "\\src\\main\\resources\\";
	public static final String FRONTEND_MD_FULL_PATH = MD_RESOURCES_PATH + "frontend-crew.md";
	public static final String BACKEND_MD_FULL_PATH = MD_RESOURCES_PATH + "backend-crew.md";
	public static final Path FRONTEND_PATH = Paths.get(FRONTEND_MD_FULL_PATH);
	public static final Path BACKEND_PATH = Paths.get(BACKEND_MD_FULL_PATH);


	public static List<String> getBackendCrewsNames() {
		List<String> crewNames = new ArrayList<>();
		try {
			crewNames = Files.readAllLines(BACKEND_PATH, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crewNames;
	}

	public static List<String> getFrontendCrewsNames() {
		List<String> crewNames = new ArrayList<>();
		try {
			crewNames = Files.readAllLines(FRONTEND_PATH, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return crewNames;
	}


}
