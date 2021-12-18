package pairmatching;

public class Application {
	public static void main(String[] args) {
		CrewInitiator crewInitiator = new CrewInitiator();
		crewInitiator.readFile();

		PairMatchingController pairMatchingController = new PairMatchingController();
		pairMatchingController.start();
	}
}
