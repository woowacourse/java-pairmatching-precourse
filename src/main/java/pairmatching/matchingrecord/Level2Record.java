package pairmatching.matchingrecord;

import java.util.ArrayList;

public class Level2Record {

	ArrayList<ArrayList<String>> market = null;
	ArrayList<ArrayList<String>> pay = null;
	ArrayList<ArrayList<String>> subway = null;

	public static boolean isMarketRecord = false;
	public static boolean isPayRecord = false;
	public static boolean isSubwayRecord = false;

	public void setMission(String mission, ArrayList<ArrayList<String>> matchResult) {
		if (mission.equals("장바구니")) {
			setMarket(matchResult);
			return;
		}
		if (mission.equals("결제")) {
			setPay(matchResult);
			return;
		}
		if (mission.equals("지하철노선도")) {
			setSubway(matchResult);
			return;
		}

	}

	public void setMarket(ArrayList<ArrayList<String>> matchResult) {
		this.market = matchResult;
	}

	public void setPay(ArrayList<ArrayList<String>> matchResult) {
		this.pay = matchResult;
	}

	public void setSubway(ArrayList<ArrayList<String>> matchResult) {
		this.subway = matchResult;
	}

	public ArrayList<ArrayList<ArrayList<String>>> getLevel2Record() {
		ArrayList<ArrayList<ArrayList<String>>> level2Record = new ArrayList<>();

		level2Record.add(market);
		level2Record.add(pay);
		level2Record.add(subway);

		return level2Record;
	}
}
