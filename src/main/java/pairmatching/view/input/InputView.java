package pairmatching.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.FunctionChoice;
import pairmatching.domain.YesOrNo;
import pairmatching.dto.MatchDto;
import pairmatching.exception.InputIsNotCorrectException;

public class InputView {

	public FunctionChoice requestFunctionChoice() {
		String inputString = Console.readLine();
		return FunctionChoice.of(inputString.trim());
	}

	public MatchDto requestMatchDto() {
		String inputString = Console.readLine();
		return convertStringToMatchDto(inputString);
	}

	private MatchDto convertStringToMatchDto(String inputString) {
		inputString = Delimiter.appendSpaceBehind(inputString);
		List<String> informations = Arrays.stream(Delimiter.splitWithComma(inputString))
			.map(String::trim).collect(Collectors.toList());
		return getValidMatchDto(informations);
	}

	private MatchDto getValidMatchDto(List<String> informations) {
		checkSize(informations);
		String courseName = informations.get(0);
		String levelName = informations.get(1);
		String missionName = informations.get(2);
		return new MatchDto(courseName, levelName, missionName);
	}

	private void checkSize(List<String> informations) {
		if (informations.size() != 3) {
			throw new InputIsNotCorrectException();
		}
	}

	public YesOrNo requestYesOrNo() {
		String inputString = Console.readLine();
		return YesOrNo.of(inputString.trim());
	}


}
