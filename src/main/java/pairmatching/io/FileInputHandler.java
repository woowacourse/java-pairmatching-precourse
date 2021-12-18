package pairmatching.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInputHandler {

	public List<String> readCrewMember(String location) {
		List<String> crewList = new ArrayList<String>();
		try {
			Scanner fileIn = openFile(location);
			while (fileIn.hasNext()) {
				crewList.add(fileIn.nextLine());
			}
			fileIn.close();
		} catch (FileNotFoundException fnfe) { }
		return crewList;
	}

	private Scanner openFile(String location) throws FileNotFoundException {
		Scanner filein = new Scanner(new File(location));
		return filein;
	}
}
