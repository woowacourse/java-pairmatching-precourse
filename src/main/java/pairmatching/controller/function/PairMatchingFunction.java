package pairmatching.controller.function;

import static pairmatching.utils.Constants.*;
import static pairmatching.utils.validator.InputValidator.*;
import static pairmatching.view.InputView.*;
import static pairmatching.view.OutputView.*;

import java.util.Arrays;

import pairmatching.domain.PairMatching;
import pairmatching.domain.repository.PairMatchingRepository;
import pairmatching.service.PairMatchingService;

public enum PairMatchingFunction {
	PAIR_MATCHING("1") {
		@Override
		void function() {
			try{
				printPairMatchingScreen();
				String[] splitPairMatching = inputPairMatching().split(",");
				String course = splitPairMatching[0].trim();
				String level = splitPairMatching[1].trim();
				String mission = splitPairMatching[2].trim();
				validateInputPairMatching(course, level, mission);
				if (PairMatchingRepository.isExistPairMatching(course, level, mission)) {
					if (inputRequestRematching().equals("네")) {
						PairMatchingService.pairReMatching(course, level, mission);
					}
					return;
				}
				PairMatchingService.pairMatching(course, level, mission);
			}catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(illegalArgumentException.getMessage());
				function();
			}
		}
	},
	PAIR_FIND("2") {
		@Override
		void function() {
			try{
				printPairMatchingScreen();
				String[] splitPairMatching = inputPairMatching().split(",");
				String course = splitPairMatching[0].trim();
				String level = splitPairMatching[1].trim();
				String mission = splitPairMatching[2].trim();
				PairMatching pairMatching = PairMatchingRepository.find(course, level, mission);
				printPairMatchingResult(pairMatching.getPairMatchingResult());
			} catch (IllegalArgumentException illegalArgumentException){
				System.out.println(illegalArgumentException.getMessage());
				function();
			}
		}
	},
	PAIR_RESET("3") {
		@Override
		void function() {
			PairMatchingRepository.reset();
			printFinishPairMatchingRepositoryReset();
		}
	},
	QUIT("Q") {
		@Override
		void function() {

		}
	};

	private String command;

	abstract void function();

	PairMatchingFunction(String command) {
		this.command = command;
	}

	public static PairMatchingFunction findFunction(String command) {
		return Arrays.stream(values())
			.filter(function -> function.command.equals(command))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE + "올바르지 않은 명령어 입니다."));
	}

	public void apply() {
		function();
	}

	public boolean isQuit() {
		return this == QUIT;
	}
}
