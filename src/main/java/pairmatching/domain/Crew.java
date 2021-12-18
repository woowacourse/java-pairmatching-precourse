package pairmatching.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Crew {
	String course;
	List<String> names = new ArrayList<>();

	public Crew(String course) {
		this.course = course;
		File file = null;
		if (course.equals("백엔드")) {
			file = new File("src/main/resources/backend-crew.md");
		}
		if (course.equals("프론트엔드")) {
			file = new File("/resources/frontend-crew.md");
		}
		readFile(file);
	}

	public void readFile(File file) {
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				names.add(line);
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public List<String> getNames() {
		names = Randoms.shuffle(names);
		return names;
	}
}
