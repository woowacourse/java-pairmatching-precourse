package pairmatching.service;

import java.util.List;

import pairmatching.domain.Member;
import pairmatching.domain.Pair;
import pairmatching.domain.PairInfoDto;
import pairmatching.repository.PairRepository;

public class PairService {
	private final PairRepository pairRepository = new PairRepository();

	public Long save(Pair pair) {
		return pairRepository.save(pair);
	}

	public Pair findById(Long id) {
		return pairRepository.findById(id);
	}

	public void addLastPair(Member member) {
		pairRepository.addLastPair(member);
	}

	public List<Pair> findPairs(PairInfoDto pairInfoDto) {
		return pairRepository.findPairs(pairInfoDto);
	}

	public Boolean isDuplicatedPair(Pair pair) {
		return pairRepository.isDuplicatedPair(pair);
	}
}
