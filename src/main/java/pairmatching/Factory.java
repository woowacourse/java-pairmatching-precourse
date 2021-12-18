package pairmatching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factory {
	public Scanner backendScanner;
	public Scanner frontendScanner;

	public Factory() {
		try {
			this.backendScanner = new Scanner(new FileInputStream("src/main/resources/backend-crew.md"));
			this.frontendScanner = new Scanner(new FileInputStream("src/main/resources/frontend-crew.md"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<String> getBackEndCrewList() {
		List<String> crews = new ArrayList<>();
		while (backendScanner.hasNext()) {
			crews.add(backendScanner.next());
		}
		return crews;
	}

	public List<String> getFrontEndCrewList() {
		List<String> crews = new ArrayList<>();
		while (frontendScanner.hasNext()) {
			crews.add(frontendScanner.next());
		}
		return crews;
	}

}
