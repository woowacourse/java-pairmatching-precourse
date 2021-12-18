package pairmatching.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.Factory;
import pairmatching.util.ErrorMessage;
import pairmatching.util.Symbol;

public class Mission {
	private Course course;
	private Level level;
	private String name;
	private List<Pair> pairList;

	public Mission(Course course, Level level, String name) {
		this.course = course;
		this.level = level;
		this.name = name;
		pairList = new ArrayList<>();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Mission) {
			return equals((Mission)obj);
		}
		return false;
	}

	public boolean equals(Mission mission) {
		return this.course == mission.course && this.level == mission.level && this.name.equals(mission.name);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this);
	}

	public void pairMatching() {
		Factory factory = new Factory();
		if (this.course == Course.BACKEND) {
			backendMatching(factory);
		}
		frontendMatching(factory);

	}

	private void backendMatching(Factory factory) {
		List<String> shuffledList = Randoms.shuffle(factory.getBackEndCrewList());
		while (!shuffledList.isEmpty()) {
			if (shuffledList.size() == 1) {
				pairList.get(pairList.size() - 1).addPair(shuffledList.remove(0));
				return;
			}
			pairList.add(new Pair(Arrays.asList(shuffledList.remove(0), shuffledList.remove(0))));
		}
	}

	private void frontendMatching(Factory factory) {
		List<String> shuffledList = Randoms.shuffle(factory.getFrontEndCrewList());
		while (!shuffledList.isEmpty()) {
			if (shuffledList.size() == 1) {
				List<String> member = pairList.remove(pairList.size() - 1).getMember();
				pairList.add(new Pair(Arrays.asList(member.get(0), member.get(1), shuffledList.remove(0))));
				return;
			}
			pairList.add(new Pair(Arrays.asList(shuffledList.remove(0), shuffledList.remove(0))));
		}
	}

	public boolean pairingComplete(){
		if(pairList.size() == 0){
			throw new IllegalArgumentException(ErrorMessage.NOT_MATCHING_MISSION.getMessage() + Symbol.NEW_LINE);
		}
		return true;
	}

	public void resetMission(){
		this.pairList = new ArrayList<>();
	}

	public String getPairMatchingResult() {
		StringBuilder builder = new StringBuilder();
		builder.append("페어 매칭 결과입니다.\n");
		pairList.stream().forEach(p -> builder.append(p.toString() + Symbol.NEW_LINE));
		return builder.toString();
	}

}


