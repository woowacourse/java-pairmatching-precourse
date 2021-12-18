package pairmatching.domain;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class BackendCrewName {
	List<String> Names;

	public BackendCrewName(List<String> names) {
		Names = names;
	}

	public List<String> getShuffledCrewName(){
		return Randoms.shuffle(Names);
	}
}
