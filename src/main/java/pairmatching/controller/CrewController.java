package pairmatching.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import pairmatching.domain.Crew;

public class CrewController {
	public static List<String> makeList(List<String> domainList, List<String> crews) throws IOException {
		BufferedReader reader = null;
		try {
			String filePath = "src/main/resources/backend-crew.md";
			File file = new File(filePath);

			reader = new BufferedReader(new FileReader(file));
			String name;
			while ((name = reader.readLine()) != null) {
				Crew.addToList(name, crews);
			}
		} finally {
			assert reader != null;
			reader.close();
		}
		return crews;
	}
}
