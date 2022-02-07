package pairmatching.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResourseReader {
	public static List<String> getFrontendList() {
		try {
			ArrayList<String> frontendList = new ArrayList<>();
			File file = new File("./src/main/resources/frontend-crew.md");
			//스캐너로 파일 읽기
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				frontendList.add(scan.nextLine());
			}
			return frontendList;
		} catch (FileNotFoundException e) {
			return null;
		}
	}

	public static List<String> getBackendList() {
		try {
			ArrayList<String> backendList = new ArrayList<>();
			FileReader file = new FileReader("./src/main/resources/backend-crew.md");

			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				backendList.add(scan.nextLine());
			}
			return backendList;
		} catch (FileNotFoundException e) {
			return null;
		}
	}
}
