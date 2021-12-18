package pairmatching.domain.crew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;

public class Crew {
	// 크루, 인원
	private Map<Course, List<String>> crewMap = new HashMap<>();

	public Crew(Course type, List<String> crewList){
		// System.out.println("input");
		this.crewMap.put(type, crewList);
	}

	public void getCrewByType(Course type){
		List<String> list = crewMap.get(type);
		for(String name : list){
			System.out.print(name+" ");
		}
		System.out.println();
	}

	public List<String> shuffleCrewList(Course type){
		List<String> list = crewMap.get(type);
		return Randoms.shuffle(list);
	}

}
