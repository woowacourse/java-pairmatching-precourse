package pairmatching.maching;

import pairmatching.View.Input;
import pairmatching.View.Output;

public class MachingController {

	private final Input input = new Input();
	private final Output output = new Output();

	public void run() {
		output.chooseFeat();
		String feat = input.inputFeat();
		//기능실행

		//페어매칭부분
		output.printPairMatching();

		output.printChooseCourseLevelMission();
		input.inputCourseLevelMission();
	}

}
