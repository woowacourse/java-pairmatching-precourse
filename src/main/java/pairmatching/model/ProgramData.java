package pairmatching.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProgramData {
	private List<Crew> backendCrews = new ArrayList<Crew>();
	private List<Crew> frontendCrews = new ArrayList<Crew>();
	private Map<String, Boolean> pairExist = new HashMap<>();
	private Map<String, List<Crew>> pairList = new HashMap<>();

	public ProgramData() throws FileNotFoundException {
		makeCrewsFromFile();
	}
	public boolean hasPair(String key) {
		return pairExist.containsKey(key);
	}

	private void makeCrewsFromFile() throws FileNotFoundException {
		makeBackendCrew();
		makeFrontendCrew();
	}

	public List<Crew> getBackendCrews() {
		return backendCrews;
	}

	public void setBackendCrews(List<Crew> backendCrews) {
		this.backendCrews = backendCrews;
	}

	public List<Crew> getFrontendCrews() {
		return frontendCrews;
	}

	public void setFrontendCrews(List<Crew> frontendCrews) {
		this.frontendCrews = frontendCrews;
	}

	public Map<String, Boolean> getPairExist() {
		return pairExist;
	}

	public void setPairExist(Map<String, Boolean> pairExist) {
		this.pairExist = pairExist;
	}

	public Map<String, List<Crew>> getPairList() {
		return pairList;
	}

	public void setPairList(Map<String, List<Crew>> pairList) {
		this.pairList = pairList;
	}

	private void makeFrontendCrew() throws FileNotFoundException {
		URL resource = getClass().getClassLoader().getResource("frontend-crew.md");
		String filePath = resource.getFile();
		Scanner scanner = new Scanner(new File(filePath));
		while (scanner.hasNext()) {
			String name = scanner.next();
			Course course = Course.FRONTEND;
			Crew tmpCrew = new Crew(course, name);
			frontendCrews.add(tmpCrew);
		}
	}

	private void makeBackendCrew() throws FileNotFoundException {
		URL resource = getClass().getClassLoader().getResource("backend-crew.md");
		String filePath = resource.getFile();
		Scanner scanner = new Scanner(new File(filePath));
		while (scanner.hasNext()) {
			String name = scanner.next();
			Course course = Course.BACKEND;
			Crew tmpCrew = new Crew(course, name);
			backendCrews.add(tmpCrew);
		}
	}

}
