package pairmatching.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	static final String BACKEND_CREW_FILE_PATH
		= "C:\\Users\\summrluna\\Desktop\\final\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md";
	static final String FRONTEND_CREW_FILE_PATH
		= "C:\\Users\\summrluna\\Desktop\\final\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md";

	public static String readLine() {
		String input = Console.readLine().trim();
		System.out.println();
		return input;
	}

	public static List<String> backendCrewName() {
		return CrewName(BACKEND_CREW_FILE_PATH);
	}

	public static List<String> frontendCrewName() {
		return CrewName(FRONTEND_CREW_FILE_PATH);
	}

	private static List<String> CrewName(String filePath) {
		List<String> crewName = new ArrayList<>();
		try {
			File file = new File(filePath);
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				crewName.add(sc.next());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			Output.printError(e.getMessage());
		}
		return crewName;
	}
}
