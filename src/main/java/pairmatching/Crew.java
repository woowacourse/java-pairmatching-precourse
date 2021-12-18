package pairmatching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class Crew {


	// 크루, 인원
	private Map<Type, List<String>> crewMap = new HashMap<>();

	public Crew(Type type, List<String> crewList){
		// System.out.println("input");
		this.crewMap.put(type, crewList);
	}

	public void getCrewByType(Type type){
		List<String> list = crewMap.get(type);
		for(String name : list){
			System.out.print(name+" ");
		}
		System.out.println();
	}

	public List<String> shuffleCrewList(Type type){
		List<String> list = crewMap.get(type);
		return Randoms.shuffle(list);
	}

}
