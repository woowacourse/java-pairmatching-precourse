package pairmatching.domains.crew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domains.mission.Course;

public class Crews {
	protected void loadCrews(String resourcePath, Course course, List<Crew> crews) {
		try {
			File file = new File(resourcePath);
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String name = "";
			while ((name = bufReader.readLine()) != null) {
				Crew crew = new Crew(course, name);
				crews.add(crew);
			}
			bufReader.close();
		} catch (Exception e) {
		}
	}

	protected void shuffleCrews(List<Crew> crews) {
		List<Crew> shuffledList = Randoms.shuffle(crews);
	}
}
