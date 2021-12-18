package pairmatching.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputStream {
	public static List<String> load(String address) {
		List<String> resultList = new ArrayList<>();
		try {
			File file = new File(address);
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				resultList.add(line);
			}
			bufReader.close();
		} catch (IOException e) {
			e.getStackTrace();
		}
		return resultList;
	}
}
