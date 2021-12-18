package pairmatching.domain;

public class Pairs {
	private Crew crew1;
	private Crew crew2;
	private Crew crew3;

	public Pairs(Crew crew1, Crew crew2) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = null;
	}

	public Pairs(Crew crew1, Crew crew2, Crew crew3) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = crew3;
	}

	public void addMoreCrew(Crew crew) {
		this.crew3 = crew;
	}

	@Override
	public String toString() {
		if (crew3 != null) {
			return (crew1.getName() + " : " + crew2.getName() + ": " + crew3.getName());
		}
		return (crew1.getName() + " : " + crew2.getName());

	}
}
