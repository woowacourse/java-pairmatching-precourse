package pairmatching.Model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import pairmatching.util.Symbol;

public enum Level {
	LEVEL1("레벨1", Arrays.asList("자동차경주","로또","숫자야구게임")),
	LEVEL2("레벨2",Arrays.asList("장바구니","결제","지하철노선도")),
	LEVEL3("레벨3",Arrays.asList()),
	LEVEL4("레벨4",Arrays.asList("성능개선","배포")),
	LEVEL5("레벨5",Arrays.asList());

	private String name;
	private List<String> missions;

	Level(String name,List<String> missions) {
		this.name = name;
		this.missions = missions;
	}

	public static String getLevelInfo(){
		StringBuilder builder = new StringBuilder();
		builder.append("미션:\n");
		Arrays.stream(Level.values()).forEach(l -> builder.append(Level.changeListToString(l) + Symbol.NEW_LINE));
		return builder.toString();
	}

	public static String changeListToString(Level level){
		StringJoiner stringJoiner = new StringJoiner(" | ");
		level.missions.stream().forEach(s -> stringJoiner.add(s));
		return String.format("  - %s: %s",level.name,stringJoiner.toString());
	}
}
