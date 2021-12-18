package pairmatching.maching;

import java.util.List;

import pairmatching.edu.Course;
import pairmatching.edu.Level;
import pairmatching.view.Input;
import pairmatching.view.Output;

public class MachingController {
	private final MachingService machingService = new MachingService();
	private final Input input = new Input();
	private final Output output = new Output();

	public void run() {
		// findFeat();
		//기능실행

	}

	public void maching() {
		List<String> infos = startPair();
		Course course = Course.findByName(infos.get(0));
		Level level = Level.findByName(infos.get(1));
		String mission = infos.get(2);
		if (machingService.isExist(course, level, mission)) {
			output.printExistMaching();
			input.inputYesNO().equals("아니오");
			return;
		}

		output.printPairList(machingService.makeMaching(course, level, mission));

	}

	private List<String> startPair() {
		output.printPairMatching();
		output.printChooseCourseLevelMission();
		return machingService.splitCourseLevelMission(input.inputCourseLevelMission());
	}

	public void initMaching() {
		machingService.initMaching();
	}

}
