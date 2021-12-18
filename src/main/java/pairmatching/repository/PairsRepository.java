package pairmatching.repository;

import java.util.LinkedList;
import java.util.List;

import pairmatching.domain.pair.Pairs;

public class PairsRepository {
	private static final List<Pairs> pairsList = new LinkedList<>();

	public static void create(Pairs pairs) {
		// TODO: 과정, 레벨, 미션이 이미 등록돼있는지 검사해야함
		pairsList.add(pairs);
		System.out.println(pairsList);
	}
}
