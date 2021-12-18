package pairmatching.domain;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class FrontendCrewName {
	List<String> Names;

	public FrontendCrewName(List<String> names) {
		Names = names;
	}

	public List<String> getShuffledCrewName() {
		return Randoms.shuffle(Names);
	}
}
