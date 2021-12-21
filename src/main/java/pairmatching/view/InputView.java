package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static pairmatching.util.Validator.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import pairmatching.domain.Curriculum;

public class InputView {

	private static final String DELIMITER = ",";

	public static List<String> getCrew(String path) {
		List<String> crews = new LinkedList<>();
		try {
			BufferedReader reader = new BufferedReader(
				new FileReader(path)
			);
			String crew;
			while ((crew = reader.readLine()) != null) {
				crews.add(crew);
			}
			reader.close();
			return crews;
		} catch (Exception e) {
			logError(e);
			return new LinkedList<>();
		}
	}

	public static String readString() {
		return readLine();
	}

	public static Curriculum readCurriculum() {
		try {
			String readLine = readLine();
			validateCurriculumInput(readLine);
			return Arrays.stream(readLine.split(DELIMITER))
				.collect(new Curriculum()); // collect object 생성 추가해야함.
		} catch (Exception error) {
			logError(error);
			readCurriculum();
		}
	}

	private static void logError(Exception error) {
		System.out.println(error.getMessage());
	}

}
