package pairmatching.domain;

public class Pair {

	private Crew crew1;
	private Crew crew2;
	private Crew crew3;
	private int count;

	public Pair(Crew crew1, Crew crew2, Crew crew3) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = crew3;
		count = 3;
	}

	public Pair(Crew crew1, Crew crew2) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		count = 2;
	}
}
