package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.view.OutputView;

public class Pair {

	public Function function;
	// 과정, 레벨, 미션

	public Pair(int num) {
		function = new Function(num);
		OutputView.printProcessMissionLevel();
	}

	public void takeInformation(String[] information) throws IOException {
		function.handleFunction(information);
	}





}
