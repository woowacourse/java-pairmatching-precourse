package pairmatching.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import pairmatching.constant.OutputConstant;

public class OutputView {

	public void printFunction() {
		System.out.println(OutputConstant.SELECT_FUNCTION_MESSAGE);
		System.out.println(OutputConstant.MATH_PAIR_MESSAGE);
		System.out.println(OutputConstant.SHOW_PAIR_MESSAGE);
		System.out.println(OutputConstant.REFRESH_PAIR_MESSAGE);
		System.out.println(OutputConstant.END_MESSAGE);
	}

	public void showCourseInfo() {
		Path path = Paths.get(OutputConstant.COURSE_INFO_PATH);
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
