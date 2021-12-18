package pairmatching.domain.level;

import java.util.ArrayList;
import java.util.List;

public class Levels {
	private static final String[] LEVEL1_MISSIONS = {"자동차경주", "로또", "숫자야구게임"};
	private static final String[] LEVEL2_MISSIONS = {"장바구니", "결제", "지하철노선도"};
	private static final String[] LEVEL3_MISSIONS = {};
	private static final String[] LEVEL4_MISSIONS = {"성능개선", "배포"};
	private static final String[] LEVEL5_MISSIONS = {};

	private final List<Level> levels = new ArrayList<>();

	private Levels() {
		levels.add(new Level(LEVEL1_MISSIONS));
		levels.add(new Level(LEVEL2_MISSIONS));
		levels.add(new Level(LEVEL3_MISSIONS));
		levels.add(new Level(LEVEL4_MISSIONS));
		levels.add(new Level(LEVEL5_MISSIONS));
	}

	private static final Levels instance = new Levels();

	public static Levels getInstance() {
		return instance;
	}

	public boolean contains(String mission) {
		return levels.stream().anyMatch(level -> level.contains(mission));
	}
}
