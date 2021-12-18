package pairmatching;

public class Program {
	private final CrewList frontEndCrews;
	private final CrewList backEndCrews;

	public Program() {
		frontEndCrews = Reader.getFrontEndCrewList();
		backEndCrews = Reader.getBackEndEndCrewList();
	}
}
