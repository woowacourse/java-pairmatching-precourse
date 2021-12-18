package pairmatching.controller;

public class InputValidator {
	public static boolean isValidFunctionNum(String num) {
		if (num.equals("1") || num.equals("2") || num.equals("3") || num.equals("Q")) {
			return true;
		}
		throw new IllegalArgumentException();
	}
}
