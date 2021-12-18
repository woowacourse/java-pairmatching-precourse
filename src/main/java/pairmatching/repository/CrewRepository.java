package pairmatching.repository;

import java.util.List;

import pairmatching.domain.Crew;

public class CrewRepository {
	public static List<Crew> backCrew;
	public static List<Crew> frontCrew;

	public static void setBackCrew(List<Crew> backCrew) {
		CrewRepository.backCrew = backCrew;
		System.out.println(backCrew);
	}

	public static void setFrontCrew(List<Crew> frontCrew) {
		CrewRepository.frontCrew = frontCrew;
		System.out.println(frontCrew);
	}
}
