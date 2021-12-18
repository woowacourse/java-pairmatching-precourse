package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pairmatching.domain.Member;
import pairmatching.domain.Pair;
import pairmatching.domain.PairInfoDto;

public class PairRepository {
	private Long id = 0L;
	private Map<Long, Pair> pairs = new HashMap<>();

	public Long save(Pair pair) {
		pairs.put(id, pair);
		return id++;
	}

	public void addLastPair(Member member) {
		pairs.get(id - 1).addMember(member);
	}

	public List<Pair> findPairs(PairInfoDto pairInfoDto) {
		return pairs.values().stream()
			.filter(pair -> pair.getMission() == pairInfoDto.getMission())
			.filter(pair -> pair.getCourse() == pairInfoDto.getCourse())
			.collect(Collectors.toList());
	}

	public Boolean isDuplicatedPair(Pair pair) {
		for (Pair pairValue : pairs.values()) {
			if (isSameLevel(pair, pairValue) && pairValue.isContainMembers(pair.getMembers())) {
				return true;
			}
		}
		return false;
	}

	private boolean isSameLevel(Pair pair, Pair pairValue) {
		return pairValue.getLevel() == pair.getLevel();
	}

	public void initializePairs() {
		pairs = new HashMap<>();
	}
}
