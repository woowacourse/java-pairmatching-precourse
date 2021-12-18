package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.view.OutputView;

public class Pair {
	private static final int PROCESS = 0;

	public Function function;
	// 과정, 레벨, 미션

	public Pair(int num) {
		function = new Function(num);
		OutputView.printProcessMissionLevel();
	}

	public void shuffleCrew(String[] information) throws IOException {
		String process = information[PROCESS];
		String filePath = "";
		if(process.equals("백엔드")) {
			filePath = "backend-crew.md";
		}

		if(process.equals("프론트엔드")) {
			filePath = "frontend_crew.md";
		}

		List<String> crewNames = Randoms.shuffle(getCrewNames(filePath));
	}

	private List<String> getCrewNames(String filePath) throws IOException {
		List<String> crewName = new ArrayList<>();
		BufferedReader bufferedReader = new BufferedReader(
			new FileReader("filePath"));

		while(true) {
			String line = bufferedReader.readLine();
			crewName.add(line);
			if(line == null) break;
		}
		bufferedReader.close();

		return crewName;
	}
}
