package pairmatching;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		// TODO 구현 진행
		CoreController tmp = new CoreController();
		ArrayList<String> courseLevelMission = tmp.getCourseLevelMission();
		tmp.matchPair(courseLevelMission.get(0), courseLevelMission.get(1), courseLevelMission.get(2));
	}
}
