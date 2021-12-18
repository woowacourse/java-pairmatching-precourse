package pairmatching.domain;

public class Pair {
	private Crew crew1;
	private Crew crew2;
	private Crew crew3;

	Pair(Crew crew1, Crew crew2) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = new Crew(Course.BACKEND, "");
	}

	Pair(Crew crew1, Crew crew2, Crew crew3) {
		this.crew1 = crew1;
		this.crew2 = crew2;
		this.crew3 = crew3;
	}

	public Crew getCrew1() {
		return crew1;
	}

	public Crew getCrew2() {
		return crew2;
	}

	public Crew getCrew3() {
		return crew3;
	}

	public boolean existCrew3() {
		if (crew3.getName() == "") {
			return false;
		}
		return true;
	}
}
