package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {

	public List<String> readFile(String fileName) {
		List<String> stringList = new ArrayList<>();
		FileInputStream file = null;
		BufferedReader bufferedReader = null;
		ClassLoader loader = FileScanner.class.getClassLoader();
		try {
			file = new FileInputStream(loader.getResource(fileName).getFile());
			bufferedReader = new BufferedReader(new InputStreamReader(file, "euc-kr"));

			// File file = new File(
			// 	"C:\\Users\\박주원\\Documents\\woowacourse\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md");
			// File file = new File("backend-crew.md");
			// bufferedReader = new BufferedReader(new FileReader(file));

			String line = "";

			while ((line = bufferedReader.readLine()) != null) {
				//log
				System.out.println("파일 한 라인 읽어짐");
				stringList.add(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// file.close();
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return stringList;
	}
}
