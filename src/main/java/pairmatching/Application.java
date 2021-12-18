package pairmatching;

import pairmatching.domain.CrewGroup;

public class Application {
	public static void main(String[] args) {
		CrewGroup crewGroup = new CrewGroup();
		System.out.println(crewGroup.getShuffledCrews());
	}
}
