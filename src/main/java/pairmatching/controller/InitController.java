package pairmatching.controller;

import pairmatching.model.LevelSaver;
import pairmatching.view.OutputView;

public class InitController {

	public static void initPair() {
		LevelSaver.LEVEL_SAVER.initPair();
		OutputView.InitOutput();
	}
}
