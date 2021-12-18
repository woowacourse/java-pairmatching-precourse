package pairmatching.controller;

import java.util.Scanner;

import pairmatching.View.InputView;

public class PairMatchingController {
	private final InputView inputView;

	public PairMatchingController() {
		inputView = new InputView(new Scanner(System.in));
	}

	public int scanFunctionNumber() {
		return inputView.scanFunctionNumber();
	}
}
