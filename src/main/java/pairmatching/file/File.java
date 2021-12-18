package pairmatching.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class File {

	public static ArrayList<String> readFile(String fileName) {
		ArrayList<String> data = new ArrayList<>();
		try {
			Path path = Paths.get(fileName);
			List<String> lines = Files.readAllLines(path);

			for (String line : lines) {
				data.add(line.trim());
			}
		} catch(IOException ioException) {

		}
		return data;
	}
}
