package pairmatching.domain;

public class Pair {

	private Crew leftCrew;
	private Crew rightCrew;

	private Crew extraCrew;

	public Pair(Crew leftCrew, Crew rightCrew) {
		this.leftCrew = leftCrew;
		this.rightCrew = rightCrew;
	}

	public Pair(Crew leftCrew, Crew rightCrew, Crew extraCrew) {
		this.leftCrew = leftCrew;
		this.rightCrew = rightCrew;
		this.extraCrew = extraCrew;
	}
}
