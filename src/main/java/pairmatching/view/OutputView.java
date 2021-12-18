package pairmatching.view;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OutputView {
	public static void printPairCrews(Set<List> pairCrews){
		System.out.println("페어 매칭 결과입니다.");
		Iterator iterator = pairCrews.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
