package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Level {
	LEVEL_1("레벨1", 1),
	LEVEL_2("레벨2", 2),
	LEVEL_3("레벨3", 3),
	LEVEL_4("레벨4", 4),
	LEVEL_5("레벨5", 5);

	private String name;
	private int level;

	Level(String name, int level) {
		this.name = name;
		this.level = level;
	}

	public static Level findByName(String name){
		if(name.equalsIgnoreCase("레벨1")){
			return LEVEL_1;
		}else if(name.equalsIgnoreCase("레벨2")){
			return LEVEL_2;
		}else if(name.equalsIgnoreCase("레벨3")){
			return LEVEL_3;
		}else if(name.equalsIgnoreCase("레벨4")){
			return LEVEL_4;
		}else if(name.equalsIgnoreCase("레벨5")){
			return LEVEL_5;
		}
		throw new RuntimeException("해당 레벨은 없습니다.");
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public static List<Level> getLevelList() {
		return Stream.of(Level.values()).collect(Collectors.toList());
	}

}
