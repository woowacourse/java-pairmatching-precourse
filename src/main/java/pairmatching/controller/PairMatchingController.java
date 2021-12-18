package pairmatching.controller;

import java.io.IOException;

import pairmatching.domain.Crews;
import pairmatching.view.InputView;

public class PairMatchingController {

	public void run() {
		Crews crews = generateCrews();

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
