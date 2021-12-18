package pairmatching.Domain;

import java.util.ArrayList;
import java.util.List;

public class Mission {
	private Level level;
	private String name;
	private List<String> pairList = new ArrayList<>();

	public Mission(Level level, String name) {
		this.level = level;
		this.name = name;
	}

	public boolean levelCheck(Level level) {
		return this.level == level;
	}

	public String getName() {
		return this.name;
	}

	public boolean existPair() {
		return this.pairList.size() != 0;
	}

	public void printList() {
		for (String asd : pairList) {
			System.out.println(asd);
		}
	}

	public void setPairList(List<String> pairList) {
		this.pairList = pairList;
	}
}
