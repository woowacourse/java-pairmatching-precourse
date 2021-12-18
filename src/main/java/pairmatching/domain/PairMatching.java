package pairmatching.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PairMatching {
	private HashMap<Curriculum, List<Crew>> matchingLog;
	private CrewGroup crewGroup = new CrewGroup();

	public PairMatching() {

	}

	public void run(Curriculum curriculum) {
		for (String name : crewGroup.getShuffledCrews()) {
			List<Crew> crews = new LinkedList<>();
			crews.add(new Crew(curriculum.getCourse(), name));
			matchingLog.put(curriculum, crews);
		}
	}




}
