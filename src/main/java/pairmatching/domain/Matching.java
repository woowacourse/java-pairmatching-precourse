package pairmatching.domain;

import static pairmatching.domain.Course.*;

import java.util.List;
import java.util.Objects;

public class Matching {
	private Course course;
	private String mission;
	private Level level;
	private Pair pair;
	private List<String> matchingList;

	public Matching(Course course, Level level, String mission) {
		pair = new Pair();
		this.course = course;
		this.mission = mission;
		this.level = level;
	}

	public void insertMatchingList(Course course){
		matchingList = pairMatching(course);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Matching matching = (Matching)o;
		return course == matching.course &&
			Objects.equals(mission, matching.mission) &&
			level == matching.level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, mission, level);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String[] pair : pair.getPairList()){
			sb.append(String.join(" : ", pair)).append("\n");
		}
		return sb.toString();
	}

	private List<String> pairMatching(Course course){
		String fileName = "";
		if(course.equals(BACKEND)){
			fileName = "backend";
		}else if(course.equals(FRONTEND)){
			fileName = "frontend";
		}
		List<String> backendList = CrewInfoReader.readCrewListByType(fileName+"-crew");
		Crew crewList = new Crew(course, backendList);

		List<String> shuffle = crewList.shuffleCrewList(course);
		randomMatching(shuffle);
		return shuffle;
	}

	private void randomMatching(List<String> list){
		int size = list.size();
		int idx = 0;
		while(size > idx){
			if((size-idx)/2==1 && (size-idx)%2 == 1){
				pair.getPair(list.get(idx),list.get(idx+1), list.get(idx+2));
				idx+= 3;
			}else{
				pair.getPair(list.get(idx),list.get(idx+1));
				idx += 2;
			}
		}
	}
}
