package pairmatching.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeopleReader {

	List<String> backEnd;
	List<String> frontEnd;

	public PeopleReader() throws IOException {
		backEnd = createBackPeopleList();
		frontEnd = createFrontPeopleList();
	}

	public List<String> getFrontEnd() {
		return frontEnd;
	}

	public List<String> getBackEnd() {
		return backEnd;
	}

	public List<String> createBackPeopleList() throws IOException {
		List<String> people = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(
			"C:\\Users\\dbswn\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\backend-crew.md"));
		String person;
		while ((person = reader.readLine()) != null) {
			people.add(person);
		}
		return people;
	}

	public List<String> createFrontPeopleList() throws IOException {
		List<String> people = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(
			"C:\\Users\\dbswn\\Desktop\\java-pairmatching-precourse\\src\\main\\resources\\frontend-crew.md"));
		String person;
		while ((person = reader.readLine()) != null) {
			people.add(person);
		}
		return people;
	}
}
