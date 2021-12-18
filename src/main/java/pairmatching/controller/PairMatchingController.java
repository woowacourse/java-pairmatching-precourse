package pairmatching.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Menu;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairMatchingController {

	private static final String NO = "아니요";
	private static final String ERROR_NOT_FOUND_PAIR = "매칭 이력이 없습니다.";

	private Map<PairMatching, Pair> pairMap;
	private Crews crews;

	public PairMatchingController() {
		pairMap = new HashMap<>();
		crews = generateCrews();
	}

	public void run() {
		while (true) {
			Menu menu = selectMenu();
			if (menu.isFinish()) {
				break;
			}
			startSelectMenu(menu);
		}
	}

	private void startSelectMenu(Menu menu) {
		if (menu.isPairMatching()) {
			pairMatching();
			return;
		}
		if (menu.isFindPair()) {
			findPairByInputMenu();
			return;
		}
		if (menu.isInitialize()) {
			initialize();
		}
	}

	private void findPairByInputMenu() {
		try {
			OutputView.printFindPairByInputMenu();
			findPair(InputView.inputInformation());
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			findPairByInputMenu();
		}
	}

	private void initialize() {
		OutputView.PrintInitialize();
		pairMap = new HashMap<>();
	}

	private void pairMatching() {
		PairMatching matchingInformation = getPairMatchingInformation();
		if (pairMap.containsKey(matchingInformation)) {
			String yesOrNot = selectReMatchingOrPrint();
			if (yesOrNot.equals(NO)) {
				return;
			}
		}
		List<Crew> shuffledCrews = Randoms.shuffle(crews.findCrews(matchingInformation.getCourse()));
		Pair pair = new Pair(shuffledCrews);
		pairMap.put(matchingInformation, pair);
		findPair(matchingInformation);
	}

	private void findPair(PairMatching matchingInformation) {
		Pair pair = pairMap.get(matchingInformation);
		if (pair == null) {
			throw new IllegalArgumentException(ERROR_NOT_FOUND_PAIR);
		}
		pair.findPair();
	}

	private String selectReMatchingOrPrint() {
		try {
			OutputView.printReMatchingOrPrint();
			return InputView.inputSelectReMatchingOrPrint();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return selectReMatchingOrPrint();
		}
	}

	private PairMatching getPairMatchingInformation() {
		try {
			OutputView.printInputInformation();
			return InputView.inputInformation();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return getPairMatchingInformation();
		}
	}

	private Menu selectMenu() {
		try {
			OutputView.printInputMainMenu();
			return InputView.inputMenu();
		} catch (IllegalArgumentException exception) {
			OutputView.printException(exception);
			return selectMenu();
		}
	}

	private Crews generateCrews() {
		try {
			return InputView.generateCrews();
		} catch (IOException e) {
			e.printStackTrace();
			return generateCrews();
		}
	}
}
