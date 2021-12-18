package pairmatching.domain;

import java.util.List;

public class PairMatching {
	public final Level level;
	public final List<Crew> matchCrews;

	public PairMatching(Level level, List<Crew> matchCrews) {
		this.level = level;
		this.matchCrews = matchCrews;
	}
}
