package pairmatching.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import pairmatching.domain.Crew;
import pairmatching.domain.Match;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatch;
import pairmatching.util.FileInputUtils;

public class PairMatchRepository {

	private static List<PairMatch> pairMatches = new ArrayList<>();

	public static List<PairMatch> pairMatches() {
		return pairMatches;
	}

	public static PairMatch addPairMatches(Match match, List<Crew> crews) {
		List<Pair> pairs = makePairs(crews);
		PairMatch pairMatch = new PairMatch(match, pairs);
		pairMatches.add(pairMatch);
		return pairMatch;
	}

	private static List<Pair> makePairs(List<Crew> crews) {
		List<Pair> pairs = new LinkedList<>();
		Queue<Crew> queue = getCrewTempQueue(crews);
		while (!queue.isEmpty()) {
			Crew crewOne = queue.poll();
			Crew crewAnother = queue.poll();
			if (isRemainingCrewNumberThree(queue)) {
				Crew crewThird  = queue.poll();
				Pair pair = new Pair(crewOne, crewAnother, crewThird);
				pairs.add(pair);
			}
			Pair pair = new Pair(crewOne, crewAnother);
			pairs.add(pair);
		}
		return pairs;
	}

	private static Queue<Crew> getCrewTempQueue(List<Crew> crews) {
		Queue<Crew> queue = new LinkedList<>();
		for (Crew crew : crews) {
			queue.offer(crew);
		}
		return queue;
	}

	private static boolean isRemainingCrewNumberThree(Queue<Crew> queue) {
		return queue.size() == 3;
	}

	public static PairMatch getPairMatches(Match match) {
		return pairMatches.stream()
			.filter(pairMatch -> pairMatch.getMatch().equals(match))
			.findAny()
			.orElseGet(() -> null);
	}
}
