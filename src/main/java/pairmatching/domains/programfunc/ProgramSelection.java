package pairmatching.domains.programfunc;

import static pairmatching.constant.ErrorMessages.*;
import static pairmatching.constant.ViewMessage.*;

import java.util.Arrays;

public enum ProgramSelection {
	MATCHING("1", "페어 매칭"),
	FIND_ALL("2", "페어 조회"),
	CLEAR("3", "페어 초기화"),
	QUIT("Q", "종료"),
	;

	private String selection;
	private String info;

	ProgramSelection(String selection, String info) {
		this.selection = selection;
		this.info = info;
	}

	public static ProgramSelection findBySelection(String selection) {
		isEmptySelection(selection);
		return Arrays.stream(ProgramSelection.values())
			.filter(s -> s.selection.equals(selection))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(
				ERROR_PREFIX + SELECTION_NULL + LINE_BREAK
			));
	}

	private static void isEmptySelection(String selection) {
		if (selection.trim().isEmpty()) {
			throw new IllegalArgumentException(ERROR_PREFIX + SELECTION_NULL + LINE_BREAK);
		}
	}

	public String getSelectForm() {
		return selection + SELECTION_DOT + info;

	}
}
