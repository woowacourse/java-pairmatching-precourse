package pairmatching.util;

import static pairmatching.constants.ErrorMessage.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {
	public static List<String> readFile(String path) {
		List<String> content = new LinkedList<>();
		File file = new File(path);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				content.add(line);
			}
		} catch (IOException e) {
			throw (new IllegalArgumentException(FILE_NOT_EXIST));
		}
		return content;
	}
}
