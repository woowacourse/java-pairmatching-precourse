package pairmatching.util;

import pairmatching.domain.Level;

public class LevelValidator {
	public static boolean validate(String level) {
		return level.equals(Level.LEVEL1.getName())
			|| level.equals(Level.LEVEL2.getName())
			|| level.equals(Level.LEVEL3.getName())
			|| level.equals(Level.LEVEL4.getName())
			|| level.equals(Level.LEVEL5.getName());
	}
}
