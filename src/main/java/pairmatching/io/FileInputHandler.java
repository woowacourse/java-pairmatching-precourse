package pairmatching.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInputHandler {

	public List<String> readCrewMember(String location) throws FileNotFoundException {
		Scanner fileIn = openFile(location);
		List<String> crewList = new ArrayList<String>();
		while(fileIn.hasNext()) {
			crewList.add(fileIn.nextLine());
		}
		return crewList;
	}

	private Scanner openFile(String location) throws FileNotFoundException {
		Scanner filein = new Scanner(new File(location));
		return filein;
	}
}
