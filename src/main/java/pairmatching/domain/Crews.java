package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crews {

	private List<String> backEndCrews;
	private List<String> FrontEndCrews;

	public Crews() {
		backEndCrews = new ArrayList<>();
		FrontEndCrews = new ArrayList<>();
		makeBackCrews();
		makeFrontCrews();
	}

	public void makeBackCrews() {
		String readLine = null;
		int lineNumber = 0;
		boolean hasMore = true;
		try {
			FileReader fileReader = new FileReader("src/main/resources/backend-crew.md");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (hasMore) {
				if ((readLine = bufferedReader.readLine()) != null) {
					backEndCrews.add(readLine);
					lineNumber++;
					hasMore = true;
				} else
					hasMore = false;
			}
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}	public void makeFrontCrews() {
		String readLine = null;
		int lineNumber = 0;
		boolean hasMore = true;
		try {
			FileReader fileReader = new FileReader("src/main/resources/frontend-crew.md");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (hasMore) {
				if ((readLine = bufferedReader.readLine()) != null) {
					FrontEndCrews.add(readLine);
					lineNumber++;
					hasMore = true;
				} else
					hasMore = false;
			}
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getCrews(String courseName) {
		if (Course.BACKEND.getName() == courseName) {
			return backEndCrews;
		}
		if (Course.FRONTEND.getName() == courseName){
			return FrontEndCrews;
		}
		return null;
	}
}
