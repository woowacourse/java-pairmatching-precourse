package pairmatching.view;

import static pairmatching.constant.ViewMessage.*;

import pairmatching.domains.programfunc.ProgramSelection;

public class OutputView {

	public static void printSelection() {
		System.out.println(SELECTION_MESSAGE);
		for (ProgramSelection selection : ProgramSelection.values()) {
			String selectForm = selection.getSelectForm();
			System.out.println(selectForm);
		}
	}

	public static void breakLine() {
		System.out.println();
	}
}
