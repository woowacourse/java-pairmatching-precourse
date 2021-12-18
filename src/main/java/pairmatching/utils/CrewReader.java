package pairmatching.utils;

import pairmatching.view.OutputView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CrewReader {
	private static final String SPACE = " ";

	public static List<String> getFileCrew(String fileLocation) {
		try {
			BufferedReader crewFile = new BufferedReader(new FileReader(fileLocation));

			String[] names = getNames(crewFile);
			crewFile.close();

			return Arrays.asList(names);
		} catch (IOException e) {
			OutputView.errorMessage(e.getMessage());
		}

		return Constant.NOT_FOUNDED;
	}

	private static String[] getNames(BufferedReader reader) throws IOException {
		String name;
		StringBuilder getNameLine = new StringBuilder();
		while ((name = reader.readLine()) != null) {
			getNameLine.append(name).append(SPACE);
		}
		String getNames = getNameLine.toString();

		return getNames.split(SPACE);
	}

	private CrewReader() {

	}
}
