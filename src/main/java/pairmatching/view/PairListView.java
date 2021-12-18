package pairmatching.view;

import pairmatching.constant.Message;
import pairmatching.model.PairList;

public class PairListView {

	public void print(PairList pairList) {
		StringBuilder stringBuilder = new StringBuilder(Message.OUTPUT_PAIR_MATCHING);

		for (String pair : pairList.getPairList()) {
			stringBuilder.append("\n" + pair);
		}

		System.out.println(stringBuilder + "\n");
	}
}
