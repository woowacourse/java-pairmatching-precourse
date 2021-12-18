package pairmatching.maching;

import java.util.ArrayList;
import java.util.List;

import pairmatching.edu.Level;

public class MachingRepository {
	private static final List<Maching> machingList = new ArrayList<>();

	public static List<Maching> machingList() {
		return (machingList);
	}

	public static void addMathing(Maching maching) {
		machingList.add(maching);
	}

	public static void findByLevel(Level level) {

	}

}
