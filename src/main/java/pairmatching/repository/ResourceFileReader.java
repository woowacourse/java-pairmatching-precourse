package pairmatching.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceFileReader {

	public List<String> readLinesFromFile(String fileName) {
		List<String> lines = new ArrayList<>();
		try {
			File file = new File(String.valueOf(ClassLoader.getSystemResource(fileName).getFile()));
			BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				lines.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
