package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileInput {

	public static List<String> input(String fileName) {
		List<String> list = new ArrayList<>();

		try {
			ClassLoader loader = FileInput.class.getClassLoader();
			FileInputStream file = new FileInputStream(Objects.requireNonNull(loader.getResource(fileName)).getFile());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
			file.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}
}
