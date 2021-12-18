package pairmatching.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.lang.IllegalArgumentException;

import pairmatching.utils.FilePath;
import pairmatching.utils.Validator;

public class FileInputView {
	public static List<String> readFile(String fileAddress) {
		try {
			File file = new File(fileAddress);
			Scanner scanner = new Scanner(file);
			ArrayList<String> nameList = new ArrayList<>();
			HashSet<String> uniqueNameSet = new HashSet<>();
			while (scanner.hasNextLine()) {
				parseOneLine(scanner.nextLine(), nameList, uniqueNameSet);
			}
			return nameList;
		}
		catch (FileNotFoundException | IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return new ArrayList<String>();
		}
	}

	private static void parseOneLine(String fileInput, List<String> nameList, HashSet<String> uniqueNameSet) throws IllegalArgumentException {
		for (String eachName : fileInput.split(" ")) {
			Validator.checkName(eachName);
			Validator.checkDuplicate(eachName, uniqueNameSet);
			nameList.add(eachName);
		}
	}
}
