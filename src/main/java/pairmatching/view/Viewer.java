package pairmatching.view;

import pairmatching.model.Function;

import java.util.List;

public class Viewer {

	public void showFunctions() {
		System.out.println("기능을 선택하세요.");
		List<Function> functions = Function.getFunctions();
		for (Function function : functions) {
			System.out.println(function.toString());
		}
	}
}
