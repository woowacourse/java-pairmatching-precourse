package pairmatching.service;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Level;
import pairmatching.domain.Match;
import pairmatching.domain.MatchRepository;
import pairmatching.domain.MatchingInformation;
import pairmatching.domain.Pair;

public class MatchService {
	public static boolean isDuplicatedPair(Level level) {
		List<Match> matchesByLevel = MatchRepository.findMatchesByLevel(level);
		return countDuplicated(findAllPairMatches(matchesByLevel));
	}

	private static List<Pair> findAllPairMatches(List<Match> matchesByLevel) {
		List<Pair> allPairPerLevel = new ArrayList<>();
		matchesByLevel.stream().forEach(match -> match.getPairList().addAll(allPairPerLevel));
		return allPairPerLevel;
	}

	private static boolean countDuplicated(List<Pair> pairList) {
		return pairList.size() != pairList.stream().distinct().count();
	}

	public static boolean isContainInformation(MatchingInformation information) {
		return MatchRepository.hasInformationLike(information);
	}
}
