package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor;

public class Matcher {

	public static ArrayList<CrewPair> match(List<String> nameList) {
		List<String> randomNameList = camp.nextstep.edu.missionutils.Randoms.shuffle(nameList);
		ArrayList<CrewPair> nowMatchResult = new ArrayList<>();
		int lastIndex = (randomNameList.size() / 2);
		for (int index = 0; index < (randomNameList.size() / 2) * 2; index += 2) {
			ArrayList<String> joinedNameList = new ArrayList<>();
			joinedNameList.add(randomNameList.get(index));
			joinedNameList.add(randomNameList.get(index + 1));
			if (randomNameList.size() % 2 == 1 && index == lastIndex) {
				joinedNameList.add(randomNameList.get(index + 2));
			}
			nowMatchResult.add(new CrewPair(String.join(" : ", joinedNameList)));
		}
		return nowMatchResult;
	}
}
