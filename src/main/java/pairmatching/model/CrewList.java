package pairmatching.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CrewList {

	public ArrayList<String> getBackendCrewList() {
		BufferedReader bufferedReader = getBufferedReader("src/main/resources/backend-crew.md");

		ArrayList<String> backCrewList = new ArrayList<>();
		String line = "";
		while (true) {
			try {
				if (!((line = bufferedReader.readLine()) != null))
					break;
			} catch (IOException e) {
				e.printStackTrace();
			}
			backCrewList.add(line);
		}

		return backCrewList;
	}

	public ArrayList<String> getFrontendCrewList() {
		BufferedReader bufferedReader = getBufferedReader("src/main/resources/frontend-crew.md");

		ArrayList<String> frontCrewList = new ArrayList<>();
		String line = "";
		while (true) {
			try {
				if (!((line = bufferedReader.readLine()) != null))
					break;
			} catch (IOException e) {
				e.printStackTrace();
			}
			frontCrewList.add(line);
		}

		return frontCrewList;
	}

	private BufferedReader getBufferedReader(String str) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(new File(str)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return bufferedReader;
	}
}
