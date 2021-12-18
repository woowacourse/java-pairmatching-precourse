package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;

import pairmatching.domain.Pairs;

public class PairRepository {
	public static List<Pairs> backPairs = new ArrayList<>();
	public static List<Pairs> frontPairs = new ArrayList<>();

	public static void reset() {
		backPairs = new ArrayList<>();
		frontPairs = new ArrayList<>();
	}
}
