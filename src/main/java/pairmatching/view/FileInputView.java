package pairmatching.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pairmatching.utils.FilePath;
import pairmatching.utils.Validator;

public class FileInputView {
	public static List<String> readFile(String fileAddress) {
		try {
			File file = new File(fileAddress);
			Scanner scanner = new Scanner(file);
			ArrayList<String> nameList = new ArrayList<>();
			while (scanner.hasNextLine()) {
				parseOneLine(scanner.nextLine(), nameList);
			}
			return nameList;
		}
		catch (FileNotFoundException | IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return new ArrayList<String>();
		}
	}

	private static void parseOneLine(String fileInput, List<String> nameList) {
		for (String eachName : fileInput.split("\\s+")) {
			Validator.checkName(eachName);
			nameList.add(eachName);
		}
	}
}
