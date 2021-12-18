package pairmatching.util;

import pairmatching.model.CrewPair;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

	private static final String MATCH_RESULT_PATH = "src/main/resources/match/";

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

	public void saveMatchResult(String fileName, String list) throws IOException {
		BufferedOutputStream bs = null;
		try {
			bs = new BufferedOutputStream(new FileOutputStream(MATCH_RESULT_PATH + fileName));
			bs.write(list.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bs.close();
		}
	}
}
