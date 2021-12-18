package pairmatching.domain;

public class PairMachine {
	private static final PairMachine pairMachine = new PairMachine();

	private PairMachine() {
	}

	public void init() {
	}

	public static PairMachine getInstance() {
		return pairMachine;
	}

}
