package pairmatching.service;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Level;
import pairmatching.domain.Match;
import pairmatching.domain.MatchRepository;
import pairmatching.domain.MatchingInformation;
import pairmatching.domain.Pair;

public class MatchService {
	public static boolean isDuplicatedPair(Level level, List<Pair> pairList) {
		List<Match> matchesByLevel = MatchRepository.findMatchesByLevel(level);
		return countDuplicated(pairList, findAllPairMatches(matchesByLevel));
	}

	private static List<Pair> findAllPairMatches(List<Match> matchesByLevel) {
		List<Pair> allPairPerLevel = new ArrayList<>();
		matchesByLevel.stream().forEach(match -> allPairPerLevel.addAll(match.getPairList()));
		return allPairPerLevel;
	}

	private static boolean countDuplicated(List<Pair> pairList, List<Pair> allPairs) {
		return pairList.stream().filter(pair -> checkPairinPairList(pair, allPairs)).count() >= 1;
	}

	private static boolean checkPairinPairList(Pair comparePair, List<Pair> pairList) {
		return pairList.stream().anyMatch(pair -> Pair.duplicatedPairs(pair, comparePair));
	}
	public static boolean isContainInformation(MatchingInformation information) {
		return MatchRepository.hasInformationLike(information);
	}
}
