package pairmatching.domain;

public class Pair {
	private Crew crewOne;
	private Crew crewAnother;
	private Crew crewThird;

	public Pair(Crew crewOne, Crew crewAnother) {
		this.crewOne = crewOne;
		this.crewAnother = crewAnother;
	}

	public Pair(Crew crewOne, Crew crewAnother, Crew crewThird) {
		this.crewOne = crewOne;
		this.crewAnother = crewAnother;
		this.crewThird = crewThird;
	}

	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(crewOne);
		stringBuffer.append(" : ");
		stringBuffer.append(crewAnother);
		if (crewThird != null) {
			stringBuffer.append(" : ");
			stringBuffer.append(crewThird);
		}
		return stringBuffer.toString();
	}
}
