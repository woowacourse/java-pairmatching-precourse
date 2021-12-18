package pairmatching.util;

import pairmatching.model.CrewPair;

import java.io.*;
import java.util.ArrayList;
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

	public void readSavedMatch(String path) throws FileNotFoundException {
		try {
			FileInputStream fileInputStream = new FileInputStream(MATCH_RESULT_PATH + path);
			byte[] readBuffer = new byte[fileInputStream.available()];
			while (fileInputStream.read(readBuffer) != -1) {
				System.out.println(new String(readBuffer));
			}
			fileInputStream.close();
		} catch (Exception e) {
		}
	}

	public List<String> getSavedMatch(String fileName) {
		String names = "";
		try {
			FileInputStream fileInputStream = new FileInputStream(MATCH_RESULT_PATH + fileName);
			byte[] readBuffer = new byte[fileInputStream.available()];
			while (fileInputStream.read(readBuffer) != -1) {
				names = new String(readBuffer);
			}
			fileInputStream.close();
		} catch (Exception e) {
		}
		return Arrays.asList(names.split("\n"));
	}
	
	public void deleteMatchFiles() {
		File path = new File(MATCH_RESULT_PATH);
		File[] matchFiles = path.listFiles();
		for (int i = 0;  i < matchFiles.length; i++) {
			matchFiles[i].delete();
		}
	}

	public boolean isFileExist(String fileName) {
		File path = new File(MATCH_RESULT_PATH + fileName);
		return path.exists();
	}
}
