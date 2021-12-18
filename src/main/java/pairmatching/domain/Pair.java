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

	public boolean haveExtraCrew() {
		return this.extraCrew != null;
	}

	@Override
	public String toString() {
		if (extraCrew == null) {
			return leftCrew.getName() + " : " + rightCrew.getName();
		}
		return leftCrew.getName() + " : " + rightCrew.getName() + " : " + extraCrew.getName();
	}
}
