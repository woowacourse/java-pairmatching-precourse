package pairmatching.controller;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.util.Constants;
import pairmatching.util.FileInputStream;

public class CrewController {
	private static List<String> crewNames = new ArrayList<>();
	//private List<String> shuffledCrew = new ArrayList<>();

	public void loadCrewName() {
		crewNames = FileInputStream.load(Constants.FILE_ADDRESS_BACKEND_CREW);
	}

	public static List<String> shuffle() {
		return Randoms.shuffle(crewNames);
	}

}
