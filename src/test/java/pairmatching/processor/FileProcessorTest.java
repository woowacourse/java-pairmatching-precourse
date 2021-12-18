package pairmatching.processor;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import pairmatching.domain.Course;

class FileProcessorTest {
	@Test
	public void crewMemberRead() {
		FileProcessor fileProcessor = new FileProcessor();
		try {
			List<String> backEndCrewNames = fileProcessor.readCrewNames(Course.BACKEND);
			List<String> frontEndCrewNames = fileProcessor.readCrewNames(Course.FRONTEND);
			printReadNames(backEndCrewNames,Course.BACKEND);
			printReadNames(frontEndCrewNames,Course.FRONTEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printReadNames(List<String> crewNames, Course course) {
		System.out.println(course.getTitle() + " 조회 결과");
		for (String crewName : crewNames) {
			System.out.println(crewName);
		}
	}
}
