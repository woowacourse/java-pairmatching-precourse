package pairmatching.view;

import java.util.List;

public class OutputView {

	public static void printMainMenu(List<String> menu){
		System.out.println("기능을 선택하세요.");
		menu.stream().forEach(s -> System.out.println(s));
	}
}
