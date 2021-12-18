package pairmatching.maching;

import static pairmatching.maching.MachingRepository.*;

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
		findFeat();
		//기능실행

	}

	private void findFeat() {
		while (true) {
			output.chooseFeat();
			String feat = input.inputFeat();
			if (feat.equals("1")) {
				maching();
			}
			if (feat.equals("2")) {
				finding();
			}
			if (feat.equals("3")) {
				initMaching();
			}
			if (feat.equals("Q")) {
				return;
			}
		}
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

	public void finding() {
		List<String> infos = startPair();
		Course course = Course.findByName(infos.get(0));
		Level level = Level.findByName(infos.get(1));
		String mission = infos.get(2);
		//출력
		//검증해야함
		List<Pair> pairList = findByCourseLevelMission(course, level, mission).getPairList();
		output.printPairList(pairList);
	}

	private List<String> startPair() {
		output.printPairMatching();
		output.printChooseCourseLevelMission();
		return machingService.splitCourseLevelMission(input.inputCourseLevelMission());
	}

	public void initMaching() {
		System.out.println("\n초기화 되었습니다.");
		machingService.initMaching();
	}

}
