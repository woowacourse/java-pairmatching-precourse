package pairmatching.utill;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Course;
import pairmatching.view.OutputView;

public class CrewFileReader {
	private static final String FILE_READ_ERROR_MSG = "파일을 읽을 수 없습니다.";

	public static List<String> getCrewList(Course course) {
		List<String> crewList = new ArrayList<>();
		try {
			File file = getFile(course);
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String crewName = "";
			while ((crewName = bufferedReader.readLine()) != null) {
				crewList.add(crewName);
			}
		} catch (IOException e) {
			OutputView.displayErrorMsg(FILE_READ_ERROR_MSG);
		}
		return crewList;
	}

	private static File getFile(Course course) {
		if (course.equals(Course.BACKEND)) {
			return new File("src/main/resources/backend-crew.md");
		}
		return new File("src/main/resources/frontend-crew.md");
	}
}
