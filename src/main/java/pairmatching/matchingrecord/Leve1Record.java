package pairmatching.matchingrecord;

import java.util.ArrayList;

public class Leve1Record {
	ArrayList<ArrayList<String>> racingCar = null;
	ArrayList<ArrayList<String>> lotto = null;
	ArrayList<ArrayList<String>> baseballGame = null;

	public static boolean isRacingCarRecord = false;
	public static boolean isLottoRecord = false;
	public static boolean isBaseballGameRecord = false;

	public void setMission(String mission, ArrayList<ArrayList<String>> matchResult) {
		if (mission.equals("자동차경주")) {
			setRacingCar(matchResult);
			return;
		}
		if (mission.equals("로또")) {
			setLotto(matchResult);
			return;
		}
		if (mission.equals("숫자야구게임")) {
			setBaseballGame(matchResult);
		}

	}

	public void setRacingCar(ArrayList<ArrayList<String>> matchResult) {
		this.racingCar = matchResult;
	}

	public void setLotto(ArrayList<ArrayList<String>> matchResult) {
		this.lotto = matchResult;
	}

	public void setBaseballGame(ArrayList<ArrayList<String>> matchResult) {
		this.baseballGame = matchResult;
	}

	public ArrayList<ArrayList<String>> getRacingCarResult() {
		return racingCar;
	}

	public ArrayList<ArrayList<String>> racingCarResult() {
		return lotto;

	}

	public ArrayList<ArrayList<String>> lottoResult() {
		return baseballGame;
	}

	public ArrayList<ArrayList<ArrayList<String>>> getLevel1Record() {
		ArrayList<ArrayList<ArrayList<String>>> level1Record = new ArrayList<>();

		level1Record.add(racingCar);
		level1Record.add(lotto);
		level1Record.add(baseballGame);

		return level1Record;
	}

}
