package pairmatching.domain;

import java.util.List;

import pairmatching.constant.Notification;

public class PairCrew {
	private static final int PAIR_CREW_MAXIMUM_VALUE = 3;
	private List<Crew> crews;

	public PairCrew(List<Crew> crews) {
		this.crews = crews;
	}

	public static PairCrew of(List<Crew> crews) {
		validateSize(crews);
		return new PairCrew(crews);
	}

	private static void validateSize(List<Crew> crews) {
		if(crews.size()> PAIR_CREW_MAXIMUM_VALUE) {
			throw new IllegalArgumentException(Notification.NOT_GATHER_PAIR_CREW.getMessage());
		}
	}
}
