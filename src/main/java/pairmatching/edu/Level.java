package pairmatching.edu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Level {
	LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
	LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
	LEVEL3("레벨3", Arrays.asList("")),
	LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
	LEVEL5("레벨5", Arrays.asList(""));

	private String name;
	private List<String> missionList;

	Level(String name, List<String> missionList) {
		this.name = name;
		this.missionList = missionList;
	}

	public List<String> getMissionList() {
		return missionList;
	}

	public String getName() {
		return name;
	}

	public static Level findByName(String name) {
		return Arrays.stream(Level.values())
			.filter(n -> n.getName().equals(name))
			.collect(Collectors.toList())
			.get(0);
	}

	public static boolean isMission(Level level, String name) {
		int size = level.getMissionList()
			.stream()
			.filter(m -> m.equals(name))
			.collect(Collectors.toList())
			.size();
		if (size > 0) {
			return true;
		}
		return false;
	}
	
}
