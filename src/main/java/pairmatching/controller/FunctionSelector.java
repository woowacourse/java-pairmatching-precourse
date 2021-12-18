package pairmatching.controller;

import static pairmatching.constant.FunctionStatus.*;

import pairmatching.constant.FunctionStatus;

public class FunctionSelector {
	public FunctionStatus getByString(String input) {
		if (input.equals("1")) {
			return  PAIR_MATCHING;
		}
		if (input.equals("2")) {
			return PAIR_SEARCH;
		}
		if (input.equals("3")) {
			return PAIR_CLEAR;
		}
		if (input.equals("Q")) {
			return EXIT;
		}
		return INVALID_INPUT;
	}
}
