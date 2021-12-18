package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
	private static final String PAIR_MATCHING = "1";
	private static final String FIND_PAIR = "2";
	private static final String INITIALIZE_PAIR = "3";
	private static final String EXIT = "Q";

	public static List<String> getAllMenus() {
		return new ArrayList<>(Arrays.asList(
			PAIR_MATCHING, FIND_PAIR, INITIALIZE_PAIR, EXIT
		));
	}
}
