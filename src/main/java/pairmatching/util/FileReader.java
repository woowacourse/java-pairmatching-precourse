package pairmatching.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {

	public List<String> readCrewList(String path) {
		String names = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			byte[] readBuffer = new byte[fileInputStream.available()];
			while (fileInputStream.read(readBuffer) != -1) {
				names = new String(readBuffer);
			}
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<String> crewNames = Arrays.asList(names.split("\n"));
		return crewNames;
	}
}
